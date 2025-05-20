package com.spotyweb.service;

import okhttp3.*;
import com.google.gson.*;

import java.io.IOException;
import java.util.*;

public class SpotifyService {
    private static final String CLIENT_ID = "e4e21225e22640baaab0a60b2b02b9a3";
    private static final String CLIENT_SECRET = "4895080488f447c88ae803d222155aee";

    private String accessToken;

    public SpotifyService() throws IOException {
        this.accessToken = getAccessToken();
    }

    private String getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String credentials = Credentials.basic(CLIENT_ID, CLIENT_SECRET);

        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .build();

        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .post(requestBody)
                .header("Authorization", credentials)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Errore nel recupero token: " + response.code());
            }
            String responseBody = response.body().string();
            JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();
            return json.get("access_token").getAsString();
        }
    }

    public List<Map<String, String>> searchSongs(String query) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.spotify.com/v1/search?q=" + query + "&type=track&limit=10";

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + accessToken)
                .build();

        Response response = client.newCall(request).execute();
        List<Map<String, String>> results = new ArrayList<>();

        if (response.isSuccessful()) {
            String body = response.body().string();
            JsonObject json = JsonParser.parseString(body).getAsJsonObject();
            JsonArray items = json.getAsJsonObject("tracks").getAsJsonArray("items");

            for (JsonElement item : items) {
                JsonObject track = item.getAsJsonObject();
                String name = track.get("name").getAsString();
                String artist = track.getAsJsonArray("artists").get(0).getAsJsonObject().get("name").getAsString();

                Map<String, String> song = new HashMap<>();
                song.put("name", name);
                song.put("artist", artist);
                results.add(song);
            }
        }

        return results;
    }
}

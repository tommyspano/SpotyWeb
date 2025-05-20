package com.spotyweb.model;

public class SongComment {
    private String songName;
    private String artistName;
    private String username;
    private String comment;

    public SongComment(String songName, String artistName, String username, String comment) {
        this.songName = songName;
        this.artistName = artistName;
        this.username = username;
        this.comment = comment;
    }

    public String getSongName() { return songName; }
    public String getArtistName() { return artistName; }
    public String getUsername() { return username; }
    public String getComment() { return comment; }
}

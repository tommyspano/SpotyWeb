package com.spotyweb.servlet;

import com.spotyweb.service.SpotifyService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String query = request.getParameter("query");

        try {
            SpotifyService spotifyService = new SpotifyService();
            List<Map<String, String>> results = spotifyService.searchSongs(query);

            request.setAttribute("results", results);
            request.getSession().setAttribute("lastSearch", results);
            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (IOException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<h3 style='color:red;'>Errore durante l'accesso alle API Spotify.</h3>");
        }
    }
}

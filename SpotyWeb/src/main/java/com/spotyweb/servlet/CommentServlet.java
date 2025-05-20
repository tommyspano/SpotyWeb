package com.spotyweb.servlet;

import com.spotyweb.model.SongComment;
import com.spotyweb.db.DatabaseManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("index"));
        String username = request.getParameter("username");
        String comment = request.getParameter("comment");

        List<Map<String, String>> lastSearch = (List<Map<String, String>>) request.getSession().getAttribute("lastSearch");
        Map<String, String> selected = lastSearch.get(index);

        SongComment songComment = new SongComment(
                selected.get("name"),
                selected.get("artist"),
                username,
                comment
        );

        new DatabaseManager().insertComment(songComment);
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Commento salvato con successo!</h2>");
        response.getWriter().println("<form action='index.jsp'><button type='submit'>Torna alla Home</button></form>");
        response.getWriter().println("</body></html>");
    }
}

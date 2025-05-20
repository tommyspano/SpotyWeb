package com.spotyweb.db;

import com.spotyweb.model.SongComment;
import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/spotyweb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void insertComment(SongComment comment) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO comments (song, artist, username, comment) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, comment.getSongName());
            stmt.setString(2, comment.getArtistName());
            stmt.setString(3, comment.getUsername());
            stmt.setString(4, comment.getComment());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

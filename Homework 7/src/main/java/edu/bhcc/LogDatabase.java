package edu.bhcc;

import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogDatabase {

    private static final String DB_URL = "jdbc:sqlite:logger.db";

    public LogDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load SQLite driver", e);
        }
    }

    public void init() {
        String sql = """
                CREATE TABLE IF NOT EXISTS logs (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    timestamp TEXT NOT NULL,
                    message   TEXT NOT NULL
                )
                """;
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }

    public void insert(String message) {
        String sql = "INSERT INTO logs(timestamp, message) VALUES (?, ?)";

        String ts = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ts);
            ps.setString(2, message);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Insert failed", e);
        }
    }

    public List<Log> findAll() {
        List<Log> list = new ArrayList<>();
        String sql = "SELECT timestamp, message FROM logs ORDER BY id ASC";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String ts = rs.getString("timestamp");
                String msg = rs.getString("message");
                list.add(new Log(ts, msg));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Query failed", e);
        }

        return list;
    }
}

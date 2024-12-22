package main.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Leaderboard {

    // Method to fetch leaderboard data for a specific difficulty
    public List<String[]> getLeaderboard(String difficulty) throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }

        // SQL query string with difficulty inserted directly (no prepared statements)
        String query = String.format("""
                SELECT p.player_name, SUM(s.score) AS total_score
                FROM players p 
                JOIN sessions s ON p.player_id = s.player_id
                WHERE LOWER(s.difficulty) = '%s'
                GROUP BY p.player_name
                ORDER BY total_score DESC
                FETCH FIRST 5 ROWS ONLY;
                """, difficulty.toLowerCase());

        // Execute the query
        ResultSet resultSet = statement.executeQuery(query);

        List<String[]> leaderboard = new ArrayList<>();
        while (resultSet.next()) {
            String playerName = resultSet.getString("player_name");
            int totalScore = resultSet.getInt("total_score");
            leaderboard.add(new String[]{playerName, String.valueOf(totalScore)});
        }

        return leaderboard;
    }
}

package main.database;

import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public void insertPlayer(String playerName, String joinDate, String email) throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }

        String insertQuery = String.format(
                "INSERT INTO players (player_name, join_date, email) VALUES ('%s', '%s', '%s');",
                playerName, joinDate, email
        );

        try {
            int rowsAffected = statement.executeUpdate(insertQuery);
            if (rowsAffected > 0) {
                System.out.println("Player added successfully.");
            } else {
                System.out.println("No rows were inserted.");
            }
        } catch (SQLException e) {
            System.err.println("Error while inserting player: " + e.getMessage());
            throw e; // Rethrow exception for further handling if needed
        }
    }

}

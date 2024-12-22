package main.database;

import java.sql.*;

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
    /**
     * Saves the game state to the database.
     *
     * This method inserts data into the 'sessions' table.
     *
     * @param savedGame The SavedGame object containing the game state information.
     */
    public static void saveGameState(SavedGame savedGame) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement sessionStmt = connection.prepareStatement(
                     "INSERT INTO sessions (sessions_id) VALUES (?)")) {

            sessionStmt.setInt(1, savedGame.getPlayerId()); // Assuming you have player_id in SavedGame
            sessionStmt.setInt(2, savedGame.getLevelId());
            sessionStmt.setInt(3, savedGame.getNumberOfMoves());
            sessionStmt.setString(4, savedGame.getBoardState());
            sessionStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error saving game state: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

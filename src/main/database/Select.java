package main.database;

import main.game.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    public Player getPlayerInfoByEmail(String email) throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }

        String selectQuery = String.format(
                "SELECT player_id, player_name, join_date, email FROM players WHERE email = '%s';",
                email
        );

        try {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                int playerId = resultSet.getInt("player_id");
                String playerName = resultSet.getString("player_name");
                String joinDate = resultSet.getString("join_date");
                String playerEmail = resultSet.getString("email");

                //String userName, int score, String joinDate, String email
                return new Player(
                        playerId,
                        playerName,
                        0,
                        joinDate,
                        playerEmail
                );
            }else {
                System.out.println("No player found with the given email.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching player info: " + e.getMessage());
            throw e; // Rethrow exception for further handling if needed
        }
    }
}

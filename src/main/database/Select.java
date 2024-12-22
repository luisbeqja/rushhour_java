package main.database;

import main.game.Player;
import main.game.board.Board;
import main.game.gamesession.GameSession;

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

    public GameSession getGameSessionByPlayerId(int playerId) throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }
        String selectQuery = String.format("SELECT sessions_id, player_id, start_date, end_date, total_turns, score, difficulty, duration FROM sessions WHERE player_id = %s; ", playerId);
        try {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {

                String sessions_id = resultSet.getString("sessions_id");
                String player_id = resultSet.getString("player_id");
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");
                String total_turns = resultSet.getString("total_turns");
                String score = resultSet.getString("score");
                String difficulty = resultSet.getString("difficulty");
                String duration = resultSet.getString("duration");

                //String userName, int score, String joinDate, String email
                GameSession session = new GameSession(
                    start_date,
                    end_date, 
                    total_turns,
                    score,
                    difficulty,
                    duration,
                    sessions_id,
                    player_id
                );
                return session;
            }else {
                System.out.println("No player found with the given email.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching player info: " + e.getMessage());
            throw e; // Rethrow exception for further handling if needed
        }
    }


    public Board getBoardStateBySessionId(String sessionId) throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }
        String selectQuery = String.format("SELECT session_id, game_row, game_column, cell_value FROM boardstates WHERE session_id = %s;", sessionId);
        try {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            
            if (resultSet.next()) {
                System.out.println(resultSet.getString("game_row"));

                Board board = new Board(false);
                return board;
            } else {
                System.out.println("No board state found for session ID: " + sessionId);
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching board state: " + e.getMessage());
            throw e;
        }
    }
}

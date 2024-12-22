package main.database;

import main.game.GameContext;
import main.game.Player;
import main.game.board.Board;
import main.game.board.BoardRules;
import main.game.board.Vehicle;
import main.game.gamesession.GameSession;
import main.game.gameviews.pages.GamePage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching player info: " + e.getMessage());
            throw e; // Rethrow exception for further handling if needed
        }
    }


    public boolean getBoardStateBySessionId(String sessionId, GameContext context) throws SQLException {
        Statement statement = DatabaseConnection.createStatement();
        if (statement == null) {
            throw new SQLException("Failed to create statement for DB operation.");
        }
        String selectQuery = String.format("SELECT session_id, game_row, game_column, cell_value FROM boardstates WHERE session_id = %s;", sessionId);
        try {
            ResultSet resultSet = statement.executeQuery(selectQuery);

            if (!resultSet.isBeforeFirst()) {
                System.out.println("No board state found for session ID: " + sessionId);
                return false;
            } else {
                Map<String, Vehicle> loadedlevel = new HashMap<>();
                Map<String, List<int[]>> tempPositions = new HashMap<>();

                while (resultSet.next()) {
                    String cellValue = resultSet.getString("cell_value");
                    if (cellValue != null) {
                        int row = resultSet.getInt("game_row")-1;
                        int column = resultSet.getInt("game_column")-1;

                        tempPositions.putIfAbsent(cellValue, new ArrayList<>());
                        tempPositions.get(cellValue).add(new int[]{row, column});
                    }
                }

                // the problem is that we have positions as int[][] so we cannot input into them
                // so for now it's easier to implement temporary map with list
                // than changing every int[][] to list =)))
                for (Map.Entry<String, List<int[]>> entry: tempPositions.entrySet()) {
                    String cellValue = entry.getKey();
                    List<int[]> positionsList = entry.getValue();

                    int[][] positions = positionsList.toArray(new int[0][0]);

                    if (!cellValue.equals("0")) {
                        loadedlevel.put(cellValue, new Vehicle(cellValue, positions));
                    }
                }
                Board board = new Board(false);
                context.setState(new GamePage(loadedlevel));
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching board state: " + e.getMessage());
            throw e;
        }
    }
}

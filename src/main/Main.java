package main;

import main.database.Create;
import main.database.DatabaseConnection;
import main.game.board.Board;
import main.game.GameSession;
import main.game.LeaderBoard;
import main.game.Player;
import main.game.board.BoardLevels;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Board board = new Board(false);
        Player playerTest = new Player(
                "test_player",
                200
        );
        LeaderBoard leaderBoard = new LeaderBoard(playerTest);

        GameSession gameSession = new GameSession(
                playerTest,
                board,
                leaderBoard
        );

        // TEST THE DATABASE CONNECTION
        Create create = new Create();

        // NOTE: create a test table for player
        create.createPlayerTable();
        DatabaseConnection.getConnection();

        // NOTE: print out the board
        System.out.println(board);
    }
}
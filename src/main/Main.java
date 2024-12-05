package main;

import main.database.Create;
import main.database.DatabaseConnection;
import main.game.Board;
import main.game.GameSession;
import main.game.LeaderBoard;
import main.game.Player;

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

        // TEST THE CONNECTION
        Create create = new Create();
        create.createPlayerTable();

        System.out.println(DatabaseConnection.getConnection());
        System.out.println(board);
    }
}
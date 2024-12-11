package main;

import main.database.Create;
import main.database.DatabaseConnection;
import main.game.board.Board;
import main.game.GameSession;
import main.game.LeaderBoard;
import main.game.Player;
import main.game.board.BoardRules;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Board board = new Board(false);

        Player playerTest = new Player(
                "test_player",
                200,
                "25/03/2025",
                "luis.beqja@test.com"
        );

        LeaderBoard leaderBoard = new LeaderBoard(playerTest);

        GameSession gameSession = new GameSession(
                0,
                "",
                ""
        );


        // TEST DATABASE CONNECTION
        DatabaseConnection.getConnection();
        Create create = new Create();
        create.createPlayerTable();

        BoardRules boardRules = new BoardRules(
                board.getVisualBoard()
        );
        //System.out.println(boardRules);


        // NOTE: print out the board
        System.out.println(board);
        System.out.println("Can Move " + BoardRules.canVehicleMoveRight("X", 2));
        System.out.println("Can Move " + BoardRules.canVehicleMoveLeft("X", 2));
    }
}
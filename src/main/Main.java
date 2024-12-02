package main;

import main.game.Board;
import main.game.GameSession;
import main.game.LeaderBoard;
import main.game.Player;

public class Main {
    public static void main(String[] args) {
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

        System.out.println(board);

    }
}
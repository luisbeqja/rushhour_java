package main.game;

import main.database.DatabaseConnection;
import main.game.board.Board;

public class GameSession {

    private Player player;
    private Board board;
    private LeaderBoard leaderBoard;


    DatabaseConnection databaseConnection = new DatabaseConnection();

    public GameSession( Player player, Board board, LeaderBoard leaderBoard ) {
        this.setPlayer(player);
        this.setBoard(board);
        this.setLeaderBoard(leaderBoard);
    }

    //GETTERS
    public Player getPlayer() {
        return player;
    }
    public Board getBoard() {
        return board;
    }
    public LeaderBoard getLeaderBoard() {
        return leaderBoard;
    }

    //SETTERS
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public void setLeaderBoard(LeaderBoard leaderBoard) {
        this.leaderBoard = leaderBoard;
    }
    
}

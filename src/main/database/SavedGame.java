package main.database;

import main.game.GameContext;
import main.game.gameviews.GameState;

import java.sql.SQLException;

public class SavedGame implements GameState {
    // Add member variables to store game state information
    // This could include board configuration, player moves, score, etc.
    private String board;
    private int playerMoves;
    private int score;
    private int levelId;
    // ... other game state variables

    // Implement methods from the GameState interface
    @Override
    public String getBoard() {
        return board;
    }

    @Override
    public void setBoard(String board) {
        this.board = board;
    }

    @Override
    public void render() {

    }

    @Override
    public void handleInput(GameContext context) throws SQLException {

    }

    public void setNumberOfMoves(int numberOfMoves) {
        this.playerMoves = numberOfMoves;
    }

    public void setlevelId(int levelId) {
        this.score = levelId;
    }

    public int getPlayerMoves() {
        return playerMoves;
    }

    public int getScore() {
        return score;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getNumberOfMoves() {
        return playerMoves;
    }

    public String getBoardState() {
        return board;
    }

    public int getPlayerId() {
        return playerMoves;
    }

    // Implement similar methods for other game state variables

}
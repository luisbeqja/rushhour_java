package main.game.gameviews;

import main.game.GameContext;

import java.sql.SQLException;

public interface GameState {
    // Implement methods from the GameState interface
    String getBoard();

    void setBoard(String board);

    void render();
    void handleInput(GameContext context) throws SQLException;
}

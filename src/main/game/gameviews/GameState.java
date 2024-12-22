package main.game.gameviews;

import main.game.GameContext;

import java.sql.SQLException;

public interface GameState {
    void render();
    void handleInput(GameContext context) throws SQLException;
}

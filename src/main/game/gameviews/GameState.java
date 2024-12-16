package main.game.gameviews;

import main.game.GameContext;

public interface GameState {
    void render();
    void handleInput(GameContext context);
}

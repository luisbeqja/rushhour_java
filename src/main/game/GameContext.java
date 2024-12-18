package main.game;

import main.game.gameviews.GameState;

import java.sql.SQLException;

public class GameContext {
    private GameState currentState;
    boolean winCheck = false;

    public void setState(GameState state) {
        this.currentState = state;
    }

    public void start() throws SQLException {
        while (!winCheck) {
            clearScreen();
            currentState.render(); // Render current state
            currentState.handleInput(this); // Handle input and transition
        }
    }

    // Function used to clear the console when the page is changed
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

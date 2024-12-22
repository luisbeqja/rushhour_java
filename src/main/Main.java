package main;
import main.database.Drop;
import main.game.GameContext;


import main.game.gameviews.pages.FirstPage;

import java.sql.SQLException;

import static main.game.board.BoardRules.winCheck;

public class Main {
    public static void main(String[] args) throws SQLException {
        Drop drop = new Drop();
        GameContext context = new GameContext();
        context.setState(new FirstPage()); // Start with Main Menu

        //TODO: remember to remove this in the final code
        //drop.dropTables();

        context.start(); // Begin game loop
    }

  /*  // Method to check for winning condition in the game
    private static boolean checkWinCondition() {
        return winCheck(); // Call the board's method to check if the winning condition is met
    }*/
}
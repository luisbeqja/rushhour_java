package main.game.gameviews.pages;

import main.game.GameContext;
import main.game.gameviews.GameState;
import main.game.gameviews.pages.leaderboards.EasyLeaderboard;
import main.game.gameviews.pages.leaderboards.HardLeaderboard;
import main.game.gameviews.pages.leaderboards.LeaderboardMenu;
import main.game.gameviews.pages.leaderboards.MediumLeaderboard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstPage implements GameState {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void render() {
        System.out.println("""
                Welcome to Rush Hour - by Superchicche
                --------------------------------------
                Make your choose by select one of the following options:
                
                1) Start a game
                2) Take a look to the tutorial
                3) Leaderboards
                4) Quit
                -------------------------------------
                """);
    }

    @Override
    public void handleInput(GameContext context) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                choice = scanner.nextInt();  // Read the user's choice
                scanner.nextLine();  // Clear the buffer (consume the newline character)

                // Now check the input
                if (choice == 1) {
                    context.setState(new SetUpPage()); // Switch to Gameplay State
                    validInput = true;  // Exit loop
                } else if (choice == 2) {
                    context.setState(new TutorialPage()); // Switch to Tutorial page
                    validInput = true;  // Exit loop
                } else if (choice == 3) {
                    context.setState(new LeaderboardMenu()); // Switch to Leaderboard page
                    validInput = true;  // Exit loop
                } else if (choice == 4) {
                    System.exit(0); // Exit game
                } else {
                    // Invalid input
                    System.out.println("That is not a valid input. Please try again.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Input is not a number. Please enter a valid option.");
                scanner.nextLine();  // Clear the buffer
            }
        }

        // TODO: implement tutorial page DONE :3
    }
}
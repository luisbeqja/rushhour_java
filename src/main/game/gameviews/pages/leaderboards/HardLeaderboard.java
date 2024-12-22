package main.game.gameviews.pages.leaderboards;

import main.game.DisplayLeaderboard;
import main.game.GameContext;
import main.game.gameviews.GameState;
import main.game.gameviews.pages.FirstPage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HardLeaderboard implements GameState {
    Scanner scanner = new Scanner(System.in);
    DisplayLeaderboard leaderboardDisplay = new DisplayLeaderboard();

    @Override
    public void render() {
        leaderboardDisplay.displayLeaderboard("hard");
    }

    @Override
    public void handleInput(GameContext context) {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                choice = scanner.nextInt();
                if (choice == 0) {

                    validInput = true;
                    context.setState(new FirstPage());
                } else {
                    System.out.println("That is not a valid input. Enter 0 to go back!");
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Input is not a number. Enter 0 to go back!");
                scanner.nextLine(); //clear buffer
            }
        }
    }
}
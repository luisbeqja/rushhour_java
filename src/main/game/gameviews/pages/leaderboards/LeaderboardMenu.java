package main.game.gameviews.pages.leaderboards;

import main.game.GameContext;
import main.game.gameviews.GameState;
import main.game.gameviews.pages.FirstPage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeaderboardMenu implements GameState {
    Scanner scanner = new Scanner(System.in);

    /**
     * @return
     */
    @Override
    public String getBoard() {
        return "";
    }

    /**
     * @param board
     */
    @Override
    public void setBoard(String board) {

    }

    @Override
    public void render() {
        System.out.println("""
                LEADERBOARDS - SELECT A DIFFICULTY
                ----------------------------------
                1) easy leaderboard
                2) medium leaderboard
                3) hard leaderboard
                ----------------------------------
                
                Make a selection (1, 2 or 3):
                (To go back enter 0)
                """);
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
                } else if (choice == 1) {

                    validInput = true;
                    context.setState(new EasyLeaderboard());
                } else if (choice == 2) {

                    validInput = true;
                    context.setState(new MediumLeaderboard());
                } else if (choice == 3) {

                    validInput = true;
                    context.setState(new HardLeaderboard());
                }else {
                    System.out.println("That is not a valid input.");
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Input is not a number. Enter 0 to go back!");
                scanner.nextLine(); //clear buffer
            }
        }
    }
}

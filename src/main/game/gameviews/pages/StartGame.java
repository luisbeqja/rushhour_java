package main.game.gameviews.pages;

import main.game.GameContext;
import main.game.gameviews.GameState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartGame implements GameState {


    @Override
    public void render() {
        System.out.print("""
Let's get started.
--------------------------------------
""");
    }

    @Override
    public void handleInput(GameContext context) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
        Select a level:
        1. (easy)
        2. (easy)
        3. (easy)
        4. (medium)
        5. (medium)
        6. (medium)
        7. (hard)
        8. (hard)
        9. (hard)
        Your choice:
        """);
        int levelId = 1;

        boolean validLevel = false;

        while (!validLevel) {
            try {
                levelId = (scanner.nextInt() - 1);

                if (levelId >= 0 && levelId <= 9) {
                    validLevel = true;
                    scanner.nextLine();
                } else {
                    System.out.println("That is not a valid level. Please select again: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("The input is not a number. Please select again: ");
                scanner.nextLine(); //clear buffer
            }
        }
        context.setState(new GamePage(levelId));
    }
}

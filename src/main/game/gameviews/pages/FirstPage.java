package main.game.gameviews.pages;

import main.game.GameContext;
import main.game.gameviews.GameState;

import java.util.Scanner;

public class FirstPage implements GameState {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void render() {
        System.out.println("""
                Welcome to Rush Hour - by Superchicche
                --------------------------------------
                Make your choose by select one of the following options:
                
                1) start a game
                2) take a look to the tutorial
                3) quit
                -------------------------------------
                """);
    }

    @Override
    public void handleInput(GameContext context) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            context.setState(new SetUpPage()); // Switch to Gameplay State
        } else if (choice == 3) {
            System.exit(0); // Exit game
        } else if (choice == 2) {
            context.setState(new TutorialPage()); //Switch to Tutorial page
        }

        // TODO: implement tutorial page DONE :3
    }
}
package main.game.gameviews.pages;

import main.game.GameContext;
import main.game.Player;
import main.game.gameviews.GameState;

import java.util.Scanner;

public class SetUpPage implements GameState {
    Scanner scanner = new Scanner(System.in);
    public SetUpPage() {}

    @Override
    public void render() {
        System.out.println("""
                Welcome to Rush Hour - by Superchicche
                --------------------------------------
                Ready to play !?
                --------------------------------------
                
                Do you already have an account? (Y, N).
                """);
    }

    @Override
    public void handleInput(GameContext context) {
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("What is your username? ");
            String username = scanner.nextLine();


            // TODO: get user info from the Database
            Player currentPlayer = new Player(
                    "LuisBeqja02",
                    1237,
                    "25/03/2002",
                    "luis@luis.com"
            );

            context.setState(new StartGame());
        } else if (choice.equalsIgnoreCase("N")) {
            context.setState(new CreatePlayer());
        }
    }

}

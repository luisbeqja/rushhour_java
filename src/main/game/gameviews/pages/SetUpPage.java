package main.game.gameviews.pages;

import main.database.Select;
import main.game.GameContext;
import main.game.Player;
import main.game.gameviews.GameState;

import java.sql.SQLException;
import java.util.Scanner;

public class SetUpPage implements GameState {
    Scanner scanner = new Scanner(System.in);
    public SetUpPage() {}

    @Override
    public void render() {
        System.out.println("""
                Welcome to Rush Hour - by Superchicche
                --------------------------------------
                (★≧▽^))★☆ Ready to play !?
                --------------------------------------
                Do you already have an account? (Y, N).
                """);
    }

    @Override
    public void handleInput(GameContext context) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("What is your email? ");
            String email = scanner.nextLine();
            Select select = new Select();
            Player currentPlayer =  select.getPlayerInfoByEmail(email);

            System.out.print("Hello, " + currentPlayer.getUserName() + " ready for a new game? ");

            context.setState(new StartGame());
        } else if (choice.equalsIgnoreCase("N")) {
            context.setState(new CreatePlayer());
        }
    }

}

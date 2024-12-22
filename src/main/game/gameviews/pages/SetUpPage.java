package main.game.gameviews.pages;

import main.database.Select;
import main.game.GameContext;
import main.game.Player;
import main.game.gamesession.GameSession;
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
        boolean validInput = false;

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            while (!validInput) {
                System.out.print("What is your email? ");
                String email = scanner.nextLine();

                try {
                    Select select = new Select();
                    Player currentPlayer =  select.getPlayerInfoByEmail(email);

                    GameSession sessionStateData = select.getGameSessionByPlayerId(currentPlayer.getPlayerId());

                    if (select.getBoardStateBySessionId(sessionStateData.getSessionId(), context)) {
                        System.out.println("Hello, " + currentPlayer.getUserName() + " seams like you have a previous game not finished!, you want to load the data? (Y,N)");
                        select.getBoardStateBySessionId(sessionStateData.getSessionId(), context);
                    } else {
                        System.out.print("Hello, " + currentPlayer.getUserName() + " ready for a new game? ");
                        context.setState(new StartGame());
                    }
                    validInput = true;
                } catch (NullPointerException e) {
                    System.out.println("No player found with the given email.");
                }
            }


        } else if (choice.equalsIgnoreCase("N")) {
            context.setState(new CreatePlayer());
        }
    }

}

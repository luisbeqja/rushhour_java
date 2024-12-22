package main.game.gameviews.pages;

import main.database.Create;
import main.game.GameContext;
import main.game.LeaderBoard;
import main.game.Player;
import main.game.gamesession.GameSession;
import main.game.gameviews.GameState;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class CreatePlayer implements GameState {


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
                --------------------------------------
                Create a new Player
                --------------------------------------
                """);
    }

    @Override
    public void handleInput(GameContext context) throws SQLException {
        Create create = new Create();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select a username (it will be public in the leaderboard): ");
        String username = scanner.nextLine();
        String email;

        do {
            System.out.print("Select an Email (it will be private, you can use it to save your progress): ");
            email = scanner.nextLine(); // Get email from input

            // Try creating a temporary player to validate the email

        } while (!Player.isValidEmail(email));

        Date currentDate = new Date();

        Player newPlayer = new Player(
                username,
                0,
                currentDate.toString(),
                email
        );

        create.createPlayersTable();

        newPlayer.addNewPlayerToDb();

        LeaderBoard leaderBoard = new LeaderBoard(newPlayer);
        // Initialize leaderboard and game session instances
        //GameSession gameSession = new GameSession(0, "", "");

        System.out.println("Welcome aboard !" + newPlayer.getUserName());
        System.out.println("Remember the Email you used to register, you can use it in the future to login ");
        System.out.println();
        System.out.println("Please enter to continue");
        scanner.nextLine();

        context.setState(new StartGame());
    }
}

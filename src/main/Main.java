package main;

import main.database.Create;
import main.database.DatabaseConnection;
import main.game.board.Board;
import main.game.board.Vehicle;
import main.game.gamesession.GameSession;
import main.game.LeaderBoard;
import main.game.Player;
import main.game.board.BoardRules;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.sql.SQLException;

import static main.game.board.BoardRules.winCheck;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Create a new board instance without any preset condition
        Board board = new Board(false);
        boolean winCheck = false; // Flag to track if the player has won

        Scanner sc = new Scanner(System.in); // Scanner for user input

        System.out.println("Enter your name: ");
        String name = sc.nextLine(); // Get player name from input

        // Loop until a valid email is entered
        String email;
        Player tempPlayer; // Temporary Player to validate email
        while (true) {
            System.out.println("Enter your email: ");
            email = sc.nextLine(); // Get email from input

            // Try creating a temporary player to validate the email
            try {
                tempPlayer = new Player(name, LocalDate.now().toString(), email);
                break; // Exit loop if email is valid
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Enter again: "); // Prompt for re-entry on invalid email
            }
        }

        // Create a new Player object with the entered name, date, and valid email
        Player playerTest = new Player(name, LocalDate.now().toString(), email);
        System.out.println(playerTest.toString()); // Output player details

        // Initialize leaderboard and game session instances
        LeaderBoard leaderBoard = new LeaderBoard(playerTest);
        GameSession gameSession = new GameSession(0, "", "");

        //NOTE: select level
        //TODO: player can select level from given array of levels
        int selectedLevel = 1;

        Map<String, Vehicle> boardMap = board.createBoard();

        BoardRules boardRules = new BoardRules(
                board.getVisualBoard(boardMap)
        );

        // Setup database connection for player data storage
        DatabaseConnection.getConnection();
        Create create = new Create(); // Instance to handle database table creation
        create.createPlayerTable(); // Create player table in the database

        // NOTE: print out the board
        //TODO: Make winChecker work
        //TODO: If there is no cars between "X" car and "Escape" -> win!
        while (!winCheck) {
            System.out.println(board.toString());

            System.out.println("Choose a vehicle: ");
            String vehicleStr = sc.nextLine();

            Vehicle vehicle = boardMap.get(vehicleStr);

            //check if user input for vehicle is actually a vehicle that is on the board
            if (!BoardRules.isVehicleOnBoard(vehicleStr)) {
                System.out.println("That is not a vehicle on the board.");

            }

            //check if the vehicle can move horizontally AND if it is actually on the board
            if (BoardRules.canVehicleMoveHorizontally(vehicleStr) && BoardRules.isVehicleOnBoard(vehicleStr)) {
                System.out.println("Choose a direction(right/left): ");
                String direction = sc.nextLine();

                //TODO: 1) ask for number of moves and check for possibility -> move if possible
                //TODO: 2) add updateArrayBoard for every direction

                switch (direction.toLowerCase()) {
                    case "right" -> {
                        System.out.println("Can Move Right " + BoardRules.canVehicleMoveRight(vehicleStr, 1));
                        board.updateArrayBoard(boardMap, vehicle, direction, 1);
                    }
                    case "left" -> System.out.println("Can Move Left " + BoardRules.canVehicleMoveLeft(vehicleStr, 2));
                    default -> System.out.println("Invalid direction: " + direction);
                }
                //check if vehicle can move vertically AND if it is also actually on the board
            } else if (BoardRules.canVehicleMoveVertically(vehicleStr) && BoardRules.isVehicleOnBoard(vehicleStr)) {
                System.out.println("Choose a direction(up/down): ");
                String direction = sc.nextLine();

                switch (direction.toLowerCase()) {
                    case "down" -> System.out.println("Can Move Down " + BoardRules.canVehicleMoveDown(vehicleStr, 2));
                    case "up" -> System.out.println("Can Move up " + BoardRules.canVehicleMoveUp(vehicleStr, 1));
                    default -> System.out.println("Invalid direction: " + direction);
                }
            }
            //TODO: implement counter of turns (connect it with GameSession?)
        }
    }

    // Method to check for winning condition in the game
    private static boolean checkWinCondition(Board board) {
        return board.hasWinningCondition(); // Call the board's method to check if the winning condition is met
    }
}
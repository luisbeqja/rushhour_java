package main;

import main.database.Create;
import main.database.DatabaseConnection;
import main.game.board.Board;
import main.game.gamesession.GameSession;
import main.game.LeaderBoard;
import main.game.Player;
import main.game.board.BoardRules;

import java.time.LocalDate;
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
        while (true) {
            System.out.println("Enter your email: ");
            email = sc.nextLine(); // Get email from input

            // Check if the entered email is valid
            if (isValidEmail(email)) {
                break; // Exit loop if email is valid
            } else {
                System.out.println("Invalid email. Enter again: "); // Prompt for re-entry on invalid email
            }
        }

        // Get the current date to use for player registration
        LocalDate date = LocalDate.now();

        // Create a new Player object with the entered name, date, and email
        Player playerTest = new Player(name, date.toString(), email);
        System.out.println(playerTest.toString()); // Output player details

        // Initialize leaderboard and game session instances
        LeaderBoard leaderBoard = new LeaderBoard(playerTest);
        GameSession gameSession = new GameSession(0, "", "");

        BoardRules boardRules = new BoardRules(
                board.getVisualBoard()
        );

        // Setup database connection for player data storage
        DatabaseConnection.getConnection();
        Create create = new Create(); // Instance to handle database table creation
        create.createPlayerTable(); // Create player table in the database

        // NOTE: print out the board
        while (!winCheck) {
            System.out.println(board);

            System.out.println("Choose a vehicle: ");
            String vehicle = sc.nextLine();

            //check if user input for vehicle is actually a vehicle that is on the board
            if (!BoardRules.isVehicleOnBoard(vehicle)) {
                System.out.println("That is not a vehicle on the board.");

            }

            //check if the vehicle can move horizontally AND if it is actually on the board
            if (BoardRules.canVehicleMoveHorizontally(vehicle) && BoardRules.isVehicleOnBoard(vehicle)) {
                System.out.println("Choose a direction(right/left): ");
                String direction = sc.nextLine();

                switch (direction.toLowerCase()) {
                    case "right" -> System.out.println("Can Move Right " + BoardRules.canVehicleMoveRight(vehicle, 1));
                    case "left" -> System.out.println("Can Move Left " + BoardRules.canVehicleMoveLeft(vehicle, 2));
                    default -> System.out.println("Invalid direction: " + direction);
                }
                //check if vehicle can move vertically AND if it is also actually on the board
            } else if (BoardRules.canVehicleMoveVertically(vehicle) && BoardRules.isVehicleOnBoard(vehicle)) {
                System.out.println("Choose a direction(up/down): ");
                String direction = sc.nextLine();

                switch (direction.toLowerCase()) {
                    case "down" -> System.out.println("Can Move Down " + BoardRules.canVehicleMoveDown(vehicle, 2));
                    case "up" -> System.out.println("Can Move up " + BoardRules.canVehicleMoveUp(vehicle, 1));
                    default -> System.out.println("Invalid direction: " + direction);
                }
            }
            //TODO: move() for vehicle
        }
    }

    // Method to check for valid email format
    private static boolean isValidEmail(String email) {
        // Simple email validation (checks for "@" and "." in the correct order)
        return email.contains("@") && email.lastIndexOf(".") > email.indexOf("@");
    }

    // Method to check for winning condition in the game
    private static boolean checkWinCondition(Board board) {
        return board.hasWinningCondition(); // Call the board's method to check if the winning condition is met
    }
}
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

        // Setup database connection for player data storage
        DatabaseConnection.getConnection();
        Create create = new Create(); // Instance to handle database table creation
        create.createPlayerTable(); // Create player table in the database

        // Game loop that continues until a winning condition is met
        while (!winCheck) {
            System.out.println(board); // Display the current state of the board
            System.out.println("Choose a vehicle: ");
            String vehicle = sc.nextLine(); // Get the vehicle choice from the player

            // TODO: Check if the chosen vehicle is present on the board

            // Prompt player to choose a direction for vehicle movement
            System.out.println("Choose a direction (right/left): ");
            String direction = sc.nextLine(); // Get the direction from user input

            boolean moveSuccessful = false; // Flag to track if the move was successful

            // Handle the vehicle movement based on the chosen direction
            switch (direction) {
                case "right":
                    // Check if the vehicle can move to the right
                    if (BoardRules.canVehicleMoveRight(vehicle, 1)) {
                        board.moveVehicle(vehicle, direction); // Execute the move
                        moveSuccessful = true; // Mark the move as successful
                    } else {
                        // Inform user that the move cannot be made
                        System.out.println("Cannot move vehicle to the right.");
                    }
                    break;

                case "left":
                    // Check if the vehicle can move to the left
                    if (BoardRules.canVehicleMoveLeft(vehicle, 2)) {
                        board.moveVehicle(vehicle, direction); // Execute the move
                        moveSuccessful = true; // Mark the move as successful
                    } else {
                        // Inform user that the move cannot be made
                        System.out.println("Cannot move vehicle to the left.");
                    }
                    break;

                default:
                    // Handle invalid direction input
                    System.out.println("Invalid direction: " + direction);
                    break;
            }

            // Check if the move was successful and update win status
            if (moveSuccessful) {
                winCheck = checkWinCondition(board); // Check for win condition after a successful move
            }
        }

        // Congratulate the player upon winning the game
        System.out.println("Congratulations! You've won the game!");
        sc.close(); // Close the scanner to free resources
    }

    // Method to check for winning condition in the game
    private static boolean checkWinCondition(Board board) {
        return board.hasWinningCondition(); // Call the board's method to check if the winning condition is met
    }
}
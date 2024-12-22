/*
package main.game.gameviews.pages;

import main.database.Create;
import main.database.DatabaseConnection;
import main.database.Drop;
import main.game.GameContext;
import main.game.board.Board;
import main.game.board.BoardRules;
import main.game.board.Vehicle;
import main.game.gameviews.GameState;

import java.util.Map;
import java.util.Scanner;

public class GamePage implements GameState {

    int levelId;
    int numberOfMoves = 0;
    public GamePage(int levelId) {
        this.levelId = levelId;
    }

    @Override
    public void render() {
        System.out.print(templateHeader());
    }

    @Override
    public void handleInput(GameContext context) {

        // Creating a board
        Board board = new Board(false);

        // Filling the board as Map with vehicles from selected level
        Map<String, Vehicle> boardMap = board.createBoard(levelId);

        new BoardRules(board.getVisualBoard(boardMap));
        // Setup database connection for player data storage
        DatabaseConnection.getConnection();
        Create create = new Create(); // Instance to handle database table creation
        Scanner scanner = new Scanner(System.in);
        // CREATE CLASS
        try {
            create.createSessionsTable();
            create.createBoardstatesTable();
            System.out.println("All tables created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }

        // NOTE: print out the board
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print(templateHeader());
            System.out.println(board);

            if (board.hasWinningCondition(boardMap)) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("""
                        
                        
                        
                        ✧｡٩(ˊᗜˋ )و✧*｡ YOU WON! ദ്ദി(˵ •̀ ᴗ - ˵) ✧
                        
                        
                        
                        
                        """);
                System.exit(0);

            } // Exit game;

            numberOfMoves++;

            // flag for while loop choosing vehicle and moving it
            // When flagForVehicle = false -> next turn
            boolean flagForVehicle = true;

            // Loop for validating vehicle input
            // If everything is correct - moves vehicle and -> next turn
            // If something is wrong - ask for vehicle until everything is fine
            while (flagForVehicle) {
                // choose vehicle
                System.out.println("Choose a vehicle: ");
                String vehicleStr = scanner.nextLine().toUpperCase();

                //take instance of Vehicle class of this vehicle from the board
                Vehicle vehicle = boardMap.get(vehicleStr);

                //check if user input for vehicle is actually a vehicle that is on the board
                if (!BoardRules.isVehicleOnBoard(vehicleStr)) {
                    System.out.println("That is not a vehicle on the board.");
                }
                //check if the vehicle can move horizontally
                else if (BoardRules.canVehicleMoveHorizontally(vehicleStr)) {
                    System.out.println("Choose a direction and number of moves (<r/l><n>): ");

                    // If input correct - moves vehicle to direction on number of moves
                    // And go to the next turn
                    flagForVehicle = GamePageLogic.inputDirectionAndMoves(scanner,vehicleStr,board,boardMap,vehicle);
                }
                //check if the vehicle can move vertically
                else if (BoardRules.canVehicleMoveVertically(vehicleStr)) {
                    System.out.println("Choose a direction and number of moves (<u/d><n>): ");

                    // If input correct - moves vehicle to direction on number of moves
                    // And go to the next turn
                    flagForVehicle = GamePageLogic.inputDirectionAndMoves(scanner,vehicleStr,board,boardMap,vehicle);
                }

            }
        }
    }

    private String templateHeader() {
        return """
                Welcome to Rush Hour - by Superchicche
                --------------------------------------
                Card -> card id number""" + " " + (levelId + 1) + """
                
                -------------------------------------
                
                Move n.""" + " " + numberOfMoves + """
                
                Make your move
                
                -------------------------------------
                """;
    }

}

 */
package main.game.gameviews.pages;

import main.database.Create;
import main.database.DatabaseConnection;
import main.database.Drop;
import main.database.SavedGame;
import main.game.GameContext;
import main.game.board.Board;
import main.game.board.BoardRules;
import main.game.board.Vehicle;
import main.game.gameviews.GameState;

import java.util.Map;
import java.util.Scanner;

public class GamePage implements GameState {

    int levelId;
    int numberOfMoves = 0;
    private Map<String, Vehicle> boardMap;

    /**
     * Constructor for GamePage.
     *
     * @param levelId The ID of the current level.
     */
    public GamePage(int levelId) {
        this.levelId = levelId;
    }

    @Override
    public String getBoard() {
        return "";
    }

    @Override
    public void setBoard(String board) {

    }

    /**
     * Renders the game interface.
     * <p>
     * Displays the game header, level information, move count, and instructions for saving the game.
     */
    @Override
    public void render() {
        System.out.print(templateHeader());
        System.out.println("Press 's' to save the game."); // Display save game option
    }

    /**
     * Handles user input and game logic.
     *
     * This method manages the game loop, handles user input, updates the game state,
     * and checks for the winning condition.
     *
     * @param context The GameContext object (not used in this implementation).
     */
    @Override
    public void handleInput(GameContext context) {

        // Creating a board
        Board board = new Board(false);

        // Filling the board as Map with vehicles from selected level
        Map<String, Vehicle> boardMap = board.createBoard(levelId);

        new BoardRules(board.getVisualBoard(boardMap));
        // Setup database connection for player data storage
        DatabaseConnection.getConnection();
        Create create = new Create(); // Instance to handle database table creation
        Scanner scanner = new Scanner(System.in);
        // CREATE CLASS
        try {
            create.createSessionsTable();
            create.createBoardstatesTable();
            System.out.println("All tables created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }

        // NOTE: print out the board
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print(templateHeader());
            System.out.println(board);

            if (board.hasWinningCondition(boardMap)) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("""
                        
                        
                        
                        ✧｡٩(ˊᗜˋ )و✧*｡ YOU WON! ദ്ദി(˵ •̀ ᴗ - ˵) ✧
                        
                        
                        
                        
                        """);
                System.exit(0);

            } // Exit game;

            numberOfMoves++;

            String userInput = scanner.nextLine().toLowerCase(); // Read user input (converted to lowercase)

            // Check for save game input
            if (userInput.equals("s")) {
                saveGame(board, boardMap); // Call saveGame method with board and boardMap
                System.out.println("Game saved successfully!");
                continue; // Continue to the next iteration of the game loop
            }

            // flag for while loop choosing vehicle and moving it
            // When flagForVehicle = false -> next turn
            boolean flagForVehicle = true;

            // Loop for validating vehicle input
            // If everything is correct - moves vehicle and -> next turn
            // If something is wrong - ask for vehicle until everything is fine
            while (flagForVehicle) {
                // choose vehicle
                System.out.println("Choose a vehicle: ");
                String vehicleStr = scanner.nextLine().toUpperCase();

                //take instance of Vehicle class of this vehicle from the board
                Vehicle vehicle = boardMap.get(vehicleStr);

                //check if user input for vehicle is actually a vehicle that is on the board
                if (!BoardRules.isVehicleOnBoard(vehicleStr)) {
                    System.out.println("That is not a vehicle on the board.");
                }
                //check if the vehicle can move horizontally
                else if (BoardRules.canVehicleMoveHorizontally(vehicleStr)) {
                    System.out.println("Choose a direction and number of moves (<r/l><n>): ");

                    // If input correct - moves vehicle to direction on number of moves
                    // And go to the next turn
                    flagForVehicle = GamePageLogic.inputDirectionAndMoves(scanner,vehicleStr,board,boardMap,vehicle);
                }
                //check if the vehicle can move vertically
                else if (BoardRules.canVehicleMoveVertically(vehicleStr)) {
                    System.out.println("Choose a direction and number of moves (<u/d><n>): ");

                    // If input correct - moves vehicle to direction on number of moves
                    // And go to the next turn
                    flagForVehicle = GamePageLogic.inputDirectionAndMoves(scanner,vehicleStr,board,boardMap,vehicle);
                }

            }
        }
    }

    /**
     * Saves the current game state.
     *
     * Creates a SavedGame object, populates it with game state information, and
     * saves it to the database (database logic to be implemented).
     *
     * @param board The current game board.
     * @param boardMap A map containing the vehicles on the board.
     */
    private void saveGame(Board board, Map<String, Vehicle> boardMap) {
        this.boardMap = boardMap;
        // Create a SavedGame object
        SavedGame savedGame = new SavedGame();
        savedGame.setlevelId(levelId);
        savedGame.setNumberOfMoves(numberOfMoves);
        savedGame.setBoard(board.getBoard()); // Assuming board has a method to get its current state

        // Save the game state (implement your database logic here)
        // ... (e.g., call a method in a separate class to save to the database)
        // Flag to track save game status
        boolean isGameSaved = true;
    }

    /**
     * Creates and returns the game header string.
     * <p>
     * Includes level information and move count.
     *
     * @return The formatted game header string.
     */
    private String templateHeader() {
        return """
                Welcome to Rush Hour - by Superchicche
                --------------------------------------
                Card -> card id number""" + " " + (levelId + 1) + """
                
                -------------------------------------
                
                Move n.""" + " " + numberOfMoves + """
                
                Make your move
                
                -------------------------------------
                """;
    }

    public Map<String, Vehicle> getBoardMap() {
        return boardMap;
    }

    public void setBoardMap(Map<String, Vehicle> boardMap) {
        this.boardMap = boardMap;
    }
}

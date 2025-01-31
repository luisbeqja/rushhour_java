package main.game.gameviews.pages;

import main.database.Create;
import main.database.DatabaseConnection;
import main.database.Drop;
import main.game.GameContext;
import main.game.board.Board;
import main.game.board.BoardRules;
import main.game.board.Vehicle;
import main.game.gameviews.GameState;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GamePage implements GameState {

    int levelId = 137;
    int numberOfMoves = 0;
    Map<String, Vehicle> vehicles;

    public GamePage(int levelId) {
        this.levelId = levelId;
    }

    public GamePage(Map<String, Vehicle> loadedlevel) {
        this.vehicles = loadedlevel;
    }

    @Override
    public void render() {
        System.out.print(templateHeader());
    }

    @Override
    public void handleInput(GameContext context) {

        // Creating a board
        Board board = new Board(false);


        // Filling the board as Map with vehicles from selected level or loaded level
        Map<String, Vehicle> boardMap;
        if (levelId != 137) {
            boardMap = board.createBoard(levelId);
        } else {
            boardMap = vehicles;
        }


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

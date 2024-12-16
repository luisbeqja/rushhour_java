package main.game.gameviews.pages;

import main.database.Create;
import main.database.DatabaseConnection;
import main.game.GameContext;
import main.game.board.Board;
import main.game.board.BoardRules;
import main.game.board.Vehicle;
import main.game.gameviews.GameState;

import java.util.Map;
import java.util.Scanner;

public class GamePage implements GameState {

    int levelId = 1;

    public GamePage(int levelId) {
        this.levelId = levelId;
    }

    @Override
    public void render() {
        System.out.print("""
                Welcome to Rush Hour - by Superchicche
                --------------------------------------
                Card -> 12 Expert
                -------------------------------------
                
                Move n. 3
                
                Make your move\s
                --------------
                """);
    }

    @Override
    public void handleInput(GameContext context) {
        Board board = new Board(false);
        Map<String, Vehicle> boardMap = board.createBoard(levelId);
        new BoardRules(board.getVisualBoard(boardMap));
        // Setup database connection for player data storage
        DatabaseConnection.getConnection();
        Create create = new Create(); // Instance to handle database table creation
        Scanner scanner = new Scanner(System.in);
        // CREATE CLASS
        try {
            create.dropTables();
            create.createPlayersTable();
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
            System.out.println(board);
            // flag for while loop choosing vehicle and moving it
            boolean flagForVehicle = true;

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

                //check if the vehicle can move horizontally AND if it is actually on the board
                if (BoardRules.canVehicleMoveHorizontally(vehicleStr) && BoardRules.isVehicleOnBoard(vehicleStr)) {
                    System.out.println("Choose a direction(right/left): ");
                    String direction = scanner.nextLine();

                    //TODO: 1) ask for number of moves and check for possibility -> move if possible
                    //NOTE: moving vehicle to the left and right by 1 if possible
                    // and updating the board
                    switch (direction.toLowerCase()) {
                        case "right" -> {
                            if (BoardRules.canVehicleMoveRight(vehicleStr, 1)) {
                                board.updateArrayBoard(boardMap, vehicle, direction, 1);
                                flagForVehicle = false;
                            }
                        }
                        case "left" -> {
                            if (BoardRules.canVehicleMoveLeft(vehicleStr, 1)) {
                                board.updateArrayBoard(boardMap, vehicle, direction, 1);
                                flagForVehicle = false;
                            }
                        }
                        default -> System.out.println("Invalid direction: " + direction);
                    }
                    //check if vehicle can move vertically AND if it is also actually on the board
                } else if (BoardRules.canVehicleMoveVertically(vehicleStr) && BoardRules.isVehicleOnBoard(vehicleStr)) {
                    System.out.println("Choose a direction(up/down): ");
                    String direction = scanner.nextLine();

                    //NOTE: moving vehicle to the up and down by 1 if possible
                    // and updating the board
                    switch (direction.toLowerCase()) {
                        case "down" -> {
                            if (BoardRules.canVehicleMoveDown(vehicleStr, 1)) {
                                board.updateArrayBoard(boardMap, vehicle, direction, 1);
                                flagForVehicle = false;
                            }
                        }
                        case "up" -> {
                            if (BoardRules.canVehicleMoveUp(vehicleStr, 1)) {
                                board.updateArrayBoard(boardMap, vehicle, direction, 1);
                                flagForVehicle = false;
                            }
                        }
                        default -> System.out.println("Invalid direction: " + direction);
                    }
                }
            }
            //TODO: implement counter of turns (connect it with GameSession?)
        }
    }
}

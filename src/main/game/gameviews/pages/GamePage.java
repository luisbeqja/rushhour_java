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
        Board board = new Board(false);
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
                    System.out.println("Choose a direction and number of moves (<r/l><n>): ");
                    String directionAndMoves = scanner.nextLine();

                    StringBuilder direction = new StringBuilder();
                    StringBuilder numMoves = new StringBuilder();

                    for (char ch: directionAndMoves.toCharArray()) {
                        if (Character.isDigit(ch)) {
                            numMoves.append(ch);
                        } else if (Character.isLetter(ch)) {
                            direction.append(ch);
                        }
                    }

                    int numberOfMoves = Integer.parseInt(numMoves.toString());

                    //TODO: 1) ask for number of moves and check for possibility -> move if possible
                    //NOTE: moving vehicle to the left and right by 1 if possible
                    // and updating the board
                    switch (direction.toString().toLowerCase()) {
                        case "r" -> {
                            if (BoardRules.canVehicleMoveRight(vehicleStr, numberOfMoves)) {
                                board.updateArrayBoard(boardMap, vehicle, direction.toString(), numberOfMoves);
                                flagForVehicle = false;
                            }
                        }
                        case "l" -> {
                            if (BoardRules.canVehicleMoveLeft(vehicleStr, numberOfMoves)) {
                                board.updateArrayBoard(boardMap, vehicle, direction.toString(), numberOfMoves);
                                flagForVehicle = false;
                            }
                        }
                        default -> System.out.println("That is not a valid direction!");
                    }
                    //check if vehicle can move vertically AND if it is also actually on the board
                } else if (BoardRules.canVehicleMoveVertically(vehicleStr) && BoardRules.isVehicleOnBoard(vehicleStr)) {
                    System.out.println("Choose a direction and number of moves (<u/d><n>): ");
                    String directionAndMoves = scanner.nextLine();

                    StringBuilder direction = new StringBuilder();
                    StringBuilder numMoves = new StringBuilder();

                    for (char ch: directionAndMoves.toCharArray()) {
                        if (Character.isDigit(ch)) {
                            numMoves.append(ch);
                        } else if (Character.isLetter(ch)) {
                            direction.append(ch);
                        }
                    }

                    int numberOfMoves = Integer.parseInt(numMoves.toString());

                    //NOTE: moving vehicle to the up and down by 1 if possible
                    // and updating the board
                    switch (direction.toString().toLowerCase()) {
                        case "d" -> {
                            if (BoardRules.canVehicleMoveDown(vehicleStr, numberOfMoves)) {
                                board.updateArrayBoard(boardMap, vehicle, direction.toString(), numberOfMoves);
                                flagForVehicle = false;
                            }
                        }
                        case "u" -> {
                            if (BoardRules.canVehicleMoveUp(vehicleStr, numberOfMoves)) {
                                board.updateArrayBoard(boardMap, vehicle, direction.toString(), numberOfMoves);
                                flagForVehicle = false;
                            }
                        }
                        default -> System.out.println("That is not a valid direction!");
                    }
                }
            }
            //TODO: implement counter of turns (connect it with GameSession?)
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

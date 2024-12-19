package main.game.gameviews.pages;

import main.game.board.Board;
import main.game.board.BoardRules;
import main.game.board.Vehicle;

import java.util.Map;
import java.util.Scanner;

public class GamePageLogic {

    /*
    Func that
    Takes: Scanner, vehicle as String, instance of Board, board as Map, instance of Vehicle

    return boolean "flagForVehicle"
    true -> smth wrong with input and will ask for vehicle 1 more time
    false -> everything is correct -> moves vehicle on direction and number of moves -> next turn
    */
    public static boolean inputDirectionAndMoves(Scanner scanner, String vehicleStr, Board board, Map<String, Vehicle> boardMap, Vehicle vehicle) {
        String directionAndMoves = scanner.nextLine();

        // checking if there are only 2 symbols (correct input)
        if (GamePageLogic.checkDirectionAndMovesInput(directionAndMoves)) {

            //Splitting string into 2 parts with direction and number of moves
            int numberOfMoves = GamePageLogic.splitStringNumMoves(directionAndMoves);
            String direction = GamePageLogic.splitStringDirection(directionAndMoves);

            //Moves vehicle to the direction by number of moves if possible
            // and updating the board
            switch (direction.toLowerCase()) {
                case "r" -> {
                    if (BoardRules.canVehicleMoveRight(vehicleStr, numberOfMoves)) {
                        board.updateArrayBoard(boardMap, vehicle, direction, numberOfMoves);
                        return false;
                    }
                }
                case "l" -> {
                    if (BoardRules.canVehicleMoveLeft(vehicleStr, numberOfMoves)) {
                        board.updateArrayBoard(boardMap, vehicle, direction, numberOfMoves);
                        return false;
                    }
                }
                case "d" -> {
                    if (BoardRules.canVehicleMoveDown(vehicleStr, numberOfMoves)) {
                        board.updateArrayBoard(boardMap, vehicle, direction, numberOfMoves);
                        return false;
                    }
                }
                case "u" -> {
                    if (BoardRules.canVehicleMoveUp(vehicleStr, numberOfMoves)) {
                        board.updateArrayBoard(boardMap, vehicle, direction, numberOfMoves);
                        return false;
                    }
                }
                default -> System.out.println("That is not a valid direction!");


            }
        }
        return true;
    }

    // func for taking number of moves from input String
    // takes String -> return int numberOfMoves
    public static int splitStringNumMoves(String directionAndMoves) {
        StringBuilder numMoves = new StringBuilder();

        for (char ch: directionAndMoves.toCharArray()) {
            if (Character.isDigit(ch)) {
                numMoves.append(ch);
            }
        }
        String numberOfMovesStr = numMoves.toString();
        if (numberOfMovesStr.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(numberOfMovesStr);
        }

    }


    // func for taking direction from input String
    // takes String -> return String direction (might be not correct, validating later)
    public static String splitStringDirection(String directionAndMoves) {
        StringBuilder direction = new StringBuilder();

        for (char ch: directionAndMoves.toCharArray()) {
            if (Character.isLetter(ch)) {
                direction.append(ch);
            }
        }
        return direction.toString();
    }

    // Checking for input length
    // If 2 char -> true
    // If !2 char -> false
    public static boolean checkDirectionAndMovesInput(String direction) {
        return direction.length() == 2;
    }
}

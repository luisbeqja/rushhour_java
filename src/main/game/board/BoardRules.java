package main.game.board;

import java.util.Arrays;

public class BoardRules {

    Vehicle vehicle;
    static String[][] board;

    public BoardRules(String[][] board) {
        //this.vehicle = vehicle;
        this.board = board;
    }


    // Vehicles from A to F moves only horizontally
    // Vehicles from G to L moves only vertically


    @Override
    public String toString() {
        System.out.println(Arrays.deepToString(board));
        return "";
    }


    // Checks
    public static boolean canVehicleMoveRight(String vehicle, int numberOfMoves) {
        // Iterate through each row of the board
        for (String[] row : board) {
            // Find the last occurrence of the vehicle in the row by iterating from the end
            int lastIndex = -1;
            for (int j = row.length - 1; j >= 0; j--) {
                if (row[j] != null && row[j].equalsIgnoreCase(vehicle)) {
                    lastIndex = j;
                    break; // Break once the last occurrence is found
                }
            }

            if (lastIndex != -1) { // If the vehicle is found in the row

                // Check if the vehicle can move right the specified number of times
                for (int move = 1; move <= numberOfMoves; move++) {
                    int newIndex = lastIndex + move;

                    // Check if the move is out of bounds
                    if (newIndex >= row.length) {
                        System.out.println("Cannot move right: Out of bounds at index " + newIndex);
                        return false; // Out of bounds
                    }

                    // Check if the space to the right is blocked
                    if (row[newIndex] != null) {
                        System.out.println("Cannot move right: Blocked at index " + newIndex + " with value " + row[newIndex]);
                        return false; // Blocked space
                    }
                }
                return true; // The vehicle can move the specified number of steps
            }
        }
        return false; // Vehicle not found in any row
    }

    public static boolean canVehicleMoveLeft(String vehicle, int numberOfMoves) {
        // Iterate through each row of the board
        for (String[] row : board) {
            // Find the first occurrence of the vehicle in the row
            int firstIndex = -1;
            for (int j = 0; j < row.length; j++) {
                if (row[j] != null && row[j].equalsIgnoreCase(vehicle)) {
                    firstIndex = j;
                    break; // Break once the first occurrence is found
                }
            }

            if (firstIndex != -1) { // If the vehicle is found in the row

                // Check if the vehicle can move left the specified number of times
                for (int move = 1; move <= numberOfMoves; move++) {
                    int newIndex = firstIndex - move;

                    // Check if the move is out of bounds
                    if (newIndex < 0) {
                        System.out.println("Cannot move left: Out of bounds at index " + newIndex);
                        return false; // Out of bounds
                    }

                    // Check if the space to the left is blocked
                    if (row[newIndex] != null) {
                        System.out.println("Cannot move left: Blocked at index " + newIndex + " with value " + row[newIndex]);
                        return false; // Blocked space
                    }
                }
                return true; // The vehicle can move the specified number of steps
            }
        }
        return false; // Vehicle not found in any row
    }
    // Check if the vehicle move up
    public static boolean canVehicleMoveUp(String vehicle, int numberOfMoves) {
            for (int col = 0; col < board[0].length; col++) {
                int firstRow = -1;

                // Find the topmost position of the vehicle in the column
                for (int row = 0; row < board.length; row++) {
                    if (board[row][col] != null && board[row][col].equalsIgnoreCase(vehicle)) {
                        firstRow = row;
                        break;
                    }
                }

                if (firstRow != -1) { // Vehicle is found in this column
                    // Check if it can move up
                    for (int move = 1; move <= numberOfMoves; move++) {
                        int newRow = firstRow - move;
                        if (newRow < 0) {
                            System.out.println("Cannot move up: Out of bounds at row " + newRow);
                            return false;
                        }
                        if (board[newRow][col] != null) {
                            System.out.println("Cannot move up: Blocked at row " + newRow + " with value " + board[newRow][col]);
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false; // Vehicle not found
        }
    // Move the vehicle up
    public static void moveVehicleUp(String vehicle, int numberOfMoves) {
        if (!canVehicleMoveUp(vehicle, numberOfMoves)) {
            System.out.println("Vehicle cannot move up.");
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != null && board[row][col].equalsIgnoreCase(vehicle)) {
                    // Move the vehicle part up
                    board[row - numberOfMoves][col] = vehicle;
                    board[row][col] = null; // Clear old position
                }
            }
        }

        System.out.println(vehicle + " moved up by " + numberOfMoves + " steps.");
    }

    }






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

    public static boolean canVehicleMoveDown(String vehicle, int numberOfMoves) {
        //defining columns/rows
        int numRows = board.length;
        int numCols = board[0].length;

        //Iterate through each column of the board
        for (int col = 0; col < numCols; col++) {
            int lastIndex = -1; //track the lowest occurence of the vehicle in the column

            //Find the lowest occurence of the vehicle in the column
            for (int row = 0; row < numRows; row++) {
                if (board[row][col] != null && board[row][col].equalsIgnoreCase(vehicle)) {
                    lastIndex = row;
                }
            }
            if (lastIndex != -1) { //if vehicle is found in column
                //check if vehicle can move down
                for (int move = 1; move <= numberOfMoves; move++) {
                    int newIndex = lastIndex + move;

                    //check if move goes out of bounds
                    if (newIndex >= numRows) {
                        System.out.println("Cannot move down: Out of bounds at index " + newIndex);
                        return false; //out of bounds
                    }
                    //check if the space below is blocked
                    if (board[newIndex][col] != null) {
                        System.out.println("Cannot move down: Blocked at row " + newIndex + " with value " + board[newIndex][col]);
                        return false; //blocked space
                    }
                }
                return true; //the vehicle can move the specified n of moves

            }
        }
        return false; //Vehicle not found in any column
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
}

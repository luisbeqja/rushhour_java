package main.game.board;

import java.util.Arrays;

public class BoardRules {

    Vehicle vehicle;
    static String[][] board;

    public BoardRules(String[][] board) {
        //this.vehicle = vehicle;
        this.board = board;
    }

    //is the vehicle on the board?
    public static boolean isVehicleOnBoard(String vehicle) {
        //iterate through the board[][] array
        for (int i = 0; i < board.length; i++) {  // Loop through rows
            for (int j = 0; j < board[i].length; j++) {  // Loop through columns in each row
                if (board[i][j] != null && board[i][j].equalsIgnoreCase(vehicle)) {  // Check for a match
                    return true;
                }
            }
        } return false;
    }

    // Check: Vehicles from A to F and X move only horizontally
    public static boolean canVehicleMoveHorizontally(String vehicle) {
        if ((int)vehicle.charAt(0) >= 65 && (int)vehicle.charAt(0) <= 70 || (int)vehicle.charAt(0) == 88) {
            return true; //uppercase letters
        } else if ((int)vehicle.charAt(0) >= 97 && (int)vehicle.charAt(0) <= 102 || (int)vehicle.charAt(0) == 120) {
            return true; //lowercase letters
        }
        return false;
    }


    // Check: Vehicles from G to L move only vertically
    public static boolean canVehicleMoveVertically(String vehicle) {
        if ((int)vehicle.charAt(0) >= 71 && (int)vehicle.charAt(0) <= 76) {
            return true; //uppercase letters
        } else if ((int)vehicle.charAt(0) >= 103 && (int)vehicle.charAt(0) <= 108) {
            return true; //lowercase letters
        }
        return false;
    }

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

    public static boolean winCheck() {
        if (board[2][4].equals('X') && board[2][5].equals('X')) {
            return true;
        }
        return false;
    }
}

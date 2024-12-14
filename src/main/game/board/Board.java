package main.game.board;

import java.util.List;
import java.util.Map;

public class Board {

    private boolean isBoardEmpty;
    private final String[][] visualBoard = new String[6][6];
    BoardLevels boardLevels = new BoardLevels();

    public Board(boolean isBoardEmpty) {
        this.isBoardEmpty = isBoardEmpty;
    }

    /*GETTERS*/
    public boolean isBoardEmpty() {
        return isBoardEmpty;
    }
    public String[][] getVisualBoard() {
        this.createArrayBoard();
        return visualBoard;
    }

    /*SETTERS*/
    public void setIsBoardEmpty(boolean isBoardEmpty) {
        this.isBoardEmpty = isBoardEmpty;
    }

    /*METHODS*/

    // NOTE: Insert the vehicles to the board
    private void createArrayBoard() {
        Map<String, Vehicle> vehicles = BoardLevels.getLevel();
        for (Map.Entry<String, Vehicle> vehicle: vehicles.entrySet()) {
            String vehicleValue = vehicle.getKey();
            int[][] vehiclePosition = vehicle.getValue().getPosition();

            for (int[] position: vehiclePosition) {
                visualBoard[position[0]][position[1]] = vehicleValue;
            }
        }
    };

    // NOTE: Print out the string for the board with the vehicles
    public String toString() {
        createArrayBoard();
        int rows = visualBoard.length;
        int cols = visualBoard.length;
        StringBuilder sb = new StringBuilder();

        // Iterate over rows
        for (String[] strings : visualBoard) {
            // Add the horizontal divider
            sb.append("+");
            sb.append("---+".repeat(cols));
            sb.append("\n");

            // Add the row values
            sb.append("|");
            for (int j = 0; j < cols; j++) {
                // Replace null with a space
                String cell = strings[j] == null ? " " : strings[j];
                sb.append(" ").append(cell.toUpperCase()).append(" |");
            }
            sb.append("\n");
        }

        // Add the final horizontal divider
        sb.append("+");
        sb.append("---+".repeat(visualBoard[0].length));
        sb.append("\n");

        return sb.toString();
    }

   public boolean hasWinningCondition() {
        return false;
    }

    public void moveVehicle(String vehicle, String direction) {

    }
//    public boolean isVehiclePresent(String vehicle) {
//        // Implement logic to return true if the vehicle is present on the board
//    }
//
//    // part of solution
}

package main.game.board;

import java.util.Map;

import static main.game.board.BoardLevels.getLevel;

public class Board {

    private boolean isBoardEmpty;
    private final String[][] visualBoard;
    BoardLevels boardLevels = new BoardLevels();

    public Board(boolean isBoardEmpty) {
        this.isBoardEmpty = isBoardEmpty;
        this.visualBoard = new String[6][6];
    }

    /*GETTERS*/
    public boolean isBoardEmpty() {
        return isBoardEmpty;
    }

    public String[][] getVisualBoard(Map<String, Vehicle> vehicles) {
        this.createArrayBoard(vehicles);
        return visualBoard;
    }

    /*SETTERS*/
    public void setIsBoardEmpty(boolean isBoardEmpty) {
        this.isBoardEmpty = isBoardEmpty;
    }

    /*METHODS*/

    // Insert vehicles from level as Map<String, Vehicle>
    public Map<String, Vehicle> createBoard(int levelId) {
        return getLevel(levelId);
    }

    // Insert the vehicles to the visual board
    public void createArrayBoard(Map<String, Vehicle> vehicles) {
        for (Map.Entry<String, Vehicle> vehicle : vehicles.entrySet()) {
            String vehicleValue = vehicle.getKey();
            int[][] vehiclePosition = vehicle.getValue().getPosition();

            for (int[] position : vehiclePosition) {
                visualBoard[position[0]][position[1]] = vehicleValue;
            }
        }
    }

    // Update visual board after move with new vehicle position
    public void updateArrayBoard(Map<String, Vehicle> vehicles, Vehicle vehicleToMove, String direction, int numberOfMoves) {
        // Select vehicle that we want to move
        Vehicle vehicle = vehicles.get(vehicleToMove.getCellValue());

        // Clear previous vehicle position from visual board
        for (int[] position : vehicle.getPosition()) {
            visualBoard[position[0]][position[1]] = null;
        }

        // Move vehicle
        vehicle.move(direction, numberOfMoves);

        // displaying new position after move on the visualboard
        for (int[] position: vehicle.getPosition()) {
            visualBoard[position[0]][position[1]] = vehicleToMove.getCellValue();
        }
    }

    public boolean hasWinningCondition(Map<String, Vehicle> vehicles) {
        // Check if vehicle "X" is in the last column
        Vehicle targetVehicle = vehicles.get("X");

        if (targetVehicle != null) {
            // Get the vehicle's positio
            int[][] targetPosition = targetVehicle.getPosition();
            int lastRow = targetPosition[0][0]; // Assume vehicle is horizontal for win condition

            // Check if the vehicle's last part of the position is in the last column
            if (targetVehicle.getPosition().length > 0) {
                int lastColumnIndex = targetPosition[targetPosition.length - 1][1]; // Last occupied column
                return lastColumnIndex == visualBoard[0].length - 1 && lastRow == targetPosition[0][0];
            }
        }

        return false;
    }

    // Print out the string for the board with the vehicles
    @Override
    public String toString() {
        int rows = visualBoard.length;
        int cols = visualBoard.length;
        StringBuilder sb = new StringBuilder();

        // Iterate over rows
        for (int i = 0; i < rows; i++) {
            // Add the horizontal divider
            sb.append("+");
            sb.append("---+".repeat(cols));
            sb.append("\n");

            // Add the row values
            sb.append("|");
            for (int j = 0; j < cols; j++) {
                // Replace null with a space
                String cell = visualBoard[i][j] == null ? " " : visualBoard[i][j];
                if (i == 2 && j == 5) {
                    sb.append(" ").append(cell.toUpperCase()).append(" ");
                } else {
                    sb.append(" ").append(cell.toUpperCase()).append(" |");
                }
            }
            sb.append("\n");
        }

        // Add the final horizontal divider
        sb.append("+");
        sb.append("---+".repeat(visualBoard[0].length));
        sb.append("\n");

        return sb.toString();
    }

    public String getBoard() {
        return boardLevels.toString();
    }
}
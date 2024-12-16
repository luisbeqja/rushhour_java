package main.game.board;


import java.util.Map;

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

    //NOTE: Insert vehicles from level as Map<String, Vehicle>
    //TODO: add here levelName
    public Map<String, Vehicle> createBoard() {
        return BoardLevels.getLevel();
    }

    // NOTE: Insert the vehicles to the visualboard
    public void createArrayBoard(Map<String, Vehicle> vehicles) {
        for (Map.Entry<String, Vehicle> vehicle: vehicles.entrySet()) {
            String vehicleValue = vehicle.getKey();
            int[][] vehiclePosition = vehicle.getValue().getPosition();

            for (int[] position: vehiclePosition) {
                visualBoard[position[0]][position[1]] = vehicleValue;
            }
        }
    };

    // NOTE: Updating visualboard after move with new vehicle position
    public void updateArrayBoard(Map<String, Vehicle> vehicles, Vehicle vehicleToMove, String direction, int numberOfMoves) {
        // Select vehicle that we want to move
        Vehicle vehicle = vehicles.get(vehicleToMove.getCellValue());

        // clear previous vehicle position from visualboard
        for (int[] position: vehicle.getPosition()) {
            visualBoard[position[0]][position[1]] = null;
        }

        // move vehicle
        vehicle.move(direction, numberOfMoves);

        // displaying new position after move on the visualboard
        for (int[] position: vehicle.getPosition()) {
            visualBoard[position[0]][position[1]] = vehicleToMove.getCellValue();
        }
    }

    public boolean hasWinningCondition() {
        return false;
    }
    // Method to get the position of a vehicle on the board
    public int getVehiclePosition(String vehicleKey) {
        for (int i = 0; i < visualBoard.length; i++) {
            for (int j = 0; j < visualBoard[i].length; j++) {
                if (vehicleKey.equals(visualBoard[i][j])) {
                    return i * visualBoard.length + j; // Return a single index (for easier path check)
                }
            }
        }
        return -1; // Return -1 if vehicle is not found
    }

    // Method to check if there are no vehicles between two positions (exclusive)
    public boolean isPathClear(int start, int end) {
        int startRow = start / visualBoard.length; // Calculate row for start position
        int startCol = start % visualBoard.length; // Calculate column for start position
        int endRow = end / visualBoard.length; // Calculate row for end position
        int endCol = end % visualBoard.length; // Calculate column for end position

        // Assuming start is to the left of end
        if (startRow == endRow) { // Same row, horizontal movement
            int minCol = Math.min(startCol, endCol) + 1; // Start checking from the next column
            int maxCol = Math.max(startCol, endCol); // End at the column before the target

            for (int col = minCol; col < maxCol; col++) {
                if (visualBoard[startRow][col] != null) {
                    return false; // There is a vehicle blocking the path
                }
            }
        } else if (startCol == endCol) { // Same column, vertical movement
            int minRow = Math.min(startRow, endRow) + 1; // Start checking from the next row
            int maxRow = Math.max(startRow, endRow); // End at the row before the target

            for (int row = minRow; row < maxRow; row++) {
                if (visualBoard[row][startCol] != null) {
                    return false; // There is a vehicle blocking the path
                }
            }
        }

        return true; // Path is clear
    }

    // NOTE: Print out the string for the board with the vehicles
    @Override
    public String toString() {
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
}

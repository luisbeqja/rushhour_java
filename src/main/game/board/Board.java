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
    public Map<String, Vehicle> createBoard(int levelId) {
        return BoardLevels.getLevel(levelId);
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

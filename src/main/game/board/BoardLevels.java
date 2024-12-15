package main.game.board;

import java.util.*;

public class BoardLevels {

    static Map<String, Vehicle> level2 = new HashMap<>();

    public BoardLevels() {
        int[][] vehicleXCoordinates = {{2, 0}, {2, 1}};
        int[][] vehicleGCoordinates = {{1, 2}, {2, 2}};
        int[][] vehicleHCoordinates = {{1, 3}, {2, 3}};
        int[][] vehicleICoordinates = {{1, 4}, {2, 4}};
        int[][] vehicleDCoordinates = {{3, 1}, {3, 2}, {3, 3}};

        level2.put("X", new Vehicle("X", vehicleXCoordinates));
        level2.put("G", new Vehicle("G", vehicleGCoordinates));
        level2.put("H", new Vehicle("H", vehicleHCoordinates));
        level2.put("I", new Vehicle("I", vehicleICoordinates));
        level2.put("D", new Vehicle("D", vehicleDCoordinates));
    }


    // Method to access the level2 list
    public static Map<String, Vehicle> getLevel() {
        return level2;
    };
}

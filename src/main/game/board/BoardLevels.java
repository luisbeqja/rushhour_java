package main.game.board;

import java.util.*;

public class BoardLevels {

    private static Map<String, Vehicle> level1 = new HashMap<>();
    private static List<Map<String, Vehicle>> levels = new ArrayList<>();


    //TODO: Create more levels
    //TODO: add all levels to List and access them from List by index (maybe ordered list?)
    public BoardLevels() {
        int[][] vehicleXCoordinates = {{2, 0}, {2, 1}};
        int[][] vehicleGCoordinates = {{1, 2}, {2, 2}};
        int[][] vehicleHCoordinates = {{1, 3}, {2, 3}};
        int[][] vehicleICoordinates = {{1, 4}, {2, 4}};
        int[][] vehicleDCoordinates = {{3, 1}, {3, 2}, {3, 3}};

        level1.put("X", new Vehicle("X", vehicleXCoordinates));
        level1.put("G", new Vehicle("G", vehicleGCoordinates));
        level1.put("H", new Vehicle("H", vehicleHCoordinates));
        level1.put("I", new Vehicle("I", vehicleICoordinates));
        level1.put("D", new Vehicle("D", vehicleDCoordinates));
        levels.add(level1);
    }

    // Method to access the level2 list
    public static Map<String, Vehicle> getLevel() {
        return level1;
    };
}

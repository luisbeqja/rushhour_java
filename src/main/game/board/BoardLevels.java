package main.game.board;

import java.util.*;

public class BoardLevels {

    private static Map<String, Vehicle> level1 = new HashMap<>(); //move this down to above level 1 array?
    private static List<Map<String, Vehicle>> levels = new ArrayList<>();


    //TODO: Create more levels
    //TODO: add all levels to List and access them from List by index (maybe ordered list?)
    public BoardLevels() {
        //level 1 - easy
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

        //level 2 - easy
        Map<String, Vehicle> level2 = new HashMap<>();
        int[][] vehicleX2Coordinates = {{2, 0}, {2, 1}};
        int[][] vehicleA2Coordinates = {{3, 0}, {3, 1}, {3, 2}};
        int[][] vehicleG2Coordinates = {{0, 2}, {1, 2}, {2, 2}};
        int[][] vehicleB2Coordinates = {{0, 4}, {0, 5}};
        int[][] vehicleH2Coordinates = {{3, 5}, {4, 5}, {5, 5}};

        level2.put("X", new Vehicle("X", vehicleX2Coordinates));
        level2.put("A", new Vehicle("A", vehicleA2Coordinates));
        level2.put("G", new Vehicle("G", vehicleG2Coordinates));
        level2.put("B", new Vehicle("B", vehicleB2Coordinates));
        level2.put("H", new Vehicle("H", vehicleH2Coordinates));
        levels.add(level2);

        //level 3 - easy
        Map<String, Vehicle> level3 = new HashMap<>();
        int[][] vehicleX3Coordinates = {{2, 1}, {2, 2}};
        int[][] vehicleA3Coordinates = {{0, 0}, {0, 1}};
        int[][] vehicleG3Coordinates = {{4, 0}, {5, 0}};
        int[][] vehicleB3Coordinates = {{4, 4}, {4, 5}};
        int[][] vehicleH3Coordinates = {{1, 0}, {2, 0}, {3, 0}};
        int[][] vehicleJ3Coordinates = {{1, 3}, {2, 3}, {3, 3}};
        int[][] vehicleK3Coordinates = {{0, 5}, {1, 5}, {2, 5}};
        int[][] vehicleC3Coordinates = {{5, 2}, {5, 3}, {5, 4}};

        level3.put("X", new Vehicle("X", vehicleX3Coordinates));
        level3.put("A", new Vehicle("A", vehicleA3Coordinates));
        level3.put("G", new Vehicle("G", vehicleG3Coordinates));
        level3.put("H", new Vehicle("H", vehicleH3Coordinates));
        level3.put("B", new Vehicle("B", vehicleB3Coordinates));
        level3.put("J", new Vehicle("J", vehicleJ3Coordinates));
        level3.put("K", new Vehicle("K", vehicleK3Coordinates));
        level3.put("C", new Vehicle("C", vehicleC3Coordinates));
        levels.add(level3);
    }


    // Method to access the level2 list
    public static Map<String, Vehicle> getLevel() {
        return level1;
    };
}

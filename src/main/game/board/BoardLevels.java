package main.game.board;

import java.util.*;

public class BoardLevels {

    static Map<String, Vehicle> level2 = new HashMap<>();

    public BoardLevels() {
        int[][] vehicleXCoordinates = {{2, 0}, {2, 1}};
        int[][] vehicleACoordinates = {{1, 2}, {2, 2}};

        level2.put("X", new Vehicle("X", vehicleXCoordinates));
        level2.put("A", new Vehicle("A", vehicleACoordinates));
    }


    // Method to access the level1 list
    public static Map<String, Vehicle> getLevel() {
        return level2;
    };
}

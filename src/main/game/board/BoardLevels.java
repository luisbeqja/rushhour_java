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

        // level 4 -- medium
        Map<String, Vehicle> level4 = new HashMap<>();
        int[][] vehicleX4Coordinates = {{2, 3}, {2, 4}};
        int[][] vehicleA4Coordinates = {{1, 1}, {1, 2}};
        int[][] vehicleB4Coordinates = {{0, 4}, {0, 5}};
        int[][] vehicleC4Coordinates = {{0, 1}, {0, 2}};
        int[][] vehicleD4Coordinates = {{3, 0}, {3, 1}};
        int[][] vehicleE4Coordinates = {{5, 1}, {5, 2}};
        int[][] vehicleF4Coordinates = {{5, 3}, {5, 4}};

        int[][] vehicleG4Coordinates = {{0, 3}, {1, 3}};
        int[][] vehicleH4Coordinates = {{2, 2}, {3, 2}, {4, 2}};
        int[][] vehicleI4Coordinates = {{1, 5}, {2, 5}};
        int[][] vehicleJ4Coordinates = {{3, 5}, {4, 5}, {5, 5}};
        int[][] vehicleK4Coordinates = {{4, 0}, {5, 0}};


        level4.put("X", new Vehicle("X", vehicleX4Coordinates));
        level4.put("A", new Vehicle("A", vehicleA4Coordinates));
        level4.put("B", new Vehicle("B", vehicleB4Coordinates));
        level4.put("C", new Vehicle("C", vehicleC4Coordinates));
        level4.put("D", new Vehicle("D", vehicleD4Coordinates));
        level4.put("E", new Vehicle("E", vehicleE4Coordinates));
        level4.put("F", new Vehicle("F", vehicleF4Coordinates));
        level4.put("G", new Vehicle("G", vehicleG4Coordinates));
        level4.put("H", new Vehicle("H", vehicleH4Coordinates));
        level4.put("I", new Vehicle("I", vehicleI4Coordinates));
        level4.put("J", new Vehicle("J", vehicleJ4Coordinates));
        level4.put("K", new Vehicle("K", vehicleK4Coordinates));
        levels.add(level4);

        //level 5 -- medium
        Map<String, Vehicle> level5 = new HashMap<>();
        int[][] vehicleX5Coordinates = {{2, 1}, {2, 2}};
        int[][] vehicleA5Coordinates = {{0, 1}, {0, 2}};
        int[][] vehicleB5Coordinates = {{3, 3}, {3, 4}, {3, 5}};
        int[][] vehicleC5Coordinates = {{5, 2}, {5, 3}, {5, 4}};

        int[][] vehicleG5Coordinates = {{0, 0}, {1, 0}, {2, 0}};
        int[][] vehicleH5Coordinates = {{0, 3}, {1, 3}, {2, 3}};
        int[][] vehicleI5Coordinates = {{3, 2}, {4, 2}};
        int[][] vehicleJ5Coordinates = {{4, 5}, {5, 5}};

        level5.put("X", new Vehicle("X", vehicleX5Coordinates));
        level5.put("A", new Vehicle("A", vehicleA5Coordinates));
        level5.put("B", new Vehicle("B", vehicleB5Coordinates));
        level5.put("C", new Vehicle("C", vehicleC5Coordinates));
        level5.put("G", new Vehicle("G", vehicleG5Coordinates));
        level5.put("H", new Vehicle("H", vehicleH5Coordinates));
        level5.put("I", new Vehicle("I", vehicleI5Coordinates));
        level5.put("J", new Vehicle("J", vehicleJ5Coordinates));
        levels.add(level5);

        //level 6 -- medium
        Map<String, Vehicle> level6 = new HashMap<>();
        int[][] vehicleX6Coordinates = {{2, 1}, {2, 2}};
        int[][] vehicleA6Coordinates = {{0, 2}, {0, 3}};
        int[][] vehicleB6Coordinates = {{0, 4}, {0, 5}};
        int[][] vehicleC6Coordinates = {{3, 1}, {3, 2}};
        int[][] vehicleD6Coordinates = {{3, 3}, {3, 4}};
        int[][] vehicleE6Coordinates = {{4, 4}, {4, 5}};
        int[][] vehicleF6Coordinates = {{5, 0}, {5, 1}};

        int[][] vehicleG6Coordinates = {{0, 1}, {1, 1}};
        int[][] vehicleH6Coordinates = {{1, 0}, {2, 0}, {3, 0}};
        int[][] vehicleI6Coordinates = {{1, 5}, {2, 5}, {3, 5}};
        int[][] vehicleJ6Coordinates = {{4, 2}, {5, 2}};
        int[][] vehicleK6Coordinates = {{4, 3}, {5, 3}};

        level6.put("X", new Vehicle("X", vehicleX6Coordinates));
        level6.put("A", new Vehicle("A", vehicleA6Coordinates));
        level6.put("B", new Vehicle("B", vehicleB6Coordinates));
        level6.put("C", new Vehicle("C", vehicleC6Coordinates));
        level6.put("D", new Vehicle("D", vehicleD6Coordinates));
        level6.put("E", new Vehicle("E", vehicleE6Coordinates));
        level6.put("F", new Vehicle("F", vehicleF6Coordinates));
        level6.put("G", new Vehicle("G", vehicleG6Coordinates));
        level6.put("H", new Vehicle("H", vehicleH6Coordinates));
        level6.put("I", new Vehicle("I", vehicleI6Coordinates));
        level6.put("J", new Vehicle("J", vehicleJ6Coordinates));
        level6.put("K", new Vehicle("K", vehicleK6Coordinates));
        levels.add(level6);

        //level7 -- hard
        Map<String, Vehicle> level7 = new HashMap<>();
        int[][] vehicleX7Coordinates = {{2, 1}, {2, 2}};
        int[][] vehicleA7Coordinates = {{0, 0}, {0, 1}};
        int[][] vehicleB7Coordinates = {{3, 1}, {3, 2}, {3, 3}};
        int[][] vehicleC7Coordinates = {{5, 3}, {5, 4}, {5, 5}};

        int[][] vehicleG7Coordinates = {{0, 2}, {1, 2}};
        int[][] vehicleH7Coordinates = {{0, 3}, {1, 3}, {2, 3}};
        int[][] vehicleI7Coordinates = {{1, 0}, {2, 0}, {3, 0}};

        level7.put("X", new Vehicle("X", vehicleX7Coordinates));
        level7.put("A", new Vehicle("A", vehicleA7Coordinates));
        level7.put("B", new Vehicle("B", vehicleB7Coordinates));
        level7.put("C", new Vehicle("C", vehicleC7Coordinates));
        level7.put("G", new Vehicle("G", vehicleG7Coordinates));
        level7.put("H", new Vehicle("H", vehicleH7Coordinates));
        level7.put("I", new Vehicle("I", vehicleI7Coordinates));
        levels.add(level7);

        //level 8 -- hard
        Map<String, Vehicle> level8 = new HashMap<>();
        int[][] vehicleX8Coordinates = {{2, 1}, {2, 2}};
        int[][] vehicleA8Coordinates = {{0, 0}, {0, 1}};
        int[][] vehicleB8Coordinates = {{0, 3}, {0, 4}, {0, 5}};
        int[][] vehicleC8Coordinates = {{1, 4}, {1, 5}};
        int[][] vehicleD8Coordinates = {{3, 3}, {3, 4}};
        int[][] vehicleE8Coordinates = {{4, 0}, {4, 1}};
        int[][] vehicleF8Coordinates = {{5, 3}, {5, 4}, {5, 5}};

        int[][] vehicleG8Coordinates = {{1, 3}, {2, 3}};
        int[][] vehicleH8Coordinates = {{2, 0}, {3, 0}};
        int[][] vehicleI8Coordinates = {{2, 5}, {3, 5}, {4, 5}};
        int[][] vehicleJ8Coordinates = {{3, 2}, {4, 2}, {5, 2}};

        level8.put("X", new Vehicle("X", vehicleX8Coordinates));
        level8.put("A", new Vehicle("A", vehicleA8Coordinates));
        level8.put("B", new Vehicle("B", vehicleB8Coordinates));
        level8.put("C", new Vehicle("C", vehicleC8Coordinates));
        level8.put("D", new Vehicle("D", vehicleD8Coordinates));
        level8.put("E", new Vehicle("E", vehicleE8Coordinates));
        level8.put("F", new Vehicle("F", vehicleF8Coordinates));
        level8.put("G", new Vehicle("G", vehicleG8Coordinates));
        level8.put("H", new Vehicle("H", vehicleH8Coordinates));
        level8.put("I", new Vehicle("I", vehicleI8Coordinates));
        level8.put("J", new Vehicle("J", vehicleJ8Coordinates));
        levels.add(level8);

        //level 9 -- hard
        Map<String, Vehicle> level9 = new HashMap<>();
        int[][] vehicleX9Coordinates = {{2, 2}, {2, 3}};
        int[][] vehicleA9Coordinates = {{0, 0}, {0, 1}};
        int[][] vehicleB9Coordinates = {{0, 4}, {0, 5}};
        int[][] vehicleC9Coordinates = {{1, 0}, {1, 1}};
        int[][] vehicleD9Coordinates = {{3, 1}, {3, 2}, {3, 3}};
        int[][] vehicleE9Coordinates = {{5, 0}, {5, 1}};
        int[][] vehicleF9Coordinates = {{5, 4}, {5, 5}};

        int[][] vehicleG9Coordinates = {{0, 2}, {1, 2}};
        int[][] vehicleH9Coordinates = {{1, 4}, {2, 4}, {3, 4}};
        int[][] vehicleI9Coordinates = {{2, 0}, {3, 0}, {4, 0}};
        int[][] vehicleJ9Coordinates = {{3, 5}, {4, 5}};
        int[][] vehicleK9Coordinates = {{4, 3}, {5, 3}};

        level9.put("X", new Vehicle("X", vehicleX9Coordinates));
        level9.put("A", new Vehicle("A", vehicleA9Coordinates));
        level9.put("B", new Vehicle("B", vehicleB9Coordinates));
        level9.put("C", new Vehicle("C", vehicleC9Coordinates));
        level9.put("D", new Vehicle("D", vehicleD9Coordinates));
        level9.put("E", new Vehicle("E", vehicleE9Coordinates));
        level9.put("F", new Vehicle("F", vehicleF9Coordinates));
        level9.put("G", new Vehicle("G", vehicleG9Coordinates));
        level9.put("H", new Vehicle("H", vehicleH9Coordinates));
        level9.put("I", new Vehicle("I", vehicleI9Coordinates));
        level9.put("J", new Vehicle("J", vehicleJ9Coordinates));
        level9.put("K", new Vehicle("K", vehicleK9Coordinates));
        levels.add(level9);
    }


    // Method to access the level2 list
    public static Map<String, Vehicle> getLevel() {
        return level1;
    };
}

package main.game.board;

import java.util.ArrayList;
import java.util.List;

public class BoardLevels {

    static List<Vehicle> level1 = new ArrayList<>();


    public BoardLevels() {
        level1.add(new Vehicle("A", 1, 1)); // Add elements inside the constructor
        level1.add(new Vehicle("A", 1, 2)); // Add elements inside the constructor

        level1.add(new Vehicle("B", 5, 2)); // Add elements inside the constructor
        level1.add(new Vehicle("B", 4, 2)); // Add elements inside the constructor

        level1.add(new Vehicle("C", 3, 3)); // Add elements inside the constructor
        level1.add(new Vehicle("C", 3, 4)); // Add elements inside the constructor
        level1.add(new Vehicle("C", 3, 5)); // Add elements inside the constructor
    }

    // Method to access the level1 list
    public static List<Vehicle> getLevel() {
        return level1;
    };
}

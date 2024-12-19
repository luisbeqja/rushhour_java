package main.game.board;

import java.util.Arrays;

public class Vehicle {
    private final String cellValue; // e.g., "A" or "B"
    private int[][] position;

    //TODO: create setters with some check and add them to constructor
    public Vehicle(String value, int[][] position) {
        this.cellValue = value;
        this.position = position;
    }

    public String getCellValue() {
        return cellValue;
    }

    public int[][] getPosition() {
        return position;
    }

    // NOTE: move func for vehicle
    public void move(String direction, int numberOfMoves) {
        switch (direction) {
            case "u" -> {
                for (int i = 0; i < this.position.length; i++) {
                    this.position[i][0] -= numberOfMoves;
                }
            }
            case "d" -> {
                for (int i = 0; i < this.position.length; i++) {
                    this.position[i][0] += numberOfMoves;
                }
            }
            case "l" -> {
                for (int i = 0; i < this.position.length; i++) {
                    this.position[i][1] -= numberOfMoves;
                }
            }
            case "r" -> {
                for (int i = 0; i < this.position.length; i++) {
                    this.position[i][1] += numberOfMoves;
                }
            }
            default -> System.out.println("That is not a possible direction!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", cellValue, Arrays.deepToString(position));
    }
}

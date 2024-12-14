package main.game.board;

import java.util.Arrays;

public class Vehicle {
    private final String cellValue; // e.g., "A" or "B"
    private int[][] position;

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
            case "up" -> {
                for (int i = 0; i < this.position.length; i++) {
                    this.position[i][0] -= numberOfMoves;
                }
            }
            case "down" -> {
                for (int i = 0; i < this.position.length; i++) {
                    this.position[i][0] += numberOfMoves;
                }
            }
            case "left" -> {
                for (int i = 0; i < this.position.length; i++) {
                    this.position[i][1] -= numberOfMoves;
                }
            }
            case "right" -> {
                for (int i = 0; i < this.position.length; i++) {
                    this.position[i][1] += numberOfMoves;
                }
            }
            default -> System.out.println("Invalid direction");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", cellValue, Arrays.deepToString(position));
    }
}

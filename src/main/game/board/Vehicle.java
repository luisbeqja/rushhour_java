package main.game.board;

import java.util.Arrays;

public class Vehicle {
    private final String cellValue; // e.g., "A" or "B"
    private final int[][] position;

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

    @Override
    public String toString() {
        return String.format("%s %s", cellValue, Arrays.deepToString(position));
    }
}

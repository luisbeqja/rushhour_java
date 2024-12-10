package main.game.board;

public class Vehicle {
    private final String cellValue; // e.g., "A" or "B"
    private final int row;
    private final int column;

    public Vehicle(String label, int row, int column) {
        this.cellValue = label;
        this.row = row;
        this.column = column;

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getCellValue() {
        return cellValue;
    }

    @Override
    public String toString() {
        return cellValue + "[" + row + "," + column + "]";
    }
}

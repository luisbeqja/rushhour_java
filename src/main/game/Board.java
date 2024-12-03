package main.game;

public class Board {

    private boolean isBoardEmpty;

    public Board(boolean isBoardEmpty) {
        this.isBoardEmpty = isBoardEmpty;
    }

    /*GETTERS*/
    public boolean isBoardEmpty() {
        return isBoardEmpty;
    }

    /*SETTERS*/
    public void setIsBoardEmpty(boolean isBoardEmpty) {
        this.isBoardEmpty = isBoardEmpty;
    }

    /*METHODS*/
    // NOTE: this is printing just a sample of a board
    public String toString() {
        return """
                +---+---+---+---+---+---+
                |   |   | a |   |   |   |
                +---+---+---+---+---+---+
                |   |   | a |   |   |   |
                +---+---+---+---+---+---+
                |   |   | a |   |   |   |
                +---+---+---+---+---+---+
                | * | * |   |   |   |     *
                +---+---+---+---+---+---+
                |   | d | d | d | d |   |
                +---+---+---+---+---+---+
                |   |   | f | f |   |   |
                +---+---+---+---+---+---+
                """;
    }
}

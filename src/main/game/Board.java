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
    public void printOutBoard() {
        System.out.println(
                "+---+---+---+---+---+---+\n" +
                        "|   |   | a |   |   |   |\n" +
                        "+---+---+---+---+---+---+\n" +
                        "|   |   | a |   |   |   |\n" +
                        "+---+---+---+---+---+---+\n" +
                        "|   |   | a |   |   |   |\n" +
                        "+---+---+---+---+---+---+-\n" +
                        "| * | * |   |   |   |     *\n" +
                        "+---+---+---+---+---+---+-\n" +
                        "|   | d | d | d | d |   |\n" +
                        "+---+---+---+---+---+---+\n" +
                        "|   |   | f | f |   |   |\n" +
                        "+---+---+---+---+---+---+\n"
        );
    }
}

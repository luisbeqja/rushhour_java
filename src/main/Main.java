package main;

import main.game.Board;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Superchicche");
        Board board = new Board(false);

        board.printOutBoard();
    }
}
package main;

import main.database.Create;
import main.database.DatabaseConnection;
import main.game.board.Board;
import main.game.gamesession.GameSession;
import main.game.LeaderBoard;
import main.game.Player;
import main.game.board.BoardRules;

import java.time.LocalDate;
import java.util.Scanner;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Board board = new Board(false);
        boolean winCheck = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        LocalDate date = LocalDate.now();

        Player playerTest = new Player(
                name,
                date.toString(),
                email
        );
        System.out.println(playerTest.toString());



        LeaderBoard leaderBoard = new LeaderBoard(playerTest);

        GameSession gameSession = new GameSession(
                0,
                "",
                ""
        );


        BoardRules boardRules = new BoardRules(
                board.getVisualBoard()
        );

        // TEST DATABASE CONNECTION
        DatabaseConnection.getConnection();
        Create create = new Create();
        create.createPlayerTable();



        // NOTE: print out the board
        while (!winCheck) {
            System.out.println(board);
            System.out.println("Choose a vehicle: ");
            String vehicle = sc.nextLine();
            //TODO: check for this vehicle on the board

            //TODO: Check for the type of the vehicle and make the same for vertically
            //For horizontally vehicle
<<<<<<< src/main/Main.java
            System.out.println("Choose a direction(right/left/up/down): ");
            String direction = sc.nextLine();



            switch (direction) {
                case "right" -> System.out.println("Can Move Right " + BoardRules.canVehicleMoveRight(vehicle, 1));
                case "left" -> System.out.println("Can Move Left " + BoardRules.canVehicleMoveLeft(vehicle, 2));
                case "up" -> System.out.println("Can Move up " + BoardRules.canVehicleMoveUp(vehicle, 1));
                case "down" -> System.out.println("Can Move Down " + BoardRules.canVehicleMoveDown(vehicle, 2));


=======
            System.out.println("Choose a direction(right/left/down): ");
            String direction = sc.nextLine();

            switch (direction) {
                case "right" -> System.out.println("Can Move Right " + BoardRules.canVehicleMoveRight(vehicle, 1));
                case "left" -> System.out.println("Can Move Left " + BoardRules.canVehicleMoveLeft(vehicle, 2));
                case "down" -> System.out.println("Can Move Down " + BoardRules.canVehicleMoveDown(vehicle, 2));
                default -> System.out.println("Invalid direction: " + direction);
            }

            //TODO: move() for vehicle
        }


    }
}
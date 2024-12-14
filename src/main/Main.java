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

import static main.game.board.BoardRules.winCheck;

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

            //check if user input for vehicle is actually a vehicle that is on the board
            if (!BoardRules.isVehicleOnBoard(vehicle)) {
                System.out.println("That is not a vehicle on the board.");

            }
            
            //check if the vehicle can move horizontally AND if it is actually on the board
            if (BoardRules.canVehicleMoveHorizontally(vehicle) && BoardRules.isVehicleOnBoard(vehicle)) {
                System.out.println("Choose a direction(right/left): ");
                String direction = sc.nextLine();

                switch (direction.toLowerCase()) {
                    case "right" -> System.out.println("Can Move Right " + BoardRules.canVehicleMoveRight(vehicle, 1));
                    case "left" -> System.out.println("Can Move Left " + BoardRules.canVehicleMoveLeft(vehicle, 2));
                    default -> System.out.println("Invalid direction: " + direction);
                }
                //check if vehicle can move vertically AND if it is also actually on the board
            } else if (BoardRules.canVehicleMoveVertically(vehicle) && BoardRules.isVehicleOnBoard(vehicle)) {
                System.out.println("Choose a direction(up/down): ");
                String direction = sc.nextLine();

                //TODO: Artis' checks for canVehicleMoveUp and Down go here:
                switch (direction.toLowerCase()) {
                    case "down" -> System.out.println("Can Move Down " + BoardRules.canVehicleMoveDown(vehicle, 2));
                    case "up" -> System.out.println("Can Move up " + BoardRules.canVehicleMoveUp(vehicle, 1));
                    default -> System.out.println("Invalid direction: " + direction);
                }
            }
            //TODO: move() for vehicle
        }
    }
}
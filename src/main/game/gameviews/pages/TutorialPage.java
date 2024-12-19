package main.game.gameviews.pages;

import main.game.GameContext;
import main.game.gameviews.GameState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TutorialPage implements GameState {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void render() {
        System.out.println("""
                WELCOME TO RUSH HOUR BY LE SUPERCHICCHE
                ---------------------------------------
                Game goal:
                The goal of the game is to move the main car (X) to the exit point on the grid. 
                The exit is located at the far-right end of the row containing the red car. 
                To achieve this, you need to rearrange the other vehicles blocking the path.
                
                How to play:\s
                1) Enter your name\s
                2) Enter an email
                3) Select a level
                4) Select a vehicle to move (1 set of letters = 1 vehicle)
                5) Select which direction to move the vehicle
                ---------------------------------------
                To go back enter 1
                """);

    }

    @Override
    public void handleInput(GameContext context) {
    int choice = -1;
    boolean validInput = false;

    while (!validInput) {
        try {
            choice = scanner.nextInt();
            if (choice == 1) {

                validInput = true;
                context.setState(new FirstPage());
            } else {
                System.out.println("That is not a valid input. Enter 1 to go back!");
                scanner.nextLine();
            }
        } catch (InputMismatchException e) {
            System.out.println("Input is not a number. Enter 1 to go back!");
            scanner.nextLine(); //clear buffer
        }

    }
    }
}
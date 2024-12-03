package menu;

import utils.ScreenUtils;
import game.Game;

public class MenuManager {
    public void displayMenu() {
        ScreenUtils.clearScreen();
        System.out.println("Bingo Game!");
        ScreenUtils.waitForEnter();
        
        int choice = 0;
        while (choice != 4) {
            ScreenUtils.clearScreen();
            System.out.println("Main Menu");
            System.out.println("1. Play");
            System.out.println("2. Instructions");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = ScreenUtils.getIntInput();
            switch (choice) {
                case 1 -> Game.start();
                case 2 -> Game.displayInstructions();
                case 3 -> Game.exitGame();
                default -> printInvalidChoice();
            }
        }
    }
    
    private void printInvalidChoice() {
        System.out.println("Invalid choice. Try again.");
        ScreenUtils.waitForEnter();
    }

}

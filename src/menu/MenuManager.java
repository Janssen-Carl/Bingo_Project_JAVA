package menu;

import utils.ScreenUtils;
import game.Game;

public class MenuManager {
    public void displayMenu() {
        ScreenUtils.clearScreen();
        ScreenUtils.newLine();
        ScreenUtils.displayWithDelay("\t\t\t\tW E L C O M E  T O  B I N G O");
        displaySplashEffect("\t\t\t\tW E L C O M E  T O  B I N G O", 5, 200);
        ScreenUtils.displayWithDelay("\n\n\n\t\t\t          Press ENTER to continue...");
        ScreenUtils.waitForEnter("");
        
        int choice = 0;
        while (choice != 4) {
            ScreenUtils.clearScreen();
            ScreenUtils.newLine();
            ScreenUtils.displayWithDelay("\t\t\t\tM A I N  M E N U");
            System.out.println("\t\t\t\t [1] Play");
            System.out.println("\t\t\t\t [2] Instructions");
            System.out.println("\t\t\t\t [3] Exit\n");
            System.out.print("\t\t\t\t Enter your choice: ");
            
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
    
    public static void displaySplashEffect(String text, int blinks, int intervalMillis) {
        for (int i = 0; i < blinks; i++) {
            ScreenUtils.clearScreen();
            ScreenUtils.newLine();
            System.out.println("\u001B[32m" + text + "\u001B[0m");
            
            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Interrupted during splash effect.");
            }
            
            ScreenUtils.clearScreen();
            
            try {
                Thread.sleep(intervalMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Interrupted during splash effect.");
            }
        }
        
        ScreenUtils.clearScreen();
        ScreenUtils.newLine();
        System.out.println("\u001B[32m" + text + "\u001B[0m");
    }
    
    
}

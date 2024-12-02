package menu;

import java.util.NoSuchElementException;
import java.util.Scanner;
import leaderboard.Leaderboard;
import main.Game;
import utils.ScreenUtils;

public class MenuManager {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        ScreenUtils.clearScreen();
        
        System.out.println("Bingo Game!");
        ScreenUtils.waitForEnter();
        menuLoop();
    }
    
    public void menuLoop(){
        int choice = 0;
        while(choice != 4){
            ScreenUtils.clearScreen();
            ScreenUtils.flushInputStream(scanner);
            
            System.out.println("Main Menu");
            System.out.println("1. Start New Game");
            System.out.println("2. Continue");
            System.out.println("3. View Leaderboard");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice: ");
            
            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 4) {
                        ScreenUtils.clearScreen();
                        System.out.println("Invalid choice. Try again.");
                    } else {
                        handleMenuChoice(choice);
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear the invalid input
                }
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.println("Error reading input. Please try again.");
                scanner.nextLine(); // Clear the invalid input
            }
            
            ScreenUtils.flushInputStream(scanner);
        }
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> Game.startNewGame();
            case 2 -> Game.continueGame();
            case 3 -> Leaderboard.showLeaderboard();
            case 4 -> Game.exitGame();
        }
    }
    
    
}

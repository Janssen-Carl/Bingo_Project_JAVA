package menu;

import java.util.Scanner;
import leaderboard.Leaderboard;
import main.Game;

public class MenuManager {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Welcome to Bingo!");
        
        menuLoop();
    }
    
    public void menuLoop(){
        int choice = 0;
        while(choice != 4){
            System.out.println("1. Start New Game");
            System.out.println("2. Continue");
            System.out.println("3. View Leaderboard");
            System.out.println("4. Exit");
            
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Try again.");
            }
            else {
                handleMenuChoice(choice);
            }
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

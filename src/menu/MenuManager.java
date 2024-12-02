package menu;

import java.util.Scanner;
import leaderboard.Leaderboard;
import main.Game;

public class MenuManager {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Welcome to Bingo!");
        System.out.println("1. Start New Game");
        System.out.println("2. Continue");
        System.out.println("3. View Leaderboard");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();
        handleMenuChoice(choice);
    }

    private void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> Game.startNewGame();
            case 2 -> Game.continueGame();
            case 3 -> Leaderboard.showLeaderboard();
            case 4 -> System.exit(0);
            default -> System.out.println("Invalid choice. Try again.");
        }
    }
}

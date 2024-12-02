package main;
import java.util.Scanner;

import leaderboard.Leaderboard;

public class Main {
      private Game game;
      private Leaderboard leaderboard;

      public Main() {
            game = new Game();
            leaderboard = new Leaderboard();
      }

      void pressEnterToContinue() {
            System.out.println("Press ENTER to continue...");
            try {
                  System.in.read();
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      void displayWelcomeToBingo() {
            // make this the first thing that pops up on the screen, should have design
            System.out.println("Bingo Game!");
            pressEnterToContinue();
      }

      int displayMenu() {
            int choice;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to Bingo!");
            System.out.println("1. Start a new game");
            System.out.println("2. Load a saved game");
            System.out.println("3. Leaderboard");
            System.out.println("4. Exit");

            choice = scanner.nextInt();

            if (choice < 1 || choice > 4) {
                  System.out.println("Invalid choice. Please try again.");
                  pressEnterToContinue();
                  return displayMenu();
            }

            return choice;
      }

      void flushScreen() {
            try {
                  if (System.getProperty("os.name").contains("Windows")) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                  } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                  }
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }

      void exitAnimation(boolean saveGame) {
            flushScreen();

            if (saveGame) {
                  System.out.println("Saving game...");
                  System.out.println("Game saved successfully!");
            }

            System.out.println("Thank you for playing Bingo!");
            System.out.println("Exiting...");
            // exit animation
      }

      void gameLoop() {
            while (true) {
                  flushScreen();
                  displayWelcomeToBingo();
                  flushScreen();

                  int menuChoice = displayMenu();

                  switch (menuChoice) {
                        case 1:
                              game.startNewGame();
                              break;
                        case 2:
                              game.loadSavedGame();
                              break;
                        case 3:
                              leaderboard.displayLeaderboard();
                              break;
                        case 4:
                              // exit
                              exitAnimation(false);
                              System.exit(0);
                              break;
                        default:
                  }
            }
      }

      public static void main(String[] args) {
            Main mainInstance = new Main();
            mainInstance.gameLoop();
      }
}
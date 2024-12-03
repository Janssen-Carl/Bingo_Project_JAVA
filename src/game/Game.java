package game;

import models.NumberTracker;
import models.Player;
import utils.ScreenUtils;
import patterns.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
   public static void start() {
      ScreenUtils.clearScreen();
      System.out.println("Select Game Mode:");
      System.out.println("1. Player vs Player");
      System.out.println("2. Player vs Computer");
      System.out.println("3. Back");
      int mode = ScreenUtils.getIntInput();
      
      switch (mode) {
         case 1 -> startPlayerVsPlayer();
         case 2 -> startPlayerVsComputer();
         case 3 -> {
            System.out.println("Returning to main menu...");
            ScreenUtils.waitForEnter();
         }
         default -> {
            System.out.println("Invalid choice.");
            ScreenUtils.waitForEnter("Press Enter to try again...");
            start();
         }
      }
   }
   
   
   private static void startPlayerVsPlayer() {
      NumberTracker tracker = new NumberTracker();
      
      Player player1 = new Player();
      Player player2 = new Player();
      
      System.out.println("PLAYER VS PLAYER");
      System.out.print("Enter Player 1's name: ");
      player1.setName(ScreenUtils.getStringInput());
      
      System.out.print("Enter Player 2's name: ");
      player2.setName(ScreenUtils.getStringInput());
      
      System.out.println(player1.getName() + " vs " + player2.getName());
      
      player1.generateCard(tracker);
      player2.generateCard(tracker);
      
      System.out.println(player1.getName() + "'s card:");
      player1.displayCard();
      
      System.out.println(player2.getName() + "'s card:");
      player2.displayCard();
      
      Pattern pattern = selectPattern();
      
      // Proceed to gameplay
      ScreenUtils.waitForEnter("Press Enter to start the game...");
      
      // Game loop
      List<Player> players = new ArrayList<>();
      
      players.add(player1);
      players.add(player2);
      
      
      GameLoop.startGame(players, pattern);
   }
   
   
   public static Pattern selectPattern() {
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("-- PATTERN SELECTION --");
      System.out.println("1. Line Pattern (Horizontal/Vertical/Diagonal)");
      System.out.println("2. Four Corners");
      System.out.println("3. Full Card");
      System.out.println("4. Generate Random Pattern");
      System.out.print("Choose a pattern (1-4): ");
      
      int choice = scanner.nextInt();
      
      switch (choice) {
         case 1:
            return new LinePattern();
         case 2:
            return new FourCornersPattern();
         case 3:
            return new FullCardPattern();
         case 4:
            RandomPattern randomPattern = new RandomPattern();
            randomPattern.displayPattern(); // Display the generated pattern
            return randomPattern;
         default:
            System.out.println("Invalid choice, defaulting to Line Pattern.");
            return new LinePattern();
      }
   }
   
   private static void startPlayerVsComputer() {
      // Game logic for Player vs Computer
      System.out.println("Player vs Computer mode not implemented yet.");
      ScreenUtils.waitForEnter();
   }
   
   public static void exitGame() {
      System.out.println("Exiting the game. Goodbye!");
      System.exit(0);
   }
   
   public static void displayInstructions() {
      ScreenUtils.clearScreen();
      System.out.println("Instructions:\nPlay Bingo and achieve the pattern to win!");
      ScreenUtils.waitForEnter();
   }
}

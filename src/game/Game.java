package game;

import models.NumberTracker;
import models.Player;
import utils.ScreenUtils;
import patterns.*;
import models.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
   public static boolean flag = false;
   
   
   public static void start() {
      ScreenUtils.clearScreen();
      System.out.println("Select Game Mode:");
      System.out.println("1. Player vs Player");
      System.out.println("2. Player vs Computer");
      System.out.println("3. Back");
      
      System.out.print("\nEnter your choice: ");
      int mode = ScreenUtils.getIntInput();
      
      switch (mode) {
         case 1 -> startPlayerVsPlayer();
         case 2 -> startPlayerVsComputer();
         case 3 -> {
            ScreenUtils.clearScreen();
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
      
      ScreenUtils.clearScreen();
      System.out.println("PLAYER VS PLAYER");
      System.out.print("Enter Player 1's name: ");
      player1.setName(ScreenUtils.getStringInput());
      
      System.out.print("Enter Player 2's name: ");
      player2.setName(ScreenUtils.getStringInput());
      
      ScreenUtils.clearScreen();
      System.out.println(player1.getName() + " vs " + player2.getName());
      
      System.out.println();
      player1.generateCard(tracker);
      player2.generateCard(tracker);
      
      System.out.println(player1.getName() + "'s card:");
      player1.displayCard();
      
      System.out.println(player2.getName() + "'s card:");
      player2.displayCard();
      
      Pattern pattern = selectPattern();
      
      // Proceed to gameplay
      ScreenUtils.waitForEnter("\nPress Enter to start the game...");
      
      // Game loop
      List<Player> players = new ArrayList<>();
      
      players.add(player1);
      players.add(player2);
      
      
      GameLoop.startGame(players, pattern, flag);
   }
   
   
   public static Pattern selectPattern() {
      
      System.out.println("\n\nPATTERN SELECTION");
      System.out.println("1. Line Pattern (Horizontal/Vertical/Diagonal)");
      System.out.println("2. Four Corners");
      System.out.println("3. Full Card");
      System.out.println("4. Generate Random Pattern\n");
      System.out.print("Enter Choice: ");
      
      int choice = ScreenUtils.getIntInput();
      
      switch (choice) {
         case 1:
            return new LinePattern();
         case 2:
            return new FourCornersPattern();
         case 3:
            return new FullCardPattern();
         case 4:
            RandomPattern randomPattern = new RandomPattern();
            RandomPattern.displayPattern(); // Display the generated pattern
            flag = true;
            return randomPattern;
         default:
            System.out.println("Invalid choice, defaulting to Line Pattern.");
            return new LinePattern();
      }
   }
   
   private static void startPlayerVsComputer() {
      NumberTracker tracker = new NumberTracker();
      Player player = new Player();
      
      System.out.println("PLAYER VS COMPUTER");
      System.out.print("Enter Player's name: ");
      player.setName(ScreenUtils.getStringInput());
      
      System.out.println(player.getName() + " vs Computer");
      
      System.out.println();
      player.generateCard(tracker);
      Computer computer = new Computer();
      computer.generateCard(tracker);
      
      System.out.println(player.getName() + "'s card:");
      player.displayCard();
      
      System.out.println(computer.getName() + "'s card:");
      computer.displayCard();
      
      Pattern pattern = selectPattern();
      
      // Proceed to gameplay
      ScreenUtils.waitForEnter("\nLoading Game...\nPress Enter to start the game...");
      
      // Game loop
      List<Player> participants = new ArrayList<>();
      participants.add(player);
      
      // Add Computer as a participant using a wrapper to match the Player class
      Player computerWrapper = new Player(computer.getName()) {
         @Override
         public void displayCard() {
            computer.displayCard();
         }
         
         @Override
         public void markNumber(int number) {
            computer.markNumber(number);
         }
         
         @Override
         public Set<Integer> getMarkedIndices() {
            return computer.getMarkedIndices();
         }
      };
      participants.add(computerWrapper);
      
      GameLoop.startGame(participants, pattern, flag);
   }
   
   
   
   public static void exitGame() {
      ScreenUtils.clearScreen();
      System.out.println("Exiting the game. Goodbye!");
      System.exit(0);
   }
   
   public static void displayInstructions() {
      ScreenUtils.clearScreen();
      System.out.println("Instructions:\nPlay Bingo and achieve the pattern to win!");
      ScreenUtils.waitForEnter();
   }
   
}

package game;

import models.NumberTracker;
import models.Player;
import utils.ScreenUtils;

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
         case 3 -> System.out.println("return ka sa main menu");
         default -> System.out.println("Invalid choice.");
      }
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
   
   private static void startPlayerVsPlayer() {
//      System.out.print("PLayer vs Player");
//      ScreenUtils.waitForEnter();
      
      NumberTracker tracker = new NumberTracker();
      
      Player player1 = new Player();
      Player player2 = new Player();
      
      System.out.println("PLAYER VS PLAYER");
      System.out.print("Enter Player 1's name:  ");
      String player1Name = ScreenUtils.getStringInput();
      player1.setName(player1Name);
      
      System.out.print("Enter Player 2's name:  ");
      String player2Name = ScreenUtils.getStringInput();
      player2.setName(player2Name);
      
      System.out.println(player1.getName() + " vs " + player2.getName());
      System.out.println("BINGO CARD");
      System.out.println("1. 1 Card");
      System.out.println("2. 2 Cards");
      System.out.println("3. Input number of cards");
      
      System.out.print("Enter your choice: ");
      int numCards = ScreenUtils.getIntInput();
      // generate cards
      if (numCards == 1) {
         player1.generateCards(1, tracker);
         player2.generateCards(1, tracker);
      } else if (numCards == 2) {
         player1.generateCards(2, tracker);
         player2.generateCards(2, tracker);
      } else {
         System.out.print("Enter the number of cards (max 10): ");
         int customCards = ScreenUtils.getIntInput();
         player1.generateCards(customCards, tracker);
         player2.generateCards(customCards, tracker);
      }
      
      // Display and confirm cards
      confirmCards(player1, tracker);
      confirmCards(player2, tracker);
      
      // Proceed to the next step
      ScreenUtils.waitForEnter();
   }
   
   private static void confirmCards(Player player, NumberTracker tracker) {
      ScreenUtils.clearScreen();
      String choice;
      
      player.displayCards();
      System.out.print("Are you satisfied with these cards? (Y/N): ");
      
      choice = ScreenUtils.getStringInput().trim();
      
      if (choice.equalsIgnoreCase("Y")) {
         ScreenUtils.waitForEnter();
      } else if (choice.equalsIgnoreCase("N")) {
         player.generateCards(player.getCards().size(), tracker);// Regenerate cards
         
         player.displayCards();
         ScreenUtils.waitForEnter();
      } else {
         System.out.println("Invalid input. Please enter Y or N."); // Handle unexpected input
         ScreenUtils.waitForEnter();
      }
      
   }
   
   private static void startPlayerVsComputer() {
      // Game logic for Player vs Computer
      System.out.print("PLayer vs Computer");
      ScreenUtils.waitForEnter();
      
   }
   
   
   
}

package game;

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
      if (numCards == 1) {
         player1 = new Player(player1Name, 1);
         
         // how do i generate cards?
         
         player2 = new Player(player2Name, 1);
         
         
      } else if (numCards == 2) {
         player1 = new Player(player1Name, 2);
         player2 = new Player(player2Name, 2);
      } else {
         System.out.print("Enter number of cards: ");
         int cards = ScreenUtils.getIntInput();
         player1 = new Player(player1Name, cards);
         player2 = new Player(player2Name, cards);
      }
      
      ScreenUtils.waitForEnter();
   }
   
   private static void startPlayerVsComputer() {
      // Game logic for Player vs Computer
      System.out.print("PLayer vs Computer");
      ScreenUtils.waitForEnter();
      
   }
}

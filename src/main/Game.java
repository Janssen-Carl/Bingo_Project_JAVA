package main;

import models.Card;
import models.Computer;
import models.Player;
import utils.ScreenUtils;

import java.util.Scanner;

public class Game {
   public static void startNewGame() {
      Scanner scanner = new Scanner(System.in);
      
      ScreenUtils.clearScreen();
      System.out.println("Starting a new game...");
      ScreenUtils.clearScreen();
      while (true) {
         System.out.println("Game Mode:");
         System.out.println("1. Single Player");
         System.out.println("2. Multiplayer");
         System.out.println("3. Back");
         System.out.print("Enter your choice: ");
         int choice = scanner.nextInt();
         if (choice < 1 || choice > 3) {
            ScreenUtils.clearScreen();
            System.out.println("Invalid choice. Try again.");
         } else {
            gameModeChoice(choice);
            break;
         }
      }
   }
   
   public static void continueGame() {
      System.out.println("Continuing game...");
      // Load saved state and resume
   }
   
   public static void exitGame() {
      System.out.println("Exiting game...");
      System.exit(0);
   }
   
   public static void gameModeChoice(int choice) {
      switch (choice) {
         case 1 -> SinglePlayerGame();
         case 2 -> MultiplayerGame();
         case 3 -> new menu.MenuManager().menuLoop();
      }
   }
   
   public static void SinglePlayerGame() {
      // Player vs Computer
      Player p = new Player();
      Computer c = new Computer();
      
      ScreenUtils.clearScreen();
      System.out.println("Single Player Game");
      System.out.println("Enter name? press 1 for yes, 2 for no");
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();
      if (choice == 1) {
         System.out.print("Enter your name: ");
         p.setName(scanner.next());
      } else {
         p.setName("Player");
      }
      
      ScreenUtils.clearScreen();
      System.out.println("Welcome " + p.getName());
      System.out.println("Press Enter to continue...");
      ScreenUtils.waitForEnter();
      
      while (true) {
         ScreenUtils.clearScreen();
         System.out.println("How many cards do you want to play with? (1-3)");
         int numCards = scanner.nextInt();
         
         if (numCards < 1 || numCards > 3) {
            System.out.println("Invalid number of cards. Try again.");
            ScreenUtils.waitForEnter();
         }
         else {
            p.setCards(new Card(numCards).getCards());
            //display all cards
            p.getCard().printCards();
            
         }
      }
   }
   
   public static void MultiplayerGame() {
      // Player vs Player
   }
   
   
}

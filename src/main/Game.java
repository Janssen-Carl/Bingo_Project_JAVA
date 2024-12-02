// src/main/Game.java
package main;

import models.Card;
import models.Computer;
import models.Player;
import utils.PatternUtil;
import utils.ScreenUtils;
import utils.Choice;

import java.util.Scanner;

public class Game {
   private static final int SINGLE_PLAYER = 1;
   private static final int MULTIPLAYER = 2;
   private static final int BACK = 3;
   
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
         int choice = Choice.getValidChoice(scanner, 1, 3);
         gameModeChoice(choice);
         break;
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
         case SINGLE_PLAYER -> singlePlayerGame();
         case MULTIPLAYER -> multiplayerGame();
         case BACK -> new menu.MenuManager().menuLoop();
      }
   }
   
   public static void singlePlayerGame() {
      Player player = new Player();
      Computer computer = new Computer();
      
      ScreenUtils.clearScreen();
      gameTitle(SINGLE_PLAYER);
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter name? press 1 for yes, 2 for no");
      int choice = Choice.getValidChoice(scanner, 1, 2);
      if (choice == 1) {
         ScreenUtils.clearScreen();
         gameTitle(SINGLE_PLAYER);
         System.out.print("Enter your name: ");
         player.setName(scanner.next());
      } else {
         player.setName("Player");
      }
      
      ScreenUtils.clearScreen();
      System.out.println("Welcome " + player.getName());
      System.out.println("Press Enter to continue...");
      ScreenUtils.waitForEnter();
      
      while (true) {
         ScreenUtils.clearScreen();
         System.out.println("How many cards do you want to play with? (1-3)");
         int numCards = Choice.getValidChoice(scanner, 1, 3);
         player.setCards(new Card(numCards).getCards());
         computer.setCards(new Card(numCards).getCards());
         player.getCard().printCards();
         computer.getCard().printCards();
         
         System.out.println("Satisfied with the cards? (1. Yes, 2. No, regenerate cards)");
         int satisfied = Choice.getValidChoice(scanner, 1, 2);
         if (satisfied == 1) {
            break;
         }
      }
      
      while (true) {
         System.out.println("Bingo Pattern");
         System.out.println("1. Diagonal/Horizontal/Vertical");
         System.out.println("2. Full House");
         System.out.println("3. Generate Random Pattern");
         System.out.print("Enter your choice: ");
         int pattern = Choice.getValidChoice(scanner, 1, 3);
         PatternUtil patternUtil = new PatternUtil(pattern);
         
         GameStart(player, computer, SINGLE_PLAYER, player.getName(), player.getCard().getCards().size(), patternUtil);
         break;
      }
   }
   
   public static void multiplayerGame() {
      // Player vs Player
   }
   
   public static void GameStart(Player player, Computer computer, int gameMode, String playerName, int numCards, PatternUtil patternUtil) {
   
   }
   
   private static void gameTitle(int choice) {
      switch (choice) {
         case SINGLE_PLAYER -> System.out.println("Single Player Game:");
         case MULTIPLAYER -> System.out.println("Multiplayer Game:");
      }
   }
}
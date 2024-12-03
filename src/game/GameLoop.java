package game;

import models.Player;
import patterns.Pattern;
import utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLoop {
   private static final int MAX_BINGO_CHIPS = 75;
   private static boolean gameRunning = true;
   private static int numDrawn = 0;
   private static final List<Integer> drawnChips = new ArrayList<>();
   private static final List<Player> winners = new ArrayList<>();
   
   public static void startGame(List<Player> players, Pattern pattern) {
      Random random = new Random();
      
      while (gameRunning) {
         if (numDrawn >= MAX_BINGO_CHIPS) {
            System.out.println("All chips have been drawn. Ending game.");
            break;
         }
         
         ScreenUtils.clearScreen();
         int drawnChip = drawBingoChip(random);
         drawnChips.add(drawnChip);
         numDrawn++;
         
         displayDrawnChips();
         updatePlayerCards(players, drawnChip, pattern);
         displayPlayerCards(players);
         
         if (!winners.isEmpty()) {
            gameRunning = false;
            displayWinners();
            break;
         }
         
         if (gameRunning) {
            System.out.println("Press ENTER to draw the next chip.");
            ScreenUtils.waitForEnter();
         }
      }
   }
   
   private static int drawBingoChip(Random random) {
      int newChip;
      do {
         newChip = random.nextInt(MAX_BINGO_CHIPS) + 1;
      } while (drawnChips.contains(newChip));
      return newChip;
   }
   
   private static void displayDrawnChips() {
      System.out.println("Drawn Chips: ");
      for (int i = 0; i < drawnChips.size(); i++) {
         if (i > 0 && i % 10 == 0) System.out.println(); // Newline every 10 numbers
         System.out.printf("%3d ", drawnChips.get(i));
      }
      System.out.println("\n\nMost Recent Chip: " + drawnChips.get(drawnChips.size() - 1));
   }
   
   private static void updatePlayerCards(List<Player> players, int drawnChip, Pattern pattern) {
      for (Player player : players) {
         player.markNumber(drawnChip); // Mark the number in the player's card
         
         // Check if the player's marked indices match the pattern
         if (pattern.matches(player.getMarkedIndices()) && !winners.contains(player)) {
            winners.add(player);
         }
      }
   }
   
   
   private static void displayPlayerCards(List<Player> players) {
      for (Player player : players) {
         System.out.println("Player: " + player.getName());
         player.displayCard(); // The `displayCard` method handles coloring for marked numbers
      }
   }
   
   private static void displayWinners() {
      System.out.println("Bingo! We have winners!");
      for (Player winner : winners) {
         System.out.println("Winner: " + winner.getName());
      }
   }
}

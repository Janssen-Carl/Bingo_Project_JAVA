package models;

import patterns.Pattern;
import java.util.Random;

public class BingoCard {
   private final int[][] card;
   private final boolean[][] marked;
   private static final int SIZE = 5;
   
   public BingoCard(NumberTracker tracker) {
      this.card = new int[SIZE][SIZE];
      this.marked = new boolean[SIZE][SIZE];
      generateCard(tracker); // Use the tracker during card generation
   }
   
   private void generateCard(NumberTracker tracker) {
      Random random = new Random();
      for (int col = 0; col < SIZE; col++) {
         for (int row = 0; row < SIZE; row++) {
            if (row == 2 && col == 2) {
               card[row][col] = 0; // Free space in the center
               continue;
            }
            int number;
            do {
               number = random.nextInt(15) + 1 + (col * 15); // Column-specific range
            } while (tracker.isNumberUsed(number)); // Avoid duplicates
            tracker.markNumber(number);
            card[row][col] = number;
         }
      }
   }
   
   public void displayCard() {
      System.out.println("BINGO CARD:");
      for (int[] row : card) {
         for (int num : row) {
            if (num == 0) {
               System.out.print(" FS "); // Free Space
            } else {
               System.out.printf("%3d ", num);
            }
         }
         System.out.println();
      }
   }
   
   public void markNumber(int number) {
      for (int row = 0; row < SIZE; row++) {
         for (int col = 0; col < SIZE; col++) {
            if (card[row][col] == number) {
               marked[row][col] = true;
               System.out.println("Number " + number + " marked on the card!");
            }
         }
      }
   }
   
   public boolean checkPattern(Pattern pattern) {
      return pattern.matches(this);
   }
   
   public boolean[][] getMarked() {
      return marked;
   }
   
   public int[][] getGrid() {
      return card;
   }
}

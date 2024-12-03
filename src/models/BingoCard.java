package models;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BingoCard {
   private final int[][] numbers;
   private final boolean[][] marked;
   private static final int SIZE = 5;
   
   public BingoCard(NumberTracker tracker) {
      this.numbers = new int[SIZE][SIZE];
      this.marked = new boolean[SIZE][SIZE];
      generateCard(tracker);
   }
   
   private void generateCard(NumberTracker tracker) {
      Random random = new Random();
      for (int col = 0; col < SIZE; col++) {
         for (int row = 0; row < SIZE; row++) {
            if (row == 2 && col == 2) {
               numbers[row][col] = 0;
               continue;
            }
            int number;
            do {
               number = random.nextInt(15) + 1 + (col * 15); // Column-specific range
            } while (tracker.isNumberUsed(number)); // Avoid duplicates
            tracker.markNumber(number);
            numbers[row][col] = number;
         }
      }
   }
   
   public void markNumber(int number) {
      for (int row = 0; row < 5; row++) {
         for (int col = 0; col < 5; col++) {
            if (numbers[row][col] == number) {
               marked[row][col] = true;
            }
         }
      }
   }
   
   public int markNumberAndReturnIndex(int number) {
      for (int row = 0; row < 5; row++) {
         for (int col = 0; col < 5; col++) {
            if (numbers[row][col] == number) {
               marked[row][col] = true;  // Mark the number
               // Calculate the index in a 1D representation of the card
               return row * 5 + col;
            }
         }
      }
      return -1; // Return -1 if the number isn't found on the card
   }
   
   public Set<Integer> getMarkedIndices() {
      Set<Integer> markedIndices = new HashSet<>();
      for (int row = 0; row < SIZE; row++) {
         for (int col = 0; col < SIZE; col++) {
            if (marked[row][col]) {
               // Calculate the index and add to the set
               markedIndices.add(row * 5 + col);  // The index in the 1D representation
            }
         }
      }
      return markedIndices;
   }
   
   
   public void displayCard() {
      for (int row = 0; row < 5; row++) {
         for (int col = 0; col < 5; col++) {
            if (marked[row][col]) {
               // Display marked numbers in red
               System.out.printf("\u001B[31m%2d\u001B[0m ", numbers[row][col]);
            } else {
               System.out.printf("%2d ", numbers[row][col]);
            }
         }
         System.out.println();
      }
   }
   
   public boolean[][] getMarked() {
      return marked;
   }
   
}

package models;

import java.util.Random;

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
               number = random.nextInt(15) + 1 + (col * 15);
            } while (tracker.isNumberUsed(number));
            tracker.markNumber(number);
            numbers[row][col] = number;
         }
      }
   }
   
   public int markNumberAndReturnIndex(int number) {
      for (int row = 0; row < 5; row++) {
         for (int col = 0; col < 5; col++) {
            if (numbers[row][col] == number) {
               marked[row][col] = true;
               // calculate the index in a 1D representation of the card
               return row * 5 + col;
            }
         }
      }
      return -1; // Return -1 if the number isn't found on the card
   }
   
   public void displayCard() {
      System.out.println(" B  I  N  G  O ");
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
   
}

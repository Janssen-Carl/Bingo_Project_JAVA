package patterns;

import models.BingoCard;
import java.util.Random;

public class RandomPattern implements Pattern {
   private static final int SIZE = 5; // Fixed size for standard Bingo
   private final boolean[][] randomPattern;
   
   public RandomPattern() {
      this.randomPattern = generateRandomPattern();
   }
   
   @Override
   public boolean matches(BingoCard card) {
      boolean[][] marked = card.getMarked();
      
      for (int row = 0; row < SIZE; row++) {
         for (int col = 0; col < SIZE; col++) {
            if (randomPattern[row][col] && !marked[row][col]) {
               return false;
            }
         }
      }
      return true;
   }
   
   private boolean[][] generateRandomPattern() {
      boolean[][] pattern = new boolean[SIZE][SIZE];
      Random random = new Random();
      
      // Randomly mark cells in the pattern
      for (int row = 0; row < SIZE; row++) {
         for (int col = 0; col < SIZE; col++) {
            pattern[row][col] = random.nextBoolean();
         }
      }
      
      // Ensure at least one cell is marked in the pattern
      pattern[random.nextInt(SIZE)][random.nextInt(SIZE)] = true;
      
      return pattern;
   }
   
   public void displayPattern() {
      System.out.println("Random Pattern:");
      for (boolean[] row : randomPattern) {
         for (boolean cell : row) {
            System.out.print(cell ? "X " : ". ");
         }
         System.out.println();
      }
   }
}

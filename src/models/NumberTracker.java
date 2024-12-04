package models;

//import java.util.Random;

public class NumberTracker {
   private final int[] numberTracker = new int[75]; // 0-based array for 1-75 numbers
   
   // Mark a number as used
   public void markNumber(int number) {
      if (number < 1 || number > 75) {
         throw new IllegalArgumentException("Number must be between 1 and 75.");
      }
      numberTracker[number - 1] = 1; // Mark index (number - 1) as used
   }
   
   // Check if a number is already used
   public boolean isNumberUsed(int number) {
      if (number < 1 || number > 75) {
         throw new IllegalArgumentException("Number must be between 1 and 75.");
      }
      return numberTracker[number - 1] == 1;
   }
   
   
   
   
}

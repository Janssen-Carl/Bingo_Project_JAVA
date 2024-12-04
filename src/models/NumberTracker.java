package models;


public class NumberTracker {
   private final int[] numberTracker = new int[75];
   
   public void markNumber(int number) {
      if (number < 1 || number > 75) {
         throw new IllegalArgumentException("Number must be between 1 and 75.");
      }
      numberTracker[number - 1] = 1;
   }
   
   // Check if a number is already used
   public boolean isNumberUsed(int number) {
      if (number < 1 || number > 75) {
         throw new IllegalArgumentException("Number must be between 1 and 75.");
      }
      return numberTracker[number - 1] == 1;
   }
   
   
   
   
}

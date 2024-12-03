package patterns;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomPattern implements Pattern {
   private final Set<Integer> randomIndices = new HashSet<>();
   
   public RandomPattern() {
      generateRandomIndices();
   }
   
   private void generateRandomIndices() {
      Random random = new Random();
      while (randomIndices.size() < 5) { // Generate a pattern of 5 indices
         randomIndices.add(random.nextInt(25)); // Random numbers 0-24
      }
   }
   
   @Override
   public boolean matches(Set<Integer> markedIndices) {
      return markedIndices.containsAll(randomIndices);
   }
   
   public void displayPattern() {
      System.out.println("Random Pattern Indices: " + randomIndices);
   }
}

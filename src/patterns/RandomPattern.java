package patterns;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomPattern implements Pattern {
   private static final List<int[]> randomPatterns = new ArrayList<>();
   
   public RandomPattern() {
      generateRandomPatterns();
   }
   
   private void generateRandomPatterns() {
      Random random = new Random();
      int patternSize = random.nextInt(15) + 6; // Random size between 6 and 20
      Set<Integer> availableIndices = IntStream.range(0, 25).boxed().collect(Collectors.toSet());
      
      // Randomly pick indices for a single pattern
      Set<Integer> randomIndices = new HashSet<>();
      while (randomIndices.size() < patternSize) {
         int randomIndex = random.nextInt(availableIndices.size());
         int selected = availableIndices.stream().skip(randomIndex).findFirst().orElse(-1);
         randomIndices.add(selected);
         availableIndices.remove(selected);
      }
      
      randomPatterns.add(randomIndices.stream().mapToInt(Integer::intValue).toArray());
   }
   
   @Override
   public boolean matches(Set<Integer> markedIndices) {
      for (int[] pattern : randomPatterns) {
         if (markedIndices.containsAll(Arrays.stream(pattern).boxed().toList())) {
            return true;
         }
      }
      return false;
   }
   
   public static void displayPattern() {
      System.out.println("Random Pattern:");
      
      // Extract the indices for the first random pattern to display
      Set<Integer> patternIndices = Arrays.stream(randomPatterns.get(0)).boxed().collect(Collectors.toSet());
      
      for (int row = 0; row < 5; row++) {
         for (int col = 0; col < 5; col++) {
            int index = row * 5 + col; // Calculate the 1D index
            
            if (row == 2 && col == 2) {
               // Highlight the center cell in red
               System.out.print("\u001B[31m F\u001B[0m ");
            } else if (patternIndices.contains(index)) {
               // Highlight indices part of the random pattern in green
               System.out.printf("\u001B[32m%2d\u001B[0m ", 1);
            } else {
               // Display normal numbers for non-pattern cells
               System.out.printf("%2d ", 0);
            }
         }
         System.out.println();
      }
   }
}

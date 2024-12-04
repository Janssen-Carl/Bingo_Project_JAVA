package patterns;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LinePattern implements Pattern {
   private static final List<int[]> LINES = Arrays.asList(
           // Horizontal lines
           new int[]{0, 1, 2, 3, 4},
           new int[]{5, 6, 7, 8, 9},
           new int[]{10, 11, 12, 13, 14},
           new int[]{15, 16, 17, 18, 19},
           new int[]{20, 21, 22, 23, 24},
           // Vertical lines
           new int[]{0, 5, 10, 15, 20},
           new int[]{1, 6, 11, 16, 21},
           new int[]{2, 7, 12, 17, 22},
           new int[]{3, 8, 13, 18, 23},
           new int[]{4, 9, 14, 19, 24},
           // Diagonals
           new int[]{0, 6, 12, 18, 24},
           new int[]{4, 8, 12, 16, 20}
   );
   
   @Override
   public boolean matches(Set<Integer> markedIndices) {
      for (int[] line : LINES) {
         if (markedIndices.containsAll(Arrays.stream(line).boxed().toList())) {
            return true;
         }
      }
      return false;
   }
}

package patterns;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FourCornersPattern implements Pattern {
   private static final List<int[]> CORNERS = Collections.singletonList(
           new int[]{0, 4, 20, 24}
   );
   
   @Override
   public boolean matches(Set<Integer> markedIndices) {
      for (int[] corner : CORNERS) {
         if (markedIndices.containsAll(Arrays.stream(corner).boxed().toList())) {
            return true;
         }
      }
      return false;
   }
   
}

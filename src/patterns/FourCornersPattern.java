package patterns;

import java.util.Set;

public class FourCornersPattern implements Pattern {
   private static final Set<Integer> FOUR_CORNERS = Set.of(0, 4, 20, 24);
   
   @Override
   public boolean matches(Set<Integer> markedIndices) {
      return markedIndices.containsAll(FOUR_CORNERS);
   }
}

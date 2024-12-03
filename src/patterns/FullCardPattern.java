package patterns;

import java.util.Set;
import java.util.stream.IntStream;

public class FullCardPattern implements Pattern {
   private static final Set<Integer> FULL_CARD = IntStream.range(0, 25).boxed().collect(java.util.stream.Collectors.toSet());
   
   @Override
   public boolean matches(Set<Integer> markedIndices) {
      return markedIndices.containsAll(FULL_CARD);
   }
}

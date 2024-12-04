package patterns;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class FullCardPattern implements Pattern {
   private static final List<int[]> FULL_CARD = List.of(
           IntStream.range(0, 25).toArray()
   );
   
   @Override
   public boolean matches(Set<Integer> markedIndices) {
      for (int[] fullCard : FULL_CARD) {
         if (markedIndices.containsAll(Arrays.stream(fullCard).boxed().toList())) {
            return true;
         }
      }
      return false;
   }
   
}
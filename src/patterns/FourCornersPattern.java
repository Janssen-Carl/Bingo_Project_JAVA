package patterns;

import models.BingoCard;

public class FourCornersPattern implements Pattern {
   
   @Override
   public boolean matches(BingoCard card) {
      boolean[][] marked = card.getMarked();
      int size = marked.length;
      
      return marked[0][0] && marked[0][size - 1] && marked[size - 1][0] && marked[size - 1][size - 1];
   }
}

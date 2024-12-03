package patterns;

import models.BingoCard;

public class FullCardPattern implements Pattern {
   
   @Override
   public boolean matches(BingoCard card) {
      boolean[][] marked = card.getMarked();
      for (boolean[] row : marked) {
         for (boolean cell : row) {
            if (!cell) return false;
         }
      }
      return true;
   }
}

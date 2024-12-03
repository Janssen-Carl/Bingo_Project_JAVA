package patterns;

import models.BingoCard;

public class LinePattern implements Pattern {
   
   @Override
   public boolean matches(BingoCard card) {
      boolean[][] marked = card.getMarked();
      int size = marked.length;
      
      // Check horizontal lines
      for (int row = 0; row < size; row++) {
         boolean allMarked = true;
         for (int col = 0; col < size; col++) {
            if (!marked[row][col]) {
               allMarked = false;
               break;
            }
         }
         if (allMarked) return true;
      }
      
      // Check vertical lines
      for (int col = 0; col < size; col++) {
         boolean allMarked = true;
         for (int row = 0; row < size; row++) {
            if (!marked[row][col]) {
               allMarked = false;
               break;
            }
         }
         if (allMarked) return true;
      }
      
      // Check diagonals
      boolean diagonal1 = true;
      boolean diagonal2 = true;
      for (int i = 0; i < size; i++) {
         if (!marked[i][i]) diagonal1 = false;
         if (!marked[i][size - i - 1]) diagonal2 = false;
      }
      return diagonal1 || diagonal2;
   }
   

   
}

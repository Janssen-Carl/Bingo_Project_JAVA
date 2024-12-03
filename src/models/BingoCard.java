package models;

import patterns.Pattern;

public class BingoCard {
   private int[][] grid;
   private boolean[][] marked;
   
   public BingoCard() {
      // Generate a Bingo card
   }
   
   public void markNumber(int number) {
      // Mark number on the card
   }
   
   public boolean checkPattern(Pattern pattern) {
      return pattern.matches(this);
   }
}
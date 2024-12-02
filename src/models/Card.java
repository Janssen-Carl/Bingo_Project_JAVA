package models;

import java.util.ArrayList;
import java.util.List;

public class Card {
   private final int numCards;
   private List<int[][]> cards;
   
   public Card() {
      this(1);
   }
   
   public Card(int numCards) {
      this.numCards = numCards;
      this.cards = new ArrayList<>();
      for (int i = 0; i < numCards; i++) {
         int[][] card = new int[5][5];
         generateCard(card);
         this.cards.add(card);
      }
   }
   
   public List<int[][]> getCards() {
      return this.cards;
   }
   
   public void setCards(List<int[][]> cards) {
      this.cards = cards;
   }
   
   public void printCards() {
      for (int[][] card : this.cards) {
         for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
               System.out.print(card[i][j] + " ");
            }
            System.out.println();
         }
         System.out.println();
      }
   }
   
   public void generateCard(int[][] card) {
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            card[i][j] = (int) (Math.random() * 75);
         }
      }
   }
   
   public boolean checkCard(int[][] card) {
      // Check rows
      for (int i = 0; i < 5; i++) {
         if (card[i][0] == 0 && card[i][1] == 0 && card[i][2] == 0 && card[i][3] == 0 && card[i][4] == 0) {
            return true;
         }
      }
      // Check columns
      for (int i = 0; i < 5; i++) {
         if (card[0][i] == 0 && card[1][i] == 0 && card[2][i] == 0 && card[3][i] == 0 && card[4][i] == 0) {
            return true;
         }
      }
      // Check diagonals
      if (card[0][0] == 0 && card[1][1] == 0 && card[2][2] == 0 && card[3][3] == 0 && card[4][4] == 0) {
         return true;
      }
      if (card[0][4] == 0 && card[1][3] == 0 && card[2][2] == 0 && card[3][1] == 0 && card[4][0] == 0) {
         return true;
      }
      return false;
   }
   
   public void markNumber(int number) {
      for (int[][] card : this.cards) {
         for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
               if (card[i][j] == number) {
                  card[i][j] = 0;
               }
            }
         }
      }
   }
   
   public boolean checkNumber(int number) {
      for (int[][] card : this.cards) {
         for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
               if (card[i][j] == number) {
                  return true;
               }
            }
         }
      }
      return false;
   }
}
package models;

public class Computer {
   private String name = "Computer";
   private final BingoCard[] cards;
   
   public Computer(int numCards) {
      this.name = name;
      this.cards = new BingoCard[numCards];
//      for (int i = 0; i < numCards; i++) {
//         cards[i] = new BingoCard();
//      }
   }
   
   public String getName() {
      return name;
   }
   
   public BingoCard[] getCards() {
      return cards;
   }
}
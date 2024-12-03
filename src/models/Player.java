package models;

public class Player {
      private String name;
      private final BingoCard[] cards;
      
      public Player(){
            this.name = "Player";
            this.cards = new BingoCard[1];
      }
      
      public Player(String name, int numCards, NumberTracker tracker) {
            this.name = name;
            this.cards = new BingoCard[numCards];
            for (int i = 0; i < numCards; i++) {
                  this.cards[i] = new BingoCard(tracker); // Use the shared tracker
            }
      }
      
      public String getName() {
            return name;
      }
      
      public BingoCard[] getCards() {
            return cards;
      }
      
      public void setName(String name) {
            this.name = name;
      }
      
}
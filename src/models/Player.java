package models;

public class Player {
      private String name;
      private final BingoCard[] cards;
      
      public Player(){
            this.name = "Player";
            this.cards = new BingoCard[1];
            cards[0] = new BingoCard();
      }
      
      public Player(String name, int numCards) {
            this.name = name;
            this.cards = new BingoCard[numCards];
            for (int i = 0; i < numCards; i++) {
                  cards[i] = new BingoCard();
            }
      }
      
      public String getName() {
            return name;
      }
      
      public BingoCard[] getCards() {
            return cards;
      }
      
      public String setName(String name) {
            this.name = name;
      }
      
}
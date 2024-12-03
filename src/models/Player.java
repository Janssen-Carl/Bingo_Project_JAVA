package models;

public class Player {
      private String name;
      private BingoCard card;
      
      public Player() {
      }
      
      public Player(String name) {
            this.name = name;
      }
      
      public String getName() {
            return name;
      }
      
      public void setName(String name) {
            this.name = name;
      }
      
      public BingoCard getCard() {
            return card;
      }
      
      public void generateCard(NumberTracker tracker) {
            this.card = new BingoCard(tracker); // Generate a single Bingo card
      }
      
      public void displayCard() {
            card.displayCard();
      }
}

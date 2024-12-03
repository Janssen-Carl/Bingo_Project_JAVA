package models;

import java.util.ArrayList;
import java.util.List;


public class Player {
      private String name;
      private final List<BingoCard> cards;
      
      public Player(){
            this.name = "Player";
            this.cards = new ArrayList<>();
      }
      
      public Player(String name, int numCards, NumberTracker tracker) {
            this.name = name;
            this.cards = new ArrayList<>();
            for (int i = 0; i < numCards; i++) {
                  this.cards.add(new BingoCard(tracker)); // Generate unique cards
            }
      }
      
      public String getName() {
            return name;
      }
      
      public void setName(String name) {
            this.name = name;
      }
      
      public List<BingoCard> getCards() {
            return cards;
      }
      
      public void generateCards(int numCards, NumberTracker tracker) {
            cards.clear(); // Clear existing cards
            for (int i = 0; i < numCards; i++) {
                  cards.add(new BingoCard(tracker)); // Generate cards
            }
      }
      
      public void displayCards() {
            System.out.println(name + "'s Bingo Cards:");
            for (int i = 0; i < cards.size(); i++) {
                  System.out.println("Card " + (i + 1) + ":");
                  cards.get(i).displayCard();
                  System.out.println(); // Space between cards
            }
      }
      
}
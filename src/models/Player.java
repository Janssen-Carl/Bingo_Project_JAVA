package models;

import java.util.HashSet;
import java.util.Set;

public class Player {
      private String name;
      private BingoCard card;
      
      private final Set<Integer> markedIndices = new HashSet<>(); // Store marked indices

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
            return card;  // Return the BingoCard object itself
      }

      
      
      public void generateCard(NumberTracker tracker) {
            this.card = new BingoCard(tracker); // Generate a single Bingo card
      }
      
      public void displayCard() {
            card.displayCard();
      }
      
      public void markNumber(int number) {
            int index = card.markNumberAndReturnIndex(number); // Mark the number and get its index
            if (index >= 0) {
                  markedIndices.add(index); // Add the index to the marked indices set
            }
      }
      
      public Set<Integer> getMarkedIndices() {
            return markedIndices;
      }

}

package models;

import java.util.HashSet;
import java.util.Set;

public class Computer {
   private final String name;
   private BingoCard card;
   private final Set<Integer> markedIndices = new HashSet<>();
   
   public Computer() {
      this.name = "Computer";
   }
   
   public String getName() {
      return name;
   }
   
   
   public void generateCard(NumberTracker tracker) {
      this.card = new BingoCard(tracker);
   }
   
   public void displayCard() {
      card.displayCard();
   }
   
   public void markNumber(int number) {
      int index = card.markNumberAndReturnIndex(number);
      if (index >= 0) {
         markedIndices.add(index);
      }
   }
   
   public Set<Integer> getMarkedIndices() {
      return markedIndices;
   }
}

package models;


import java.util.List;

public class Player{
      String name;
      int score;
      private Card card;
      
      public Player(String name, Card card) {
            this.name = name;
            this.score = 0;
            this.card = card;
      }
      
      public Player(){
            this.name = "Player";
            this.score = 0;
      }
      
      public Player(String name){
            this.name = name;
            this.score = 0;
      }
      
      public String getName(){
            return this.name;
      }
      
      public int getScore(){
            return this.score;
      }
      
      public void setScore(int score){
            this.score = score;
      }
      
      public void setName(String name){
            this.name = name;
      }
      
      public Card getCard(){
            return this.card;
      }
      
      public void setCard(Card card){
            this.card = card;
      }
      
      public void setCards(List<int[][]> cards) {
            this.card.setCards(cards);
      }
}

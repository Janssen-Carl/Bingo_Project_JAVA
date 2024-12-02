package models;

public class Player{
      String name;
      int score;
      
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
      
      
}

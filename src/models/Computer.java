package models;

public class Computer {
   String name = "Computer";
   int score;
   
   public Computer(){
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
      
}

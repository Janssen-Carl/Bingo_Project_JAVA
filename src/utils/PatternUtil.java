package utils;

public class PatternUtil {
   
   public PatternUtil(int choice) {
      switch (choice) {
         case 1:
            loadDefaultPattern();
            break;
         case 2:
            randomPattern();
            break;
         case 3:
            customPattern();
            break;
      }
   }
   
   private static void loadDefaultPattern() {
      System.out.println("Loading default pattern...");
   }
   
   private static void randomPattern() {
      System.out.println("Loading random pattern...");
   }
   
   private static void customPattern() {
      System.out.println("Loading custom pattern...");
   }
   
}

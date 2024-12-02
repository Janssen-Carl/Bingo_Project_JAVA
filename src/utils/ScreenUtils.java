package utils;

import java.io.IOException;
import java.util.Scanner;

public class ScreenUtils {
   
   //clear screen
   public static void clearScreen() {
      try {
         if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
         } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
         }
      } catch (IOException | InterruptedException ex) {
         System.err.println("Error clearing the screen: " + ex.getMessage());
      }
      
      newLine();
   }
   
   //waits and Enter key press
   public static void waitForEnter() {
      System.out.print("Press Enter to continue...");
      try {
         System.in.read(); // Reads a single byte from the input stream
      } catch (IOException e) {
         System.err.println("Error waiting for Enter key: " + e.getMessage());
      }
   }
   
   //flushes input stream
   public static void flushInputStream(Scanner scanner) {
      if (scanner.hasNextLine()) {
         scanner.nextLine();
      }
   }
   
   public static void newLine() {
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
   }
}

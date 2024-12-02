package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
   }
   
   //waits and Enter key press
   public static void waitForEnter() {
      System.out.println("Press Enter to continue...");
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
         reader.readLine();
      } catch (IOException e) {
         System.err.println("Error reading input: " + e.getMessage());
      }
   }
   
   //flushes input stream
   public static void flushInputStream(Scanner scanner) {
      scanner.nextLine();
   }
   
}

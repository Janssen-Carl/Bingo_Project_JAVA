package utils;

import java.util.Scanner;

public class ScreenUtils {
   private static final Scanner scanner = new Scanner(System.in);
   
   public static void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }
   
   public static void waitForEnter() {
      System.out.print("Press Enter to continue...");
      scanner.nextLine();
   }
   
   public static void waitForEnter(String message) {
      System.out.print(message);
      scanner.nextLine();
   }
   
   public static int getIntInput() {
      while (!scanner.hasNextInt()) {
         System.out.println("Invalid input. Enter a number:");
         scanner.next();
      }
      int input = scanner.nextInt();
      scanner.nextLine();
      return input;
   }
   
   public static String getStringInput() {
      return scanner.nextLine().trim();
   }
   
   public static void displayWithDelay(String message) {
      
      int delayMillis = 80;
      
      for (char ch : message.toCharArray()) {
         System.out.print(ch);
         try {
            Thread.sleep(delayMillis);
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("\nError in delay: " + e.getMessage());
         }
      }
      System.out.println();
   }
   
   public static void newLine() {
      System.out.println("\n\n\n");
   }
   
   

   
}

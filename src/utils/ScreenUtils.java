package utils;

import java.util.Scanner;

public class ScreenUtils {
   private static final Scanner scanner = new Scanner(System.in);
   
   public static void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }
   
   public static void waitForEnter() {
      System.out.println("Press Enter to continue...");
      scanner.nextLine();
   }
   
   public static void waitForEnter(String message) {
      System.out.println(message);
      scanner.nextLine();
   }
   
   public static int getIntInput() {
      while (!scanner.hasNextInt()) {
         System.out.println("Invalid input. Enter a number:");
         scanner.next();
      }
      int input = scanner.nextInt();
      scanner.nextLine(); // Consume leftover newline
      return input;
   }
   
   public static String getStringInput() {
      return scanner.nextLine().trim();
   }
   
   
   
   
   
   public static void newLine() {
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
   }
}

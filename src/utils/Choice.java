package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Choice {
   
   public static int getValidChoice(Scanner scanner, int min, int max) {
      int choice;
      while (true) {
         try {
            choice = scanner.nextInt();
            if (choice >= min && choice <= max) {
               break;
            } else {
               System.out.println("Invalid choice. Try again.");
            }
         } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
         }
      }
      return choice;
   }
}

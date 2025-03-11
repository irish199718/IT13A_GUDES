package PALINDROME_ACT;

import java.util.Scanner; // Import Scanner class

public class IT13A_GUDES {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
           
          System.out.print("Enter a string: ");
        String original = scanner.nextLine();
       

        // Remove spaces and convert to lowercase
        String cleaned = original.replaceAll("\\s+", "").toLowerCase();

        // Reverse the string
        String reversed = new StringBuilder(cleaned).reverse().toString();

        // Check if palindrome
        if (cleaned.equals(reversed)) {
            System.out.println("The string is a palindrome!");
            System.out.println(original);
            System.out.println(cleaned);
              System.out.println(reversed);
        } else {
            System.out.println("The string is NOT a palindrome.");
            System.out.println(original);
            System.out.println(cleaned);
              System.out.println(reversed);
            
        }
    }
}

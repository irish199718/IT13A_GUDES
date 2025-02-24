


   package Gudes_Renojo_Bolinqiut;
import java.util.Scanner;

public class IT13A {
   
    public static void main(String[] args) {
      Scanner scan = new Scanner( System.in); 
      
       System.out.println("Input the first number:");
     int n1 = scan.nextInt();
     
     System.out.println("Input the second number:");
      int n2 = scan.nextInt();
     
     System.out.println("Input the third number:");
      int n3 = scan.nextInt();
      
      int greatest = n1;
      
      if (n2 > greatest) { 
          greatest = n2;
      }  
      if (n3 > greatest) {
          greatest = n3;
      }
   System.out.println("The greatest number is: " + greatest);
    
    }
}

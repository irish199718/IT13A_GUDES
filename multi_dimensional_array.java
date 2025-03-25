
package MIDTERM;


public class multi_dimensional_array {
      public static void main(String[] args){
          
          int[][] num= {
               {1,2,3,4},
               {5,6,7,8},
               {9,10,11,12},
              
          };
          for (int i = 0; i< num.length; i++){
             System.out.print("The Elements in row" + (i + 1)+": ");
             for(int q = 0; q < num[i].length; q++){
                 System.out.print(num[i][q] + " " );
                 
             }
             System.out.println();
           
          }
          }
      }
       


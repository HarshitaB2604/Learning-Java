/* 
* Lesson 3 Coding Activity Question 1 
* Prints the first and last letters of a String
* using the .lenght() and .substring() methods
*/

import java.util.Scanner;

public class U2_L3_Activity_One
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    //getting a string
    System.out.println("Enter a string:");
    String str = input.nextLine();
    
    //printing out the first and last letters of the String
    String fLetter = str.substring(0,1);
    String lLetter = str.substring(str.length() - 1);
    System.out.println(fLetter + lLetter);
    
  
  }
}

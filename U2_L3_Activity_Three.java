/* 
* Lesson 3 Coding Activity Question 3
* Take two Strings from the user
* Converts them to lower case
* Compare the two Strings using .compareTo()
* and printing the result
*/

import java.util.Scanner;

public class U2_L3_Activity_Three
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter first word:");
    String str1 = input.nextLine();
    str1 = str1.toLowerCase();
    
    System.out.println("Enter second word:");
    String str2 = input.nextLine();
    str2 = str2.toLowerCase();
    
    System.out.println("Result: " + str1.compareTo(str2));
  
  }
}

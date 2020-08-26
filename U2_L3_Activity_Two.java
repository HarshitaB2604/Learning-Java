/* 
* Lesson 3 Coding Activity Question 2 
* All the letters in a String except the
* first and the last
*/

import java.util.Scanner;

public class U2_L3_Activity_Two
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    //getting a string
    System.out.println("Enter a string:");
    String str = input.nextLine();
    
    //printing all letter except the first and last
    System.out.println(str.substring(1, (str.length() - 1)));
    
  
  }
}

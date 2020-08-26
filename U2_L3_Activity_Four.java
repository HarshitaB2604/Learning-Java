/* 
* Lesson 3 Coding Activity Question 4
* Takes a sentence as input from the user
* Prints the lenghts of the first word in that sentence
*/

import java.util.Scanner;

public class U2_L3_Activity_Four
{
  public static void main(String[] args)
  {
    //set up scanner
    Scanner input = new Scanner(System.in);
    
    //input the sentence
    System.out.println("Enter a sentence:");
    String sentence = input.nextLine();
    
    //find where the first word ends and retreving it
    int fEndIndex = sentence.indexOf(" ");
    String fWord = sentence.substring(0, fEndIndex);
    
    //printing the lenght of the first word
    System.out.println(fWord.length());
  
  }
}

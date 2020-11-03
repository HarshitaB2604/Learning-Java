/*
* this file can take a string
* convert it to lower case
* then remove all the vowels from the string and print it
  * actually works by printing any leters that aren't vowels
*/

public class vowel_remover
{
  public static main void(String[] args)
  {
    Scanner input = new Scanner(System.in);
    
    //enter string
    System.out.println("Enter String:");
    String str = input.nextLine().toLowerCase();
    
    //print string without vowels
    for(int i = 0; i < str.length(); i++)
    {
      if(!str.substring(i, i + 1).equals("a") && !str.substring(i, i + 1).equals("e") && !str.substring(i, i + 1).equals("i") && !str.substring(i, i + 1).equals("o") && !str.substring(i, i + 1).equals("u"))
      {
         System.out.print(str.substring(i, i + 1));
      }
    }
  }
}

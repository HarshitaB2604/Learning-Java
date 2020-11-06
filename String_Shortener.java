import java.util.Scanner;

class String_Shortener 
{
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Type the message to be shortened");
    String msg = input.nextLine().toLowerCase();
    
    /*
    **********************ALGORITHM 1****************************
    * This algorithm will remove all vowels from the message unless it is the first letter
    * will remove all repeated letters
    * print out how many vowels were removed
    * print out how many repeated letters were removed
    * print out the new message
    * print out how many characters shorter this message is
    */
    System.out.println("\nAlgorithm 1");
    
    String algo1msg = "";
    int vowelC = 0;
    int repeatC = 0;

    //for removing repeats
    for(int j = 0; j < msg.length(); j++)
    {
      if((j != (msg.length() - 1) && 
        !(msg.substring(j, j + 1).equals(msg.substring(j + 1, j + 2)))) || (j != (msg.length() - 1) && ((msg.substring(j, j + 2).equals("aa") ||
        msg.substring(j, j + 2).equals("ee") || 
        msg.substring(j, j + 2).equals("ii") || 
        msg.substring(j, j + 2).equals("oo") || 
        msg.substring(j, j + 2).equals("uu")))))
      {
        algo1msg += msg.substring(j, j + 1);       
      }
    }
    //check if the last two letters are equal and if they aren't add the last letter
    if(!msg.substring(algo1msg.length() - 2).equals(algo1msg.length() - 1))
    {
      algo1msg += msg.substring(msg.length() - 1);
    }  

    repeatC = msg.length() - algo1msg.length();

    /*****************PART 2 Algorithm 1*****************/
    String temp = algo1msg;
    algo1msg = "";

    //for removing vowels
    for(int i = 0; i < temp.length(); i++)
    {
      if(i == 0 || temp.substring(i - 1, i).equals(" ") ||
        !(temp.substring(i, i + 1).equals("a") ||
        temp.substring(i, i + 1).equals("e") || 
        temp.substring(i, i + 1).equals("i") || 
        temp.substring(i, i + 1).equals("o") || 
        temp.substring(i, i + 1).equals("u")))
      {
        algo1msg += temp.substring(i, i + 1);
      }  
    }
    vowelC = temp.length() - algo1msg.length();


    System.out.println("Vowels removed: " + vowelC);
    System.out.println("Repeats removed: " + repeatC);
    System.out.println("Algorithm 1 message: " + algo1msg);
    System.out.println("Algorithm 1 characters saved: " + (msg.length() - algo1msg.length()) + "\n");
    
    /***********************ALGORITHM 2*****************************/
    System.out.println("Algorithm 2");

    String algo2msg = "";
    int unique = 0;
    int count = 1;
    boolean added = false;
    
    for(int word = 0; word < msg.length(); word++)
    {
      //System.out.println("done");
      //only count how many of that letter is in the word if it hasn't been done already
      if(algo2msg.indexOf(msg.substring(word, word + 1)) == -1 && !msg.substring(word, word + 1).equals(" "))
      {
        for(int letter = word + 1; letter < msg.length(); letter++)
        {
          if(msg.substring(word, word + 1).equals(msg.substring(letter, letter + 1)))
          {
            count++;
          }
          
        }
        unique++;
        //add that letter to algorithm 2's message
        algo2msg += count + msg.substring(word, word + 1);
      }

      //reset the counter for the number of letters
      count = 1;
    }

    System.out.println("Unique characters found: " + unique);
    System.out.println("Algorithm 2 message: " + algo2msg);
    System.out.println("Algorithm 2 characters saved: " + (msg.length() - algo2msg.length()));
  }
} 

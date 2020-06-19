/*
* Asks the user for a qoute and it's author
* Then prints it out formatted
*/
import java.util.Scanner;

public class QuoteMachine
{
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        // Ask for a quote
        System.out.println("Enter a quote: ");
        String qoute = input.nextLine();
        
        
        // Ask for the author
        System.out.println("Enter the author of the quote: ");
        String author = input.nextLine();
        
        
        // Create a new String that has the quote in quotation marks
        String fQoute = "\"" + qoute + "\""; //fQoute = formated qoute
        
        
        // Print the quote, then the author on the next line 
        System.out.println(fQoute + "\n" + author);
        
    }
}

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }
  
  /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
  /**
   * Returns the word after removing all punctuation
   */
  public static String removePunctuationAll(String word)
  {
    String temp = "";
    for(int i = 0; i < word.length(); i++)
    {
      //if the character is a alphabeth or space add it to temp
      if(Character.isAlphabetic(word.charAt(i)) || word.substring(i, i + 1).equals(" "))
      {
        temp += word.substring(i, i + 1);
      }
    }
    
    return temp;
  }
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }
  
  //sentiment value of a review based on an input review
  /**
   * 1-5-21: Having an index out of range error of -4 at line 196 - fixed 1-5-21
   * method now works as intended
   */
  /** ALGORITHM
   * Take a text file and convert its contents to a String(text)
   * Remove all the punctuation from text
   * Create an int variable, index, and set it to 0
   * Create an int variable, nextSpace, set it to the next space in text
   * If nextSpace is positive (checks if there is more than one word 
     in the review)
   * Calculate the sentimentVal for the word and add it to the total
     * Take substring from index to nextSpace and run sentimentVal 
       method on it
   * set index to nextSpace + 1
   * calclate nextSpace and repeat while nextSpace is positive
   * calculate the sentiment value of the last word and add it to total sentiment value
   * return totalSentiVal
   * 
  */
  public static double totalSentiment(String fileName)
  {
    //convert the file to text and remove the punctuation
    String text = textToString(fileName);
    text = removePunctuationAll(text); //works
    
    double totalSentiVal = 0;
    int index = 0;
    int nextSpace = text.indexOf(" ");
    int count = 0; //counts number of spaces
    
    while(nextSpace > 0)
    {
      //Calculate the sentimentVal for the word and add it to the total
      totalSentiVal += sentimentVal(text.substring(index, nextSpace));
      
      //increment the index to the starting of the next word
      index = nextSpace + 1;
      //finding the next space after the next word
      nextSpace = text.indexOf(" ", index); 
    }
    
    //calculating sentiment val for the last word
    totalSentiVal += sentimentVal(text.substring(index));
    
    return totalSentiVal;
  }
  
  //Write your starRating method here. This method should return an int rating from 0-4 based on the total
  //sentiment value of a review.
  
  /**
   * So the explanation of this method didn't really make sense to me 
   * so I just made the startRating method rate things from 1 to 4 stars
   * file with a totalSentiment val of <= 5.0 gets 1 star
   * file with a totalSentiment val of > 5.0 and <= 10 gets 2 stars
   * file with a totalSentiment val of > 10.0 and <= 15 gets 3 stars
   * file with a totalSentiment val of > 15 gets 4 stars
  */
  public static int starRating(String fileName)
  {
    double totalSentiVal = totalSentiment(fileName);
    
    //the star rating
    int star = 1; //automatic star rating is set to 1
    
    //file with a totalSentiment val of > 5.0 and <= 10 gets 2 stars
    if(totalSentiVal > 5 && totalSentiVal <= 10)
    {
      star = 2;
    }
    //file with a totalSentiment val of > 10.0 and <= 15 gets 3 stars
    else if(totalSentiVal > 10 && totalSentiVal <= 15)
    {
      star = 3;
    }
    //file with a totalSentiment val of > 15 gets 4 stars
    else if(totalSentiVal > 15)
    {
      star = 4;
    }
    
    return star;
  }
}

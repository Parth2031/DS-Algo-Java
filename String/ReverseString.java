// ^ Reverse String Only Words Means - "the sky is blue" -> "blue is sky the".
// & Reverse String Word Means - "hello my" -> "ym olleh". 

import java.util.*;

public class ReverseString
{
  public static Scanner scn = new Scanner(System.in);

  public static String reverseStringOnlyWords(String str)
  {
    // ! Split String using Space -
    String[] words = str.split("\\s");

    String outputString = "";
    for(int i = words.length - 1; i >= 0; i--) 
      outputString += words[i] + " ";
    return outputString;
  }

  public static String reverseStringWord(String word)
  {
    String ans = "";
    for(int i = word.length() - 1; i >= 0; i--)
      ans += word.charAt(i);
    return ans;  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the String: ");
    String str = scn.nextLine();
    System.out.println("Reversed Only String Words: " + reverseStringOnlyWords(str));
    System.out.println("Reversed String Word as well as Characters: " + reverseStringWord(str));
  }
}
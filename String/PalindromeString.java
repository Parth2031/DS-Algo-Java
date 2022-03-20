// ^ In this, There are 2 Questions -->
// & Check isPalindrome and Print & Count All Palindromic Substrings.
// ~ Palindrome means "aba" where starting and ending values are same.
// * Print All Palindromic Substrings of "abcc" is [a, b, c, cc].

import java.util.*;

public class PalindromeString
{
  public static Scanner scn = new Scanner(System.in);
  
  public static boolean isPalindrome(String str)
  {
    int start = 0;
    int end = str.length() - 1;

    while(start < end)
    {
      if(str.charAt(start) != str.charAt(end))
        return false;
      
      start ++;
      end --;
    }
    
    return true;
  } 

  public static int checkAllPalindromicSubstrings(String str)
  {
    int count = 0;

    System.out.print("All the Palindromic Substrings are: ");
    for(int i = 0; i < str.length(); i++)
    {
      for(int j = i+1; j <= str.length(); j++)
      {
        String ss = str.substring(i, j);

        if(isPalindrome(ss) == true)
        {
          count++;
          System.out.print(ss + " ");
        }
      }
    }
 
    System.out.println();
    return count;
  }


  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    System.out.println("Whether the String is Palindrome or Not: " + isPalindrome(str));
    System.out.println("Number of Palindromic Substrings: " + checkAllPalindromicSubstrings(str));
  }
}
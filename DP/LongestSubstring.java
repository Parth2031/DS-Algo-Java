// ^ [Tabulation Approach] -
// ! In Longest Common Substring, we use Longest Common Suffix Approach but by Comparing Prefix of String 1 with All Prefix of String 2.
// * Example - Input => str1 = {pqabcxy} and str2 = {xyzabcp} 
// ? In, Longest Common Substring => Output = {abc}.

// & In Longest Palindromic Substring, We have a 2D Matrix where 'Gap' tells us that it is Palindromic Substring or not. 
// * Example - Input = {bebeeeed} & Output = {4}.

import java.util.*;

public class LongestSubstring
{
  public static Scanner scn = new Scanner(System.in);

  public static int longestCommonSubstring(String str1, String str2)
  {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    int max = 0;

    for(int i = 1; i < dp.length; i++)
    {
      for(int j = 1; j < dp[0].length; j++)
      {
        char c1 = str1.charAt(i - 1);
        char c2 = str2.charAt(j - 1);

        if(c1 != c2) 
          dp[i][j] = 0;
        else 
          dp[i][j] = dp[i - 1][j - 1] + 1;
        
        if (dp[i][j] > max) 
          max = dp[i][j];
      }
    }
    
    return max;
  }

  public static int longestPalindromicSubstring(String str)
  {
    boolean[][] dp = new boolean[str.length()][str.length()];
    int maxLength = 0;

    for(int gap = 0; gap < str.length(); gap++)
    {
      for(int i = 0, j = gap; j < str.length(); i++, j++)
      {
        if(gap == 0)
          dp[i][j] = true;
        else if(gap == 1)
        {
          if(str.charAt(i) == str.charAt(j))
            dp[i][j] = true;
          else
            dp[i][j] = false;  
        }  
        else
        {
          if(str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true)
            dp[i][j] = true;
          else
            dp[i][j] = false;  
        }
        
        if(dp[i][j])
          maxLength = gap + 1;
      }
    }

    return maxLength;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the 1st String: ");
    String str1 = scn.nextLine();
    System.out.print("Enter the 2nd String: ");
    String str2 = scn.nextLine();
    System.out.println("Length of the Longest Common Substring: " + longestCommonSubstring(str1, str2));
    System.out.println("Length of the Longest Palindromic Substring: " + longestPalindromicSubstring(str1));
  }
}
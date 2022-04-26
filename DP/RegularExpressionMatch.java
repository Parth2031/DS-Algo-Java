// ^ In this Question , We have to check whether pattern is matched with the given text.
// & '.' -> It Represents any Single Character which is matching to String
// ~ '_*' -> Here, '_' This can be any Character, With '*' Added, It Makes 0/Empty or Many '_' from 1 to Required by String. 
// ! 's*' = "", s, ss, ssss....
// * Example - Input => Str = {mississippi} and Patttern = {mis*i.*p*i} & Output = {true}.

import java.util.*;

public class RegularExpressionMatch
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isRegularExpessionMatching(String str, String pattern)
  {
    boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];

    dp[0][0] = true;

    for(int i = 0; i < dp.length; i++)
    {
      for(int j = 0; j < dp[0].length; j++)
      {
        if(i == 0 & j == 0)
          dp[i][j] = true;
        else if(i == 0)
          dp[i][j] = false;
        else if(j == 0)
        {
          char patternCharacter = pattern.charAt(i - 1);
          if(patternCharacter == '*')
            dp[i][j] = dp[i - 2][j];
          else
            dp[i][j] = false;
        }
        else
        {
          char patternCharacter = pattern.charAt(i - 1);
          char stringCharacter = str.charAt(j - 1);

          if(patternCharacter == '*')
          {
            dp[i][j] = dp[i - 2][j];

            char patternSecondLastCharacter = pattern.charAt(i - 2);
            if(patternSecondLastCharacter == '.' || patternSecondLastCharacter == stringCharacter)
              dp[i][j] = dp[i][j] || dp[i][j - 1];
          }
          else if(patternCharacter == '.')
            dp[i][j] = dp[i - 1][j - 1];
          else if(patternCharacter == stringCharacter)
            dp[i][j] = dp[i - 1][j - 1];
          else
            dp[i][j] = false;
        }
      }
    }
    
    return dp[pattern.length()][str.length()];
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the String: ");
    String str = scn.nextLine();
    System.out.print("Enter the Pattern: ");
    String pat = scn.nextLine();
    System.out.println("Is 1st String Regular Expression Matching 2nd String: " + isRegularExpessionMatching(str, pat));
  }
}
// ^ In this Question, we need to find the minimum number of operations[Add, Remove & Replace] needed to convert String1 to String2.
// * Example - Input => str1 = {pepperatcoding} and str2 = {pepcoding} & Output = {5}.
// & For Each Operation, +1 is added.

import java.util.*;

public class EditDistance
{
  public static Scanner scn = new Scanner(System.in);

  public static int editDistance(String str1, String str2)
  {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    
    for(int i = 0; i < dp.length; i++)
    {
      for(int j = 0; j < dp[0].length; j++)
      {
        if(i == 0)
          dp[i][j] = j;
        else if(j == 0)
          dp[i][j] = i;
        else
        {
          if(str1.charAt(i - 1) == str2.charAt(j - 1))
            dp[i][j] = dp[i - 1][j - 1];
          else
          {
            // * If, Characters do not match then we choose Min Value between [Top, Diagonal, Left] with +1 added to it.
            
            int replace = dp[i - 1][j - 1] + 1;                           // ~ Diagonal
            int delete = dp[i - 1][j] + 1;                                // ~ Left
            int insert = dp[i][j - 1] + 1;                                // ~ Top
            
            dp[i][j] = Math.min(replace, Math.min(insert, delete));
                      
                                // !  OR

            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
          }
        }
      }
    }
    
    return dp[str1.length()][str2.length()];
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the 1st String: ");
    String str1 = scn.nextLine();
    System.out.print("Enter the 2nd String: ");
    String str2 = scn.nextLine();
    System.out.println("Number of Operations Required to Convert String 1 to 2: " + editDistance(str1, str2));
  }
}
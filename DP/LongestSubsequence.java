// ^ [Tabulation Approach]
// ! Subsequence/Subset is the Generalization of Substring. Eg -> [abc] as [, c, b, bc, a, ac, ab, abc] where Size = 2^n.

// & In Longest Common Subsequence(LCS), abcd_ and acbd_ Comparison on a 2D Matrix.
// * Example - Input => str1 = {abcd} and str2 = {acbd} & Output = {3}.   [abd]
// ? In this, Diagonal gets +1 if Same Characters & Max of [Left Value of Diagonal, Top Value of Diagonal] if Different Characters.  

// & In Longest Repeating Subsequence, We use LCS but Exception here is that Character are not of Same Index in this.
// * Example - Input => str1 = {abacbc} and str2 = {abacbc} & Output = {3}
// ? So, here a1 != a1 but a1 == a3 in Comparison. So, Only in a1 == a3 We increment the diagonal by +1.

// ~ In Longest Increasing Subsequence, We Checl the Greatest Element till that SubArray Value and Store it's Length in 'dp' Array.
// * Example - Size = {10}, Input = {10 22 9 33 21 50 41 60 80 1} & Output = {6}.
// ? dp = [1 2 1 3 2 4 4 5 6 1]. In this, We keep Comparing the Previous Max dp Value and add +1 to it.

import java.util.*;

public class LongestSubsequence
{
  public static Scanner scn = new Scanner(System.in);

  public static int longestCommonSubsequence(String str1, String str2)
  {
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    
    for(int i = dp.length - 2; i >= 0; i--)
    {
      for(int j = dp[0].length - 2; j >= 0; j--)
      {
        char c1 = str1.charAt(i);
        char c2 = str2.charAt(j);
        
        if(c1 == c2)
          dp[i][j] = 1 + dp[i + 1][j + 1];
        else
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
      }
    }
    
    return dp[0][0];
  }

    public static int longestRepeatingSubsequence(String str)
  {
    int[][] dp = new int[str.length() + 1][str.length() + 1];

    for(int i = dp.length - 1; i >= 0; i--) 
    {
      for(int j = dp[0].length - 1; j >= 0; j--) 
      {
        if(i == dp.length - 1 && j == dp[0].length - 1)                         // ! Last Cell (_ == _)
          dp[i][j] = 0;
        else if(i == dp.length - 1)                                             // ! Last Row 
          dp[i][j] = 0;
        else if(j == dp[0].length - 1)                                          // ! Last Column 
          dp[i][j] = 0;
        else 
        {
          if(str.charAt(i) == str.charAt(j) && i != j)                          // ! Checking Idex are Not Equal [i != j]
            dp[i][j] = dp[i + 1][j + 1] + 1;
          else 
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
      }
    }
    
    return dp[0][0];
  }

  public static int longestIncreasingSubsequence(int[] arr)
  {
    int[] dp = new int[arr.length];
    int overalllMax = 0;

    for(int i = 0; i < dp.length; i++)
    {
      int max = 0;

      for(int j = 0; j < i; j++)
      {
        if(arr[i] > arr[j])
        {
          if(dp[j] > max)
            max = dp[j]; 
        }
      }
      
      dp[i] = max + 1;

      if(dp[i] > overalllMax)
        overalllMax = dp[i];
    }
    
    return overalllMax;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the 1st String: ");
    String str1 = scn.nextLine();
    System.out.print("Enter the 2nd String: ");
    String str2 = scn.nextLine();
    System.out.println("Length of the Longest Common Subsequence: " + longestCommonSubsequence(str1, str2));
    System.out.println("Length of the Longest Repeating Substring: " + longestRepeatingSubsequence(str1));

    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Values for Array: ");
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    System.out.println("Length of the Longest Increasing Substring: " + longestIncreasingSubsequence(arr));
    
  }
}
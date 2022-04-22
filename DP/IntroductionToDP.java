// ^ Introduction to Dynamic Programming :-

// * Dynamic Programming is a Optimization Technique which solves Sub-Problems.

// ! Types of Dynamic Programming - 
// ? Memorization [Top Down Approach] - It uses Recursion.
// ? Tabulation [Bottom Up Approach] - It uses Iterative Approach.

// ~ Memorization Approach is better than Tabulation Approach.
// & Dynamic Programming is used to stop the Repeatation of a Recursive Call by making a Memorization Array/Tabulation Array.

// Todo:: Memorization Array - int[] mem which learns all the Already Done Recursive Calls. So, Size = n + 1 for 'n' calls.
// 'mem' can also be Called as 'qb' -> Question Bank.

// Todo:: Tabulation Array - int[] dp = new int[n + 1].
// But here, we use loops to check Previous Calls.

import java.util.*;

public class IntroductionToDP
{
  public static Scanner scn = new Scanner(System.in);

  // * Example of Memorization Approach -

  public static int fibMemorized(int n, int[] mem)
  {
    if(n == 0 || n == 1)
      return n;

    if(mem[n] != 0)                                           // ! To Check for Repeatation of Calls.
      return mem[n];
      
    System.out.println("Recursive Calls: " + n);              

    int fibm1 = fibMemorized(n - 1, mem);
    int fibm2 = fibMemorized(n - 2, mem);
    int fib = fibm1 + fibm2;
    
    mem[n] = fib;                                            // ! To Store Already Done Recursive Calls.
    
    return fib; 
  }
  
  public static int countStairPathsMemorization(int n, int[] mem)
  {
    if(n == 0)
      return 1;
    else if (n < 0) 
      return 0;

    if(mem[n] > 0)
      return mem[n];
      
    int stairPath1 = countStairPathsMemorization(n - 1, mem);
    int stairPath2 = countStairPathsMemorization(n - 2, mem);
    int stairPath3 = countStairPathsMemorization(n - 3, mem);
    
    int stairPaths = stairPath1 + stairPath2 + stairPath3;

    mem[n] = stairPaths;

    return stairPaths;
  }
  // * Example of Tabulation Approach - 

  public static int fibTabulation(int n)
  {
    int[] dp = new int[n + 1];                                  // ! Tabulation Array

    dp[0] = 0;                                                  // ! We know Starting Value.
    dp[1] = 1;

    for(int i = 2; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 2];                  // ! We Choose Direction from Low to High and traverse in that Loop.

    return dp[n];  
  }

  public static int countStairPathsTabulation(int n)
  {
    int[] dp = new int[n + 1];                                  
   
    dp[0] = 1;                                                  

    for(int i = 1; i <=n ; i++)
    {
      if(i == 1)
        dp[i] = dp[i - 1];
      else if(i == 2)
        dp[i] = dp[i - 1] + dp[i - 2];  
      else
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];  
    }
    
    return dp[n];
  }

  public static void main(String[] args)
  {
    System.out.println();
    
    // * Memorization Example :
    System.out.print("Enter a Fibonacci Position: ");
    int n = scn.nextInt();
    System.out.println();
    int fibAns = fibMemorized(n, new int[n + 1]);           // ! Memorization Array Size - new int[n + 1]
    System.out.println("Fibonacci Value through Memorization: " + fibAns);

    // * Tabulation Example :

    System.out.println();
    System.out.print("Enter Number of Stairs: ");
    int m = scn.nextInt();
    int stairAns = countStairPathsTabulation(m); 
    System.out.println("Number of Stair Paths through Tabulation: " + stairAns);
  }
}


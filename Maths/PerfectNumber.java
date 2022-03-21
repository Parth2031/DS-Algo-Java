// ^ Perfect Number :- Original Number = Sum of its Divisor.
// * Example - Input = {6} and Output = {1 + 2 + 3 = (6)} [Smallest Perfect Number] 
// & Similarly, "28" = 1 + 2 + 4 + 7 + 14.

import java.util.*;

public class PerfectNumber
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isPerfectNumber(int n)
  {
    int sum = 0;
    int originalNumber = n;

    for(int i = 1; i < n; i++) 
    {
      if(n % i == 0)
        sum += i;
    }
    
    if(sum == originalNumber)
      return true;
    else 
      return false;  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    System.out.println("Check whether the Given Number is Perfect Number or Not: " + isPerfectNumber(n));
  }
}
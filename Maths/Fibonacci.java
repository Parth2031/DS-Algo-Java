// ^ In this, There are 2 Questions - Is Fibonacci Number & Nth Posotion Fibonacci Number.

import java.util.*;
import java.math.*;

public class Fibonacci
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isFib(int n)
  {
    if(n == 0 || n == 1)
      return true;
    
    int a = 0;
    int b = 1;
    int sum = 0;
    
    while(sum <= n)
    {
      sum = a + b;

      if(sum == n)
        return true;
      
      a = b;
      b = sum;
    }
    
    return false;
  }

  public static BigInteger NthFibonacciNumber(int n)
  {
    BigInteger a = BigInteger.valueOf(0);
    BigInteger b = BigInteger.valueOf(1);
    BigInteger sum = BigInteger.valueOf(1);  

    for(int i = 2; i <= n; i++) 
    {
      sum = a.add(b);
      a = b;
      b = sum;
    }

    return b;  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    System.out.println("Check Whether the Given Number is Fibonacci or Not: " + isFib(n));
    System.out.println("Nth Place Fibonacci Number: " + NthFibonacciNumber(n));
  }
}
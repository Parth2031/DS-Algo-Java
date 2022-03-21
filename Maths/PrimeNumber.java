// ^ In this, There are 3 Questions :- isPrime, PrimetillN and Checking Multiple "N" Prime Numbers.

import java.util.*;

public class PrimeNumber
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isPrime(int n)
  {
    int count = 0;

    if(n == 0 || n == 1)
      return false;

    for(int i = 2; i <= n; i++)
    {
      if(n % i == 0)
        count++;
    }
    
    if(count < 2)
      return true;
      
    return false;
  }

  public static void printPrimeTillN(int N)
  {
    if(N == 0 || N == 1)
      return;
      
    for(int i = 2; i <= N; i++)
    {
      if(isPrime(i) == true)
        System.out.print(i + " ");
    }  
  }

  public static void checkMultiplePrimeNumbers(int N)
  {
    for(int i = 0; i < N; i++)
    {
      int n = scn.nextInt();
      
      if(isPrime(n) == true)
        System.out.print("Prime");
      else
        System.out.print("Not Prime");  
    }
  }  

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    System.out.println("Check Whether the Given Number is Prime or Not: " + isPrime(n));
    System.out.print("Print All Prime Numbers till 'N': ");
    printPrimeTillN(n);
    System.out.println();
    System.out.println("Check 'N' Multiple Prime Numbers: ");
    checkMultiplePrimeNumbers(n);
    System.out.println();
  }
}
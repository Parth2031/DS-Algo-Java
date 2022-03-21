// ^ There are 2 Problems here - Frequency of Digit & Total Occurences of a Number.
// ? Total Occurences of a Number - In this, We check the occurences of the key starting from 1 to number(n) 
// * Example - Number has "21" with key = 2 has "2" four times ranging from 1 - 20. 

import java.util.*;

public class TotalOccuranceOfANumber
{
  public static Scanner scn = new Scanner(System.in);

  public static int frequencyOfGivenDigit(int n, int key)
  {
    int count = 0;

    while(n != 0)
    {
      int rem = n % 10;
      if(rem == key)
        count++;
      n = n / 10;  
    }
    
    return count;
  }
   
  public static int totalOccuranceOfNumberFrom1ToN(int n, int key)
  {
    int count = 0;
    int i = key;

    while (i <= n) 
    {
      if(i % 10 == key)
        count++;
      if(i != 0 && i / 10 == key) 
      {
        count++;
        i++;
      } 
      else if(i / 10 == key - 1)
        i = i + (10 - key);
      else
        i = i + 10;
    }
    
    return count;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    System.out.print("Enter a Number to find it's Occurance: ");
    int key = scn.nextInt();
    System.out.println("Frequency of Given Digit: " + frequencyOfGivenDigit(n, key));
    System.out.println("Total Occurance of the Number Satrting from 1 to N: " + totalOccuranceOfNumberFrom1ToN(n, key));
  }
}
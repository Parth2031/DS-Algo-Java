// ^ Permutation - It means for String length 'n', we have n! permutations.
// * Example - Input = "abc" -> Output = "abc, acb, bac, cba, bca, cab".

import java.util.*;

public class Permutations
{
  public static Scanner scn = new Scanner(System.in);

  public static void printPermutationOfString(String str, String ans)
  {
    if(str.length() == 0)
    {
      System.out.print(ans + " ");
      return;
    }

    for(int i = 0; i < str.length(); i++)
    {
      char ch = str.charAt(i);
      
      String leftOfString = str.substring(0, i);
      String rightOfString = str.substring(i + 1);
      
      String restOfString = leftOfString + rightOfString;

      printPermutationOfString(restOfString, ans + ch);
    }
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the String: ");
    String str = scn.next();
    System.out.print("Permutation of String: ");
    printPermutationOfString(str, "");
    System.out.println();
  }
}
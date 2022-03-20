// ! In this Question, We need to use TypeCasting -> (int)(ch) / (char)(index).
// ^ Replace Even Index with its higher ASCII value code character and vice versa for Odd Index with its lower ASCII value character.
// ? Example: {a,b,c,d} as {b,a,d,c} as per the Index Position and Another Example: {. , / ' ;} as {/ + 0 & <}.

import java.util.*;

public class ReplaceWithASCIIAccordingToOddEven
{
  public static Scanner scn = new Scanner(System.in);

  public static char[] replaceCharactersAccordingToASCII(char[] ch_Arr)
  {
    int n = ch_Arr.length;
    char[] ans = new char[n];

    for(int i = 0; i < n; i++)
    {
      if(i % 2 == 0)
      {
        int idx_Even = (int)(ch_Arr[i]) + 1;
        ans[i] = (char)(idx_Even);
      } 
      else
      {
        int idx_Odd = (int)(ch_Arr[i]) - 1;
        ans[i] = (char)(idx_Odd);
      } 
    }
    
    return ans;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    char[] ch = str.toCharArray();
    char[] ans = replaceCharactersAccordingToASCII(ch);
    String res = new String(ans);
    System.out.println("Replacing Characters With Higher/Lower ASCII Values: " + res); 
  }
}
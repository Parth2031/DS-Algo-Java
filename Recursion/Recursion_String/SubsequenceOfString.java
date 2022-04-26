// ^ Subsequence/Subset of String means [abc] as [, c, b, bc, a, ac, ab, abc].
// * Subsequence/Subset of String = 2^n where, n => String Length.

import java.util.*;

public class SubsequenceOfString
{
  public static Scanner scn = new Scanner(System.in);

  public static ArrayList<String> getSubsequenceString(String str)
  {
    if(str.length() == 0)
    {
      ArrayList<String> baseResult = new ArrayList<>();
      baseResult.add("");
      return baseResult;
    }

    char ch = str.charAt(0);
    String restOfString = str.substring(1);
    
    ArrayList<String> recRes = getSubsequenceString(restOfString);

    ArrayList<String> myRes = new ArrayList<>();

    for(String recStr : recRes)
      myRes.add("" + recStr);
    for(String recStr : recRes)
      myRes.add(ch + recStr);

    return myRes;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    ArrayList<String> ans = getSubsequenceString(str);
    System.out.println("Subsequence of String: " + ans);
  }
}
// ^ Keypad Combination means Every number has its keys.
// ? Keypad Combination = 2^n where, n => String Length.
// * Example - Input = 78 will give [tv, tw, tx, uv, uw, ux].

import java.util.*;

public class KeypadCombination
{
  public static Scanner scn = new Scanner(System.in);

  // ! The following list is the key to characters map :
  public static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };
  // &                           {   0 ,   1  ,   2  ,   3  ,   4  ,   5  ,    6  ,   7 ,   8  ,   9  }

  public static ArrayList<String> getKeypadCombination(String str)
  {
    if(str.length() == 0)
    {
      ArrayList<String> baseRes = new ArrayList<>();
      baseRes.add("");
      return baseRes;
    }

    char ch = str.charAt(0);                           
    String restOfStr = str.substring(1);
    
    ArrayList<String> recRes = getKeypadCombination(restOfStr);
    ArrayList<String> myRes = new ArrayList<>();

    String codeforChar = codes[ch - '0'];          // ! Converting Numeric Character into Integer Number.

    for(int i = 0; i < codeforChar.length(); i++) 
    {
      char charCode = codeforChar.charAt(i);
      for (String val : recRes)
        myRes.add(charCode + val);
    }
    
    return myRes;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String with Numbers: ");
    String str = scn.next();
    ArrayList<String> ans = getKeypadCombination(str);
    System.out.println("Keypad Combinations: " + ans);
  }
}
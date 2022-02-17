// ^ Encoding - It means code refers as 1->a, 2->b, ....., 26->z. We need to encode Numbers into Possible Strings.
// * Example -> Input = "123" and Output = "abc, aw, lc".

import java.util.*;

public class Encodings
{
  public static Scanner scn = new Scanner(System.in);

  // public static String[] codes = { "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
  //                                  "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
  
  public static void printEncodings(String str, String ans)
  {
    if(str.length() == 0)
    {
      System.out.print(ans + " ");
      return;
    }
    else if(str.length() == 1)
    {
      if(str.charAt(0) == '0') 
        return;
      else 
      {
        String ch1 = str.substring(0, 1);
        String ros1 = str.substring(1);
        String code1 = (char)('a' + (Integer.parseInt(ch1) - 1)) + "";
        printEncodings(ros1, ans + code1);
      }
    }
    else
    {
      if(str.charAt(0) == '0')
        return;
      else
      {
        String ch1 = str.substring(0, 1);
        String ros1 = str.substring(1);
        String code1 = (char)('a' + (Integer.parseInt(ch1) - 1)) + "";
        printEncodings(ros1, ans + code1);

        String ch12 = str.substring(0, 2);
        String ros12 = str.substring(2);
        String code12 = (char)('a' + (Integer.parseInt(ch12) - 1)) + "";

        if (Integer.parseInt(ch12) <= 26) 
          printEncodings(ros12, ans + code12);
      }  
    } 
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    System.out.print("Encoding of String: ");
    printEncodings(str, "");
    System.out.println();
  }
}
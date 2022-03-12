// ^ Compression of String --> Example: {a,a,b,b,b,c,d,e,e} as {a2b2cde2}.
// ! We need to Sort the String also.

import java.util.*;

public class CompressionOfString
{
  public static Scanner scn = new Scanner(System.in);

  public static String compressString(String str)
  {
    String ans = "";

    for(int i = 0; i < str.length(); i++) 
    {
      int count = 1;

      while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) 
      {
        i++;
        count++;
      }

      ans += str.charAt(i);

      if(count > 1)
        ans += count;
    }
    
    return ans;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    String ans = compressString(str);
    System.out.println("Compressed String: " + ans);
  }
}
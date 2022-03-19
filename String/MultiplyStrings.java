import java.util.*;

public class MultiplyStrings
{
  public static Scanner scn = new Scanner(System.in);

  public static String multiplyStrings(String str1, String str2)
  {
    int n = str1.length();
    int m = str2.length();

    if(n == 0 || m == 0)
      return "0";

    int[] result = new int[n + m];
    
    int idx1 = 0;
    int idx2 = 0;

    for(int i = n - 1; i >= 0; i--)
    {
      int carry = 0;
      int val1 = str1.charAt(i) - '0';

      idx2 = 0;

      for(int j = m - 1; j >= 0; j--)
      {
        int val2 = str2.charAt(j) - '0';
        int sum = val1 * val2 + result[idx1 + idx2] + carry;
        carry = sum / 10;
        result[idx1 + idx2] = sum % 10;
        idx2++;
      }

      if(carry > 0)
        result[idx1 + idx2] += carry;
      
      idx1++;
    }
    
    // ! Ignore 0's from Right of Result Array Or Left of String - 
    int i = result.length - 1;
    while(i >= 0 && result[i] == 0)
      i--;

    if(i == -1)
      return "0";  

    String s = "";
    while(i >= 0)
      s += (result[i--]);
    return s;  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the 1st String: ");
    String str1 = scn.next();
    System.out.print("Enter the 2nd String: ");
    String str2 = scn.next();
    System.out.println("Multiplied String Value: " + multiplyStrings(str1, str2));
  }
}
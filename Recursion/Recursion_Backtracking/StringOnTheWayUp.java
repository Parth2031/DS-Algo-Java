import java.util.*;

public class StringOnTheWayUp
{
  public static Scanner scn = new Scanner(System.in);
  
  public static void printSubstring(String str, String ans)
  {
    if(str.length() == 0)
    {
      System.out.print(ans + " ");
      return;
    }

    char ch = str.charAt(0);
    String restOfString = str.substring(1);

    printSubstring(restOfString, ans + "");
    printSubstring(restOfString, ans + ch);
  }
  
  public static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" }; 

  public static void printKeypadCombinations(String str, String ans)
  {
    
  }


  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the String: ");
    String str = scn.next();
    System.out.print("Substring on the Way Up: ");
    printSubstring(str, "");
    System.out.println();
    System.out.print("Keypad Combinations on the Way Up: ");
    printKeypadCombinations(str, "");
    System.out.println();

  }
}
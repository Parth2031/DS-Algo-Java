import java.util.*;

public class ToggleCharacter
{
  public static Scanner scn = new Scanner(System.in);

  public static String toggleCase(String str)
  {
    String sb = "";
    char ch;
    for (int i = 0; i < str.length(); i++) {
      ch = str.charAt(i);
      if (Character.isUpperCase(ch))
        sb += Character.toLowerCase(ch);
      else
        sb += Character.toUpperCase(ch);
    }

    return sb;
  }
  
  public static String toggleChar(String str)
  {
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < sb.length(); i++)
    {
      char ch = sb.charAt(i);
      if(ch >='A' && ch <='Z')
      {
        char lc = (char) (ch - 'A' + 'a');       // ! Convert To Lower Case
        sb.setCharAt(i, lc);
      }
      else if(ch >= 'a' && ch <= 'z')
      {
        char uc = (char) (ch - 'a' + 'A');       // ! Convert to Upper Case
        sb.setCharAt(i, uc);
      }
    }

    return sb.toString();
  }

  public static void main(String[] args)
  { 
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    // System.out.print(toggleCase(str));
    System.out.print(toggleChar(str));
    System.out.println();
  }
}
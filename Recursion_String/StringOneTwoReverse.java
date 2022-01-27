import java.util.*;

public class StringOneTwoReverse
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isStringReverse(String str1, String str2, int start, int end)
  {
    if(str1.length() != str2.length())
      return false;
    
    if(str1.charAt(start) != str2.charAt(end))
      return false;

    if(end == 0) 
      return true;
      
    return isStringReverse(str1, str2, start + 1, end - 1);  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter 1st String: ");
    String str_1 = scn.next();
    System.out.print("Enter 2nd String: ");
    String str_2 = scn.next();
    System.out.println("Checking Whether Strings are Reversed or Not: " + isStringReverse(str_1, str_2, 0, str_2.length() - 1)); 
  }
}
import java.util.*;

public class MoveCharacters
{
  public static Scanner scn = new Scanner(System.in);

  public static String ShiftCharacters(String str, char key, int idx, int count, String ans)
  {
    if(idx == str.length())
    {
      while(count > 0)
      {
        ans += key;
        count--;
      } 
      return ans;  
    }
    
    if(str.charAt(idx) == key)
      return ShiftCharacters(str, key, idx + 1, count + 1, ans);
    else
      return ShiftCharacters(str, key, idx + 1, count, ans + str.charAt(idx));  
  }
  
  public static int count = 0;

  public static String ShiftCharactersAlter(String str, char key, int idx, String ans)
  {
    if(idx == str.length())
    {
      while(count > 0)
      {
        ans += key;
        count--;
      } 
      return ans;  
    }
    
    if(str.charAt(idx) == key)
    {
      count++;
      return ShiftCharactersAlter(str, key, idx + 1, ans);
    }
    else
      return ShiftCharactersAlter(str, key, idx + 1, ans + str.charAt(idx));  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    System.out.print("Enter a Character to be Shifted at end of Resultant String: ");
    char key = scn.next().charAt(0);
    String ans = ShiftCharacters(str, key, 0, 0, "");
    System.out.println("String with All Matched Key at End of Resultant String: " + ans);
    String alterAns = ShiftCharactersAlter(str, key, 0, "");
    System.out.println("String with All Matched Key at End (Alternative): " + alterAns);
  }
}
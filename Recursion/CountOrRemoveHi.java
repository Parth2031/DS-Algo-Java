import java.util.*;

public class CountOrRemoveHi
{
  public static Scanner scn = new Scanner(System.in);

  public static int CountHi(String str, String word, int idx, int count)
  {
    if(idx >= str.length())
      return count;
    
    if(str.charAt(idx-1) == word.charAt(0) && str.charAt(idx) == word.charAt(1))
      return CountHi(str, word, idx + 1, count + 1); 
    else
      return CountHi(str, word, idx + 1, count);
  }
  
  public static String RemoveHi(String str, String word, int idx, String ans)
  {
    if(idx >= str.length())
      return ans;
      
    if(str.charAt(idx - 1) != word.charAt(0) && str.charAt(idx) != word.charAt(1))
      return RemoveHi(str, word, idx + 1, ans + str.charAt(idx));
    else
      return RemoveHi(str, word, idx + 1, ans);
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    System.out.print("Enter a Word: ");
    String word = scn.next();
    System.out.println("Count Number of 'Hi': " + CountHi(str, word, 1, 0));
    System.out.println("Remove 'Hi': " + RemoveHi(str, word, 1, ""));
  }
}
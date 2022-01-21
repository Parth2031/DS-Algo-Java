import java.util.*;

public class RemoveAdjacentDuplicate
{
  public static Scanner scn = new Scanner(System.in);

  public static String AdjacentDuplicatesRemoved(String str, String ans, int idx)
  {
    if(idx == str.length())
    {
      ans += str.charAt(idx - 1);
      return ans;
    }

    if(str.charAt(idx - 1) == str.charAt(idx))
      return AdjacentDuplicatesRemoved(str, ans, idx + 1);
    else
      return AdjacentDuplicatesRemoved(str, ans + str.charAt(idx - 1), idx + 1);  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the String: ");
    String str = scn.next();
    String ans = AdjacentDuplicatesRemoved(str, "", 1);
    System.out.println("Resultant String with Adjacent Dupicates Removed: " + ans);
  }
}
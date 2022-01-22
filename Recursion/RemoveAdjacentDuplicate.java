// ^ There are 2 Questions - Remove Adjacent Duplicates and Remove All Duplicates.
// * Example : For Remove Adjacent Duplicates -> Input = {aaabbcd} as {abcd}.
// & Example : For Remove All Duplicates -> Input = {abaacdb} as {abcd}.

import java.util.*;

public class RemoveAdjacentDuplicate
{
  public static Scanner scn = new Scanner(System.in);

  public static String AdjacentDuplicatesRemoved(String str, int idx, String ans)
  {
    if(idx == str.length())
    {
      ans += str.charAt(idx - 1);
      return ans;
    }

    if(str.charAt(idx - 1) == str.charAt(idx))
      return AdjacentDuplicatesRemoved(str, idx + 1, ans);
    else
      return AdjacentDuplicatesRemoved(str, idx + 1, ans + str.charAt(idx - 1));  
  }
  
  public static String RemoveAllDuplicates(String str)
  {
    char arr[] = str.toCharArray();
    Arrays.sort(arr);

    String sortedString = new String(arr);
    // String sortedString = String.valueOf(arr);                     // ! Alternative to Above Step

    String res = AdjacentDuplicatesRemoved(sortedString, 1, "");
    return res;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the String: ");
    String str = scn.next();
    String ans = AdjacentDuplicatesRemoved(str, 1, "");
    System.out.println("Resultant String with Adjacent Dupicates Removed: " + ans);
    RemoveAllDuplicates(str);
    System.out.println("String with All Duplicates Removed: " + RemoveAllDuplicates(str));
  }
}
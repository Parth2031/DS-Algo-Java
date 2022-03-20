import java.util.*;

public class RemoveConsecutiveDuplicates
{
  public static Scanner scn = new Scanner(System.in);
 
  public static String heapSort(String str)
  {
    PriorityQueue<Character> pq = new PriorityQueue<>();
    String sortedString = "";

    for(int i = 0; i < str.length(); i++)
    {
      char ch = str.charAt(i);
      pq.add(ch);
    }

    while(pq.size() > 0)
    {
      sortedString += pq.peek();
      pq.remove();
    }

    return sortedString;
  }

  public static String removeAdjacentDuplicates(String str)
  {
    String ans = "";

    for(int i = 0; i < str.length(); i++)
    {
      while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1))
        i++;

      ans += str.charAt(i);  
    }
    
    return ans;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    String sortedString = heapSort(str);
    System.out.println("Sorted String: " + sortedString);
    System.out.println("String after Removing Adjacent/Consecutive Duplicates: " + removeAdjacentDuplicates(str));
  }
}
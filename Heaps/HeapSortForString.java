import java.util.*;

public class HeapSortForString
{
  public static Scanner scn = new Scanner(System.in);

  public static String sort(String str)
  {
    PriorityQueue<Character> pq = new PriorityQueue<>();
    String sortedString = "";
    
    for(int i = 0; i < str.length(); i++)
      pq.add(str.charAt(i));
  
    while(pq.size() > 0)
    {
      sortedString += pq.peek();
      pq.remove();
    }          
    
    return sortedString;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the String: ");
    String str = scn.nextLine();
    System.out.println("Sorted String using HeapSort: " + sort(str));
  }
}
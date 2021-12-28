// ^ Longest Consecutive Sequence of Elements where size "n" is broken into n1, n2 Pair of Elements without Duplicacy.
// ? Example - 

import java.util.*;

public class LongestConsecutiveSequenceOfElements
{
  public static Scanner scn = new Scanner(System.in);

  public static void BiggestCommonSequence(ArrayList<Integer> arr)
  {
    // HashMap<Integer, Integer> hm = new HashMap<>();
    // for (int i = 0; i < arr.size(); i++) 
    // {
    //   int num = arr.get(i);
    //   if(hm.containsKey(num)) 
    //   {
    //     int freq = hm.get(num);
    //     hm.put(num, freq + 1);
    //   } 
    //   else
    //     hm.put(num, 1);
    // }

    

  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the size of Array: ");
    int n = scn.nextInt();
    ArrayList<Integer> arr = new ArrayList<>();
    System.out.print("Enter the Array: ");
    for (int i = 0; i < n; i++)
      arr.add(scn.nextInt());
    
    System.out.print("Longest Consequtive Sequence of Elements while ignoring Duplicacy: ");
    System.out.println();
    BiggestCommonSequence(arr); 

    System.out.println();
  }
}
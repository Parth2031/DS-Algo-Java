// ^ Longest Consecutive Sequence of Elements where size "n" is broken into n1, n2 Pair of Elements without Duplicacy.
// ! Exceptional Case : -->
// * If two sequences of equal length and longest, then print the one for which the starting point of which occurs first in the array.
// ? Example - Size of array = 11
// &           Array = 10 5 9 1 11 8 6 15 3 12 2
// Consecutive Sequence of Elements - 1 2 3
//                                    5 6 
//                                    8 9 10 11 12
//                                    15
// ~           Result = 8 9 10 11 12

import java.util.*;

public class LongestConsecutiveSequenceOfElements
{
  public static Scanner scn = new Scanner(System.in);

  public static void BiggestCommonSequence(ArrayList<Integer> arr)
  {
    HashMap<Integer, Boolean> hm = new HashMap<>();
    
    for(int val : arr)
      hm.put(val, true);     // ! It represents that its corresponding element is the starting element of a desired sequence.
    
    for(int val : arr)
    {
      if(hm.containsKey(val - 1))
        hm.put(val, false);
    }

    int maxLength = 0;
    int maxStartingPoint = 0;
    for(int val : arr)
    {
      if(hm.containsKey(val) == true)
      {
        int tempLength = 1;
        int tempStartingPoint = val;

        while(hm.containsKey(tempLength + tempStartingPoint))
          tempLength++;

        if(tempLength > maxLength)
        {
          maxLength = tempLength;
          maxStartingPoint = tempStartingPoint;
        }  
      }
    }

    for(int i = 0; i < maxLength; i++)
      System.out.println(maxStartingPoint + i);
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
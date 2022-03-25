// ^ In this Question, We take an input array from user and makes a pair of 2 number to get a target sum which was input by user.
// * Example - Input = {2 3 7 -1 1 5 3} with Target {6} & Output = {(7,-1) (1,5) (3,3)}

import java.util.*;

public class TargetSumPair
{
  public static Scanner scn = new Scanner(System.in);

  public static int countAndPrintTargetSumPair(int[] arr, int target)
  {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int pairs = 0;

    System.out.println("Target Sum Pairs: ");
    for(int i = 0; i < arr.length; i++)
    {
      if(hm.containsKey(target - arr[i])) 
      {
        pairs += hm.get(target - arr[i]);
        for(int j = 1; j <= hm.get(target - arr[i]); j++)
          System.out.println((target - arr[i]) + " " + arr[i]);
      }
      
      hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
    }

    return pairs;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Values for Array: ");
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
      arr[i] = scn.nextInt();
    System.out.print("Enter the Target: ");
    int target = scn.nextInt();  
    System.out.println("Number of Target with '2 Sum' Pair: " + countAndPrintTargetSumPair(arr, target));   
  }
}
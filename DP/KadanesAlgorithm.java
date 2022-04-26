// ^ Kadane's Algorithm means Largest Continuous SubArray Sum.
// * Example - Size= {18}, Array = {4 3 -2 6 -14 7 -1 4 5 7 -10 2 9 -10 -5 -9 6 1} & Output = {23}.
// & SubArray = {4 3 -2 6 14}, {7 -1 4 5 7 -10 2 9} & {-10 -5 -9 6 1}.

import java.util.*;

public class KadanesAlgorithm
{
  public static Scanner scn = new Scanner(System.in);

  public static int largestSubArraySum(int[] arr)
  {
    int currentSum = arr[0];
    int overallSum = arr[0];

    for(int i = 1; i < arr.length; i++)
    {
      if(currentSum >= 0)
        currentSum += arr[i];
      else
        currentSum = arr[i];
        
      if(currentSum > overallSum)
        overallSum = currentSum;  
    }
    
    return overallSum;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Array: ");
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
      arr[i] = scn.nextInt();
    System.out.println("Largest Continuous SubArray Sum: " + largestSubArraySum(arr));  
  }
}
// ^ In this Question, We take an input array from user and makes a pair of 2 number to get a target sum which was input by user.
// * Example - Input = {2 3 7 -1 1 5 3} with Target {6} & Output = {(7,-1) (1,5) (3,3)}

import java.util.*;

public class TargetSumPair
{
  public static Scanner scn = new Scanner(System.in);

  public static void targetSumPair(int[] arr, int target)
  {
    for(int  i = 0; i < arr.length; i++)
    {
      for(int j = i + 1; j < arr.length; j++)
      {
        if(arr[i] + arr[j] == target)
          System.out.println(arr[i] + " " + arr[j]);
      }
    }
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
    System.out.println("Target '2 Sum' Pair: ");  
    targetSumPair(arr, target);
  }
}
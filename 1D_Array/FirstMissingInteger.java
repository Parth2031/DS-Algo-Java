// ^ In this Question, We need to find the Next Smallest Missing Positive Integer in the Array.
// * Example - Input = {5, -10, 1, 2, 49, 6} & Output = {3}.

// ! In Range between 1 <= element <= n.
// & If any number is missing in the this range, then that is The Missing Number.
// ~ Else, the Missing Number is (n + 1).

import java.util.*;

public class FirstMissingInteger
{
  public static Scanner scn = new Scanner(System.in);

  public static int firstMissingPositiveNumber(int[] arr)
  {
    int n = arr.length;
    boolean one = false;

    for(int i = 0; i < n; i++) 
    {
      if(arr[i] == 1)
        one = true;

      if(0 >= arr[i] || arr[i] > n) 
        arr[i] = n - 1;
    }

    if(one == false)
      return 1;

    // ! Marking the Index of the Elements - 
    for(int i = 0; i < n; i++) 
    {
      int idx = Math.abs(arr[i]);
      arr[idx - 1] = -Math.abs(arr[idx - 1]);     
    }

    // ! In Range = (1 <= element <= n) -
    for (int i = 0; i < n; i++) 
    {
      if(arr[i] > 0) 
        return i + 1;
    }
    
    return n + 1;
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
    System.out.println("First Smallest Missing Positive Integer Number: " + firstMissingPositiveNumber(arr));
  }
}
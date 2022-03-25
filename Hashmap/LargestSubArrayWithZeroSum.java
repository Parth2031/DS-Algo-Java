// ^ In this Question, We have to find the Length of the Largest SubArray having Zero Sum.
// * Example - Input = {15 -2 2 -8 1 7 10 23} & Output = {5}
// & Since, -1 15 -2 2 -8 1 7  10 23
// ~         0 15 13 15 7 8 15 25 48     So, "15" at Index = 0 (excluding) tilL Index = 5. Therefore, Ans = 5

import java.util.*;

public class LargestSubArrayWithZeroSum
{
  public static Scanner scn = new Scanner(System.in);

  public static int largestSubArrayWithZeroSum(int[] arr)
  {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int maxLength = 0;

    // ! Starting with Sum = 0 & Index = -1 in HashMap.    
    int sum = 0;
    int i = -1;

    hm.put(sum, i);

    while(i < arr.length - 1)
    {
      i++;
      sum += arr[i];

      if(hm.containsKey(sum) == false)
        hm.put(sum, i);
      else
      {
        int length = i - hm.get(sum);
        if(maxLength < length)
          maxLength = length; 
      }  
    }
    
    return maxLength;
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
    System.out.println("Length of the Largest SubArray With Zero Sum: " + largestSubArrayWithZeroSum(arr));
  }
}
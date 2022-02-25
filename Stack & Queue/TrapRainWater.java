// ^ Trap Rain Water - In this, Array of non-negative integers representing an elevation map where the width of each bar is 1.
// & We have to find, how much water it is able to trap after raining.
// * Example 1 - Input = {0 1 0 2 1 0 1 3 2 1 2 1 } and Output = {6}
// ~ Example 2 - Input = {1 2} and Output = {0}

import java.util.*;

public class TrapRainWater
{
  public static Scanner scn = new Scanner(System.in);
  
  public static int TrappedRainwater(int[] arr)
  {
    Stack<Integer> st = new Stack<>();
    
    int ans = 0;
    st.push(-1);

    for (int i = 0; i < arr.length; i++) 
    {
      while (st.peek() != -1 && arr[i] > arr[st.peek()]) 
      {
        int h = arr[st.pop()];
                
        if(st.peek() == -1)
          break;
                
        int width = i - st.peek() - 1;
        int height = Math.min(arr[st.peek()], arr[i]) - h;
                
        ans += width * height;
      }

      st.push(i);
    }
    
    return ans;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Array: ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();
    System.out.println("Trapped Rain Water: " + TrappedRainwater(arr));
  }
}
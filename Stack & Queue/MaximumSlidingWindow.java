// ^ In this Question, We have to select max value in the arr[i, k-1] to create a new array, where i = starting from 0. 
// &                   On each "Slide", this window moves right by one position.
// ~         Example : The new window is now a subarray of size k having indices [1, k], and so on.
// * Example - Input = {7 5 2 6 4 3 8 1 5} with Size = {4} & Output = {7 6 6 8 8 8} 

import java.util.*;

public class MaximumSlidingWindow
{
  public static Scanner scn = new Scanner(System.in);

  // & We are Sending Index as Next Greatest Element and instead of -1, we use "Array Length".
  public static int[] nextGreatestElement_Right(int[] arr)
  {
    int[] nge = new int[arr.length];
    Stack<Integer> st = new Stack<>();
 
    st.push(arr.length - 1);                     // ! Logic Change for Max Sliding Window.
    nge[arr.length - 1] = arr.length;            // ! Logic Change for Max Sliding Window.

    for (int i = arr.length-2; i >= 0; i--)
    {
      while(st.size() > 0 && arr[i] >= arr[st.peek()])       // ! Logic Change for Max Sliding Window.        
        st.pop();
      
      if(st.size() == 0)
        nge[i] = arr.length;                 // ! Logic Change for Max Sliding Window.
      else
        nge[i] = st.peek();
        
      st.push(i);                            // ! Logic Change for Max Sliding Window.
    }

    return nge;
  }

  public static void slidingMaxWindow(int[] arr, int k)
  {
    int[] nge = nextGreatestElement_Right(arr);

    int i = 0;
    for(int window = 0; window <= arr.length - k; window++) 
    {
      if(i < window) 
        i = window;

      while(nge[i] < window + k) {
        i = nge[i];
      }
      
      System.out.print(arr[i] + " ");
    }
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
    System.out.print("Size of the Window: ");
    int k = scn.nextInt();  
    System.out.print("Maximum Value for Each Sliding Window: ");
    slidingMaxWindow(arr, k);
    System.out.println();  
  }
}
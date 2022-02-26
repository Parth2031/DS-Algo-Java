// & Next Smallest Element Concept Used.
// * Example - Input = {6 2 5 4 5 1 6} and Output = {12}.

import java.util.*;

public class LargestAreaInHistogram
{
  public static Scanner scn = new Scanner(System.in);
  
  public static int[] nextSmallestElement_Left(int[] arr)
  {
    // ~ nse -> next Smallest Element
    int[] nse = new int[arr.length];
    Stack<Integer> st = new Stack<>();
 
    st.push(arr[0]);
    nse[0] = -1;

    for(int i = 1; i < arr.length; i++)
    {
      while(st.size() > 0 && arr[i] <= st.peek())
        st.pop();

      if(st.size() == 0)
        nse[i] = -1;
      else 
        nse[i] = st.peek();

      st.push(arr[i]);  
    }
    
    return nse;
  }
  
  public static int[] nextSmallestElement_Right(int[] arr)
  {
    int[] nse = new int[arr.length];
    Stack<Integer> st = new Stack<>();

    st.push(arr[arr.length - 1]);
    nse[arr.length -  1] = -1;

    for(int i = arr.length-2; i >= 0; i--)
    {
      while(st.size() > 0 && arr[i] <= st.peek())
        st.pop();

      if(st.size() == 0)
        nse[i] = -1;
      else
        nse[i] = st.peek();

      st.push(arr[i]);  
    }
    
    return nse;
  }

  public static int largestRectangleAreaHistogram(int[] arr)
  {
    int[] nse_Left = nextSmallestElement_Left(arr); 
    int[] nse_Right = nextSmallestElement_Right(arr);
    
    int maxArea = 0;
    for(int i = 0; i < arr.length; i++)
    {
      int width = nse_Right[i] - nse_Left[i] - 1;
      int area = arr[i] * width;                       // ! height = arr[i];

      if(area > maxArea)
        maxArea = area;
    } 
    
    return maxArea;
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
    System.out.println("Area of the Largest Rectangle in the Histogram: " + largestRectangleAreaHistogram(arr));

    int[] ans_Left = nextSmallestElement_Left(arr);
    int[] ans_Right = nextSmallestElement_Right(arr);
    System.out.print("Next Smallest Element to the Left: ");
    for(int ans : ans_Left)
      System.out.print(ans + " ");
    System.out.println();
    System.out.print("Next Smallest Element to the Right: ");  
    for(int ans : ans_Right)
      System.out.print(ans + " ");
    System.out.println();
  }
}
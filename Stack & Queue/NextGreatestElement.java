// & Next Greatest Element to Left -
// * Input = {9 2 3 1 5 6 0} and Output = {1 9 9 3 9 9 6}
// & Next Greatest Element to Right - 
// * Example - Input = {2 5 9 3 1 12 6 8 7} and Output = {5 9 12 12 12 -1 8 -1 -1}

import java.util.*;

public class NextGreatestElement
{
  public static Scanner scn = new Scanner(System.in);

  // ! Algorithm - Remove, Print, Add  

  public static int[] NextGreatestElement_Left(int[] arr)
  {
    // ~ nge = nextGreatestElement
    int[] nge = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    
    st.push(arr[0]);
    nge[0] = -1;
    for(int i = 1; i < arr.length; i++)
    {
      while(st.size() > 0 && arr[i] >= st.peek())
        st.pop();

      if(st.size() == 0)  
        nge[i] = -1;
      else
        nge[i] = st.peek();
        
      st.push(arr[i]);  
    }
    
    return nge;
  }
   
  public static int[] NextGreatestElement_Right(int[] arr)
  {
    int[] nextGreatestElement = new int[arr.length];
    Stack<Integer> st = new Stack<>();
 
    st.push(arr[arr.length - 1]);
    nextGreatestElement[arr.length - 1] = -1;

    for (int i = arr.length-2; i >= 0; i--)
    {
      while(st.size() > 0 && arr[i] >= st.peek())
        st.pop();
      
      if(st.size() == 0)
        nextGreatestElement[i] = -1;
      else
        nextGreatestElement[i] = st.peek();
        
      st.push(arr[i]);  
    }

    return nextGreatestElement;
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
    int[] ans_Left = NextGreatestElement_Left(arr);
    int[] ans_Right = NextGreatestElement_Right(arr);
    System.out.print("Next Greatest Element to the Left: ");
    for(int ans : ans_Left)
      System.out.print(ans + " ");
    System.out.println();
    System.out.print("Next Greatest Element to the Right: ");  
    for(int ans : ans_Right)
      System.out.print(ans + " ");
    System.out.println();
  }
}
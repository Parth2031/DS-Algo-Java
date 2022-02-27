// ^ In this Question, If two asteroids meet, the smaller one will explode. 
// ^                   If both are the same size, both will explode. 
// ^                   Two asteroids moving in the same direction will never meet.
// & For each asteroid, the absolute value represents its size, and the sign represents its direction.
// * Example - 

import java.util.*;

public class AsteroidCollision
{
  public static Scanner scn = new Scanner(System.in);

  public static int[] asteroidCollision(int[] arr)
  {
    Stack<Integer> st = new Stack<>();

    for(int i = 0;i < arr.length;i++)
    {
      if(arr[i] > 0)
        st.push(arr[i]);
      else
      {
        while(st.size() != 0 && st.peek() > 0 && st.peek() < (-arr[i]))
          st.pop();
        if(st.size() != 0 && st.peek() == (-arr[i]))
          st.pop();
        else if(st.size() == 0 || st.peek() < 0)
          st.push(arr[i]);    
      }  
    }
    
    int ans[] = new int[st.size()];
    int i = ans.length - 1;
    while(i >= 0)
      ans[i--] = st.pop();
    
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
    int[] ans = asteroidCollision(arr);
    System.out.print("Resultant Array with Remaining Asteroid: ");
    for(int i = 0; i < ans.length; i++)
      System.out.print(ans[i] + " ");
    System.out.println();  
  }
}
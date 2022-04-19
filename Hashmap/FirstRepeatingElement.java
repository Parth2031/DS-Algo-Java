// ^ In this Question, We have to return the First Repeating Element = Number/Character in the Array.
// & Similar, Approach for First Non - Repeating Character with a Minor Change.

import java.util.*;

public class FirstRepeatingElement
{
  public static Scanner scn = new Scanner(System.in);
  
  public static int firstRepeatingElement(int[] arr)
  {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for(int i = 0; i < arr.length; i++) 
    {
      if(hm.containsKey(arr[i])) 
        hm.put(arr[i], 2);
      else
        hm.put(arr[i], 1); 
    }

    int result = -1;
    
    for(int ele : arr) 
    {
      if(hm.get(ele) == 2)                // ! First Non - Repeating Element => [hm.get(ele) != 2]
      {
        result = ele;
        break;
      }
    }
    
    return result;
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
    System.out.println("First Repeating Element: " + firstRepeatingElement(arr));  
  }
}
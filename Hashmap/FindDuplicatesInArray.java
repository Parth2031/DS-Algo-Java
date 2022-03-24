// ^ In this, There are 2 Questions - First Repeated "2 Times" Number & Array of "2 Times" Duplicates Numbers.
// & Question 1 - Input = {3 4 1 4 1} & Output = {1} but if No Duplicate is found then Output = {-1}
// * Ouestion 2 - Input = {3 4 1 4 1} & Output = {3 4}.

import java.util.*;

public class FindDuplicatesInArray
{
  public static Scanner scn = new Scanner(System.in);

  public static int duplicateNumberInArray(int[] arr)
  {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for(int i = 0; i < arr.length; i++)
    {
      if(hm.containsKey(arr[i]))
      {
        int freq = hm.get(arr[i]);
        hm.put(arr[i], freq + 1);
      }
      else 
        hm.put(arr[i], 1);
    }
    
    for(Integer key: hm.keySet())
    {
      if(hm.get(key) > 1)
        return key;
    }
    
    return -1;
  }
  
  public static int[] duplicateOfTwiceNumberInArray(int[] arr)
  {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for(int i = 0; i < arr.length; i++)
    {
      if(hm.containsKey(arr[i]))
      {
        int freq = hm.get(arr[i]);
        hm.put(arr[i], freq + 1);
      }
      else 
        hm.put(arr[i], 1);
    }
    
    int k = 0;
    int[] check = new int[arr.length];
    
    for(Integer key: hm.keySet())
    {
      if (hm.get(key) > 1)
        check[k++] = key;
    }

    int len = 0;
    for(int i = 0; i < check.length; i++)
    {
      if(check[i] != 0)
        len++;
    }

    int[] res = new int[len];
    for(int i = 0; i < len; i++)
      res[i] = check[i];

    return res;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Values for Array: ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();
    System.out.println("Find the First Duplicate/Repeated Number: " + duplicateNumberInArray(arr));
    System.out.print("Find All 2 Times Duplicate Number: ");
    int[] ans = duplicateOfTwiceNumberInArray(arr);
    for (int i = 0; i < ans.length; i++)
      System.out.print(ans[i] + " ");
    System.out.println();
  }
}
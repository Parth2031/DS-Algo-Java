// ^ In this, There are 3 Test Cases :-
// & n <= 0 (Invalid Input)
// ~ arr[i] < 0 (Invalid Input)
// * Count Number of Employees with Same Salary

import java.util.*;

public class CountRepeatedNoOfSalary
{
  public static Scanner scn = new Scanner(System.in);

  public static int countRepeatedSalary(int[] arr, int n)
  {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for(int i = 0; i < n; i++)
    {
      if(arr[i] < 0)
        return -1;
    }

    for(int i = 0; i < n; i++)
    {
      if(hm.containsKey(arr[i]))
      {
        int freq = hm.get(arr[i]);
        hm.put(arr[i], freq + 1);
      }
      else 
        hm.put(arr[i], 1);
    }
    
    int count = 1;

    for(Integer key: hm.keySet())
    {
      if(hm.get(key) > 1)
        count++;
    }
    
    if(count > 1)
      return count;
    else
      return 0;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    if(n <= 0)
      System.out.println("Invalid Input");
    else
    {
      System.out.print("Enter the Values for Array: ");
      int[] arr = new int[n];
      for(int i = 0; i < n; i++)
        arr[i] = scn.nextInt();

      if(countRepeatedSalary(arr, n) == -1)
        System.out.println("Invalid Input");
      else
        System.out.println("Number of Employees with Same Salary: " + countRepeatedSalary(arr, n));  
    }
  }
}
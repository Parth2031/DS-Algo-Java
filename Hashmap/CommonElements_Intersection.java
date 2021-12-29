// ! Get Common Elements 1 - 
// ^ In this, we have to get Common Elements from Array1 in same order as Array2 with No Duplicates.
// ? Example - Size of 1st Array = 9 , Size of 2nd Array = 18
// &           Array1 = 5 5 9 8 5 5 8 0 3
// &           Array2 = 9 7 1 0 3 6 5 9 1 1 8 0 2 4 2 9 1 5
// *           Result = 9 0 3 5 8

// ! Get Common Elements 2 - 
// ^ Find the Intersection between Array1 and Array2 with Duplicates.
// ? Example - Size of 1st Array = 7 , Size of 2nd Array = 7
// &           Array1 = 1 1 2 2 2 3 5
// &           Array2 = 1 1 1 2 2 4 5
// *           Result = 1 1 2 2 5

import java.util.*;

public class CommonElements_Intersection
{
  public static Scanner scn = new Scanner(System.in);

  public static void CommonElements_1(ArrayList<Integer> arr1, ArrayList<Integer> arr2)
  {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < arr1.size(); i++) 
    {
      int num = arr1.get(i);
      if(hm.containsKey(num)) 
      {
        int freq = hm.get(num);
        hm.put(num, freq + 1);
      } 
      else
        hm.put(num, 1);
    }

    for (int j : arr2) 
    {
      if(hm.containsKey(j)) 
      {
        System.out.println(j);
        hm.remove(j);
      }
    }
  }

  public static void CommonElements_2(ArrayList<Integer> arr1, ArrayList<Integer> arr2)
  {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < arr1.size(); i++) 
    {
      int num = arr1.get(i);
      if(hm.containsKey(num)) 
      {
        int freq = hm.get(num);;
        hm.put(num, freq + 1);
      } 
      else
        hm.put(num, 1);
    }

    for (int j = 0; j < arr2.size(); j++) 
    {
      int num = arr2.get(j);
      if(hm.containsKey(num) && hm.get(num) > 0)
      {
        System.out.println(num);
        int freq = hm.get(num);
        freq -= 1;
        hm.put(num, freq);
      }  
    }
  } 

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the size of 1st Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the size of 2nd Array: ");
    int m = scn.nextInt();
    ArrayList<Integer> arr1 = new ArrayList<>();
    System.out.print("Enter the 1st Array: ");
    for (int i = 0; i < n; i++)
      arr1.add(scn.nextInt());
    ArrayList<Integer> arr2 = new ArrayList<>();
    System.out.print("Enter the 2nd Array: ");
    for (int i = 0; i < m; i++)
      arr2.add(scn.nextInt());
    
    System.out.print("Common Elements of 1st Array and 2nd Array while Removing Duplicates: ");  
    System.out.println();
    CommonElements_1(arr1, arr2);
    System.out.println();

    System.out.print("Intersection of 1st Array and 2nd Array with Duplicates: ");
    System.out.println();
    CommonElements_2(arr1, arr2); 

    System.out.println();
  }
}
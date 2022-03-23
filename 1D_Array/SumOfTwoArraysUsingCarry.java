import java.util.*;

public class SumOfTwoArraysUsingCarry
{
  public static Scanner scn = new Scanner(System.in);

  public static int[] sumArrays(int[] arr1, int[] arr2)
  {
    int k = arr1.length > arr2.length ? arr1.length : arr2.length;
    int[] res = new int[k];

    int sum = 0, carry = 0, check;
    int i = arr1.length - 1, j = arr2.length - 1, totalLength = k - 1;
  
    for(; i >= 0 || j >= 0; i--, j--)
    {
      check = carry;

      if(i >= 0)  check += arr1[i];
      if(j >= 0)  check += arr2[j];

      sum = check % 10;
      res[totalLength --] = sum;
      carry = check / 10;
    } 
  
    System.out.print("Sum of Two Array's with Carry in Returned Array: ");
    if(carry > 0)
      System.out.print(carry); 

    return res;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of 1st Array: ");
    int n = scn.nextInt();
    int[] arr1 = new int[n];
    System.out.print("Enter the Values for 1st Array: ");
    for(int i = 0; i < n; i++)
      arr1[i] = scn.nextInt();
    System.out.print("Enter the Size of 2nd Array: ");
    int m = scn.nextInt();
    int[] arr2 = new int[m];
    System.out.print("Enter the Values for 2nd Array: ");
    for(int i = 0; i < m; i++)
      arr2[i] = scn.nextInt();
    int[] ans = sumArrays(arr1, arr2);
    for(int i = 0; i < ans.length; i++)
      System.out.print(ans[i]);
    System.out.println();  
  }
}
import java.util.*;

public class CheckSorted
{
  public static Scanner scn = new Scanner(System.in);
  
  public static boolean isSorted(int[] arr, int idx)
  {
    if(idx == arr.length-1)
      return true;
  
    boolean mr = false;
    
    if(arr[idx] < arr[idx + 1])
      mr = true;
    else
      return false;

    boolean rr = isSorted(arr, idx + 1);
    
    return mr && rr;
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
    System.out.println(isSorted(arr, 0));
  }
}
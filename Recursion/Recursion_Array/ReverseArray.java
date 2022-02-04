import java.util.*;

public class ReverseArray
{
  public static Scanner scn = new Scanner(System.in);

  public static void ReversedArray(ArrayList<Integer> arr, int start, int end)
  {
    int temp;
    if(start <= end)
    {
      temp = arr.get(start);
      arr.set(start, arr.get(end));
      arr.set(end, temp);

      ReversedArray(arr, start + 1, end - 1);
    }
    
    return;
  }
  
  public static void reverseArray(ArrayList<Integer> arr, int idx)
  {
    if(idx == arr.size())
      return;

    reverseArray(arr, idx + 1);
    System.out.print(arr.get(idx) + " ");
  }


  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Array: ");
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i = 0; i < n; i++)
      arr.add(scn.nextInt());
    ReversedArray(arr, 0, n - 1);
    System.out.print("Reversed Array: ");
    for (int i = 0; i < n; i++)
      System.out.print(arr.get(i) + " ");
    System.out.println();
    System.out.print("Reverse Array: ");  
    reverseArray(arr, 0);
    System.out.println();
  }
}
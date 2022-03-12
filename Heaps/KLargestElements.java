import java.util.*;

public class KLargestElements
{
  public static Scanner scn = new Scanner(System.in);

  public static int[] kLargestElements(int[] arr, int k)
  {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int val : arr)
      pq.add(val);
    
    while(pq.size() > k) 
      pq.remove();
    
    int[] ans = new int[k];
    int i = 0;

    while(pq.size() > 0)
    {
      ans[i++] = pq.peek();
      pq.remove();
    }

    return ans;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Value for Array: ");
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
      arr[i] = scn.nextInt();
    System.out.print("Enter a Number K: ");
    int k = scn.nextInt();
    int[] ans = kLargestElements(arr, k);
    System.out.print("Print All the K Largest Elements in the Array: ");
    for(int i = 0; i < k; i++)
      System.out.print(ans[i] + " ");
    System.out.println();  
  }
}
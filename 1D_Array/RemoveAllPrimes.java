import java.util.*;

public class RemoveAllPrimes
{
  public static Scanner scn = new Scanner(System.in);
   
  public static boolean isPrime(int n)
  {
    int count = 0;
    boolean flag = true;
    if(n == 0 || n == 1)
      flag = false;
    for(int s = 2; s <= n; s++)
    {
      if ((n % s) == 0)
        count++;
    }
    if(count > 1)
      flag = false;
    return flag;  
  }

  public static ArrayList<Integer> RemovePrimes(ArrayList<Integer> arr)
  {
    ArrayList<Integer> res = new ArrayList<>();
    for(int i = 0; i < arr.size(); i++)
    {
      boolean check = isPrime(arr.get(i));
      if (check != true)
        res.add(arr.get(i));
    }
    return res;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the size for Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Array: ");
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++)
      arr.add(scn.nextInt());
    ArrayList<Integer> ans = RemovePrimes(arr);
    System.out.print("ArrayList after Removing All Primes: ");
    for (int i = 0; i < ans.size(); i++)
      System.out.print(ans.get(i) + " ");     
    System.out.println();
  }
}
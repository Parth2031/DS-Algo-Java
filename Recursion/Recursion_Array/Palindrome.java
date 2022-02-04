import java.util.*;

public class Palindrome
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isPalindromeArray(ArrayList<Integer> arr, int start, int end)
  {
    if(start == end || start == end - 1)
    {
      if(arr.get(start) != arr.get(end))
        return false;
      return true;  
    }  

    if(arr.get(start) != arr.get(end))
      return false;

    boolean res = isPalindromeArray(arr, start + 1, end - 1);
    return res;
  }
  
  public static boolean isPalindromeString(String str, int start, int end)
  {
    if(start == end || start == end - 1)
    {
      if(str.charAt(start) != str.charAt(end))
        return false;
      return true;  
    }  

    if(str.charAt(start) != str.charAt(end))
      return false;

    boolean res = isPalindromeString(str, start + 1, end - 1);
    return res;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Values for Array: ");
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++)
      arr.add(scn.nextInt());
    System.out.print("Enter a String: ");
    String str = scn.next();
    System.out.println("Is Array Palindrome or Not: " + isPalindromeArray(arr, 0, n-1));  
    System.out.println("Is String Palindrome or Not: " + isPalindromeString(str, 0, str.length() - 1));
  }
}
import java.util.*;

public class FindNoAndIndexInArray
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isValuePresentInArray(ArrayList<Integer> arr, int idx, int key)
  {
    if(idx == arr.size())
      return false;

    if(key == arr.get(idx))
      return true;  

    boolean res = isValuePresentInArray(arr, idx + 1, key);

    return res;
  }
  
  public static int IndexOfNumber(ArrayList<Integer> arr, int idx, int key)
  {
    if(idx == arr.size())
      return 0;

    if(key == arr.get(idx))
      return idx;
    
    int res = IndexOfNumber(arr, idx + 1, key);
    
    return res;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    System.out.print("Enter the Values for Array: ");
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i = 0; i < n; i++)
      arr.add(scn.nextInt());
    System.out.print("Enter the Number to be Checked: ");  
    int key = scn.nextInt();  
    System.out.println("Is Value Present in Array: " + isValuePresentInArray(arr, 0, key));
    System.out.print("Index of Number in Array: " + IndexOfNumber(arr, 0, key));
    System.out.println();
  }
}
import java.util.*;

public class StairPathOnTheWayUp
{
  public static Scanner scn = new Scanner(System.in);

  public static void printStairPaths(int n, String ans)
  { 
    if(n <= 0)
    {
      if (n == 0)
        System.out.print(ans + " ");
      return;
    }
    
    printStairPaths(n - 1, ans + 1);
    printStairPaths(n - 2, ans + 2);
    printStairPaths(n - 3, ans + 3);
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    printStairPaths(n, "");
    System.out.println();
  }
}
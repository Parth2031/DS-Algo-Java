// ^ Stair Paths means a Person can take 1 step, 2 step or 3 step at a time to reach Final Destination.

import java.util.*;

public class StairPaths
{
  public static Scanner scn = new Scanner(System.in);

  public static ArrayList<String> getStairPaths(int n)
  {
    if(n == 0)
    {

    }
    if(n < 0)
    {

    }

     

  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    ArrayList<String> ans = getStairPaths(n);
    System.out.println("Number of Steps to reach Destination: " + ans);
  }
}
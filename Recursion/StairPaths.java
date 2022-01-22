// ^ Stair Paths means a Person from Target floor can take 1 step jump, 2 step jump or 3 step jump down at a time to reach Ground = 0.
// * Example : Input = 3 with Output = [111, 12, 21, 3].

import java.util.*;

public class StairPaths
{
  public static Scanner scn = new Scanner(System.in);

  public static ArrayList<String> getStairPaths(int n)
  {
    if(n == 0)
    {
      ArrayList<String> baseRes = new ArrayList<>();
      baseRes.add("");
      return baseRes;
    }
    else if(n < 0)
    {
      ArrayList<String> baseRes = new ArrayList<>();
      return baseRes;
    }

    ArrayList<String> paths1 = getStairPaths(n - 1); 
    ArrayList<String> paths2 = getStairPaths(n - 2); 
    ArrayList<String> paths3 = getStairPaths(n - 3); 

    ArrayList<String> paths = new ArrayList<>(); 

    for (String path : paths1) 
      paths.add("1" + path); 
    for (String path : paths2) 
      paths.add("2" + path); 
    for (String path : paths3) 
      paths.add("3" + path);
      
    return paths;
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
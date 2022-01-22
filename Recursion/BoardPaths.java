// ^ Board Paths means using Dice Numbers to Reach Final Target.

import java.util.*;

public class BoardPaths
{
  public static Scanner scn = new Scanner(System.in);

  public static int countBoardPaths(int source, int destination)
  {
    if(source == destination)
      return 1;

    if(source > destination)
      return 0;
 
    int count = 0;
    
    for(int dice = 1; dice <= 6; dice++)
      count += countBoardPaths(source + dice, destination);
     
    return count;
  }

  public static void waysToBoardPaths(int source, int destination, String res)
  {
    if(source == destination)
    {
      System.out.println(res);
      return;
    } 

    if(source > destination)
      return;
    
    for(int dice = 1; dice <= 6; dice++)
      waysToBoardPaths(source + dice, destination, res + dice);
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Target: ");
    int target = scn.nextInt();
    System.out.println("Count Number of Ways to Reach Destination: " + countBoardPaths(0, target));
    waysToBoardPaths(0, target, "");
    // System.out.println("Ways to reach Destination: " + ans);
  }
}
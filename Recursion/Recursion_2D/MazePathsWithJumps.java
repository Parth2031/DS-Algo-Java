// ^ Combination of two Questions -> MazePaths and StairPaths.
// ! hms -> Horizontal Move Size
// ! vms -> Vertical Move Size
// ! dms -> Diagonal Move Size

import java.util.*;

public class MazePathsWithJumps
{
  public static Scanner scn = new Scanner(System.in);

  public static ArrayList<String> getMazePathsWithJumps(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn)
  {
    if(sourceRow == destinationRow && sourceColumn == destinationColumn) 
    {
      ArrayList<String> baseResult = new ArrayList<>();
      baseResult.add("");
      return baseResult;
    }
    else if (sourceRow > destinationRow || sourceColumn > destinationColumn)
    {
      ArrayList<String> baseResult = new ArrayList<>();
      return baseResult;
    }

    ArrayList<String> ansPaths = new ArrayList<>();

    // ! Horizontal Moves
    for(int hms = 1; hms <= (destinationColumn - sourceColumn); hms++)
    {
      ArrayList<String> hPaths = getMazePathsWithJumps(sourceRow, sourceColumn + hms, destinationRow, destinationColumn);
      
      for (String hpath : hPaths) 
        ansPaths.add("h" + hms + hpath); 
    }
      
    // ! Vertical Moves
    for (int vms = 1; vms <= (destinationRow - sourceRow); vms++) 
    {
      ArrayList<String> vPaths = getMazePathsWithJumps(sourceRow + vms, sourceColumn, destinationRow, destinationColumn);

      for (String vpath : vPaths)
        ansPaths.add("v" + vms + vpath);
    }

    // ! Diagonal Moves
    for (int dms = 1; dms <= (destinationRow - sourceRow) && dms <= (destinationColumn - sourceColumn); dms++) 
    {
      ArrayList<String> dPaths = getMazePathsWithJumps(sourceRow + dms, sourceColumn + dms, destinationRow, destinationColumn);

      for (String dpath : dPaths)
        ansPaths.add("d" + dms + dpath);
    }        

    return ansPaths;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the number of Rows: ");
    int n = scn.nextInt();
    System.out.print("Enter the number of Columns: ");
    int m = scn.nextInt();
    ArrayList<String> ans = getMazePathsWithJumps(1, 1, n, m);
    System.out.println("Ways to Reach Maze Path Destination: ");
    System.out.println(ans);
  }
}
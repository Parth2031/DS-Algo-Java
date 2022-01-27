import java.util.*;

public class MazePaths
{
  public static Scanner scn = new Scanner(System.in);

  public static ArrayList<String> getMazePaths(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn)
  {
    if(sourceRow == destinationRow && sourceColumn == destinationColumn) 
    {
      ArrayList<String> baseResult = new ArrayList<>();
      baseResult.add("");
      return baseResult;
    }
    
    ArrayList<String> horizontalPaths = new ArrayList<>();
    ArrayList<String> verticalPaths = new ArrayList<>();

    if (sourceColumn < destinationColumn) 
      horizontalPaths = getMazePaths(sourceRow, sourceColumn + 1, destinationRow, destinationColumn);
    if (sourceRow < destinationRow) 
      verticalPaths = getMazePaths(sourceRow + 1, sourceColumn, destinationRow, destinationColumn); 

    ArrayList<String> ansPaths = new ArrayList<>(); 

    for (String hpath : horizontalPaths) 
      ansPaths.add("h" + hpath); 
    for (String vpath : verticalPaths) 
      ansPaths.add("v" + vpath); 

    return ansPaths;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the number of Rows: ");
    int n = scn.nextInt();
    System.out.print("Enter the number of Columns: ");
    int m = scn.nextInt();
    ArrayList<String> ans = getMazePaths(1, 1, n, m);
    System.out.println("Ways to Reach Maze Path Destination: " + ans);
  }
}
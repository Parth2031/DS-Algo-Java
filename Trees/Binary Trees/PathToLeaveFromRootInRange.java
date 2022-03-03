import java.util.*;

public class PathToLeaveFromRootInRange
{
  public static Scanner scn = new Scanner(System.in);

  public static class Node 
  {
    int data;
    Node left;
    Node right;

    public Node() {

    }

    public Node(int data) {
      this.data = data;
    }

    public Node(int data, Node left, Node right)
    {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString()
    {
      String str = "";
      str += (left != null ? left.data:".");
      str += (" -> " + data + " <- ");
      str += (right != null ? right.data : ".");
      str += "\n";
      
      if(left != null)
        str += left.toString();
      if(right != null)
        str += right.toString();
        
      return str;  
    }
  } 

  public static int idx = 0;

  public static Node createTree(int[] arr)
  {
    if(idx == arr.length || arr[idx] == -1)
    {
      idx++;
      return null;
    }

    Node node = new Node(arr[idx]);
    idx++;

    node.left = createTree(arr);
    node.right = createTree(arr);

    return node;
  }

  public static void leaveToRootSumInRange(Node node, String path, int sum, int low, int high)
  {
    if(node == null) 
      return;
    
    // ! This Condition is Checked beacuse till now Leaf Node value is neither added or used. 
    // ~ This Stateent works upon Leaf Node.
    if(node.left == null && node.right == null) 
    { 
      sum += node.data; 
      if(low <= sum && sum <= high)  
        System.out.println(path + node.data);
      return;
    }
    
    leaveToRootSumInRange(node.left, path + node.data + " ", sum + node.data, low, high); 
    leaveToRootSumInRange(node.right, path + node.data + " ", sum + node.data, low, high);
  }

  public static void main(String[] args)
  {
    System.out.println();
    int[] arr = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1}; 
    
    Node root = createTree(arr);
    System.out.print("Path from Leaves to Root Where Sum is in Range: ");
    leaveToRootSumInRange(root,"", 0, 99, 101);
  }
}
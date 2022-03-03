import java.util.*;

public class KLevelsDown
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

  public static void printKLevelsDown(Node node, int k)
  {
    if(node == null || k < 0)
      return;
      
    if(k == 0)
    {
      System.out.print(node.data + " ");
      return;
    }  
    
    printKLevelsDown(node.left, k - 1);
    printKLevelsDown(node.right, k - 1);
  }

  public static void main(String[] args)
  {
    System.out.println();
    int[] arr = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1}; 
    
    Node root = createTree(arr);
    System.out.print("Enter a Value for Level in Tree: ");
    int kLevel = scn.nextInt();
    printKLevelsDown(root, kLevel);
    
    System.out.println();
  }
}
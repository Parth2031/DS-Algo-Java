import java.util.*;

public class PrintInRangeOfBST
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
      str += (left != null ? left.data : "0");
      str += (" -> " + data + " <- ");
      str += (right != null ? right.data : "0");
      str += "\n";

      if(left != null)
        str += left.toString();
      if(right != null)
        str += right.toString();

      return str;  
    }
  }
  
  public static Node createSearchTree(int[] arr, int start, int end)
  {
    if(start > end)
      return null;

    int mid = (start + end) >> 1;
    Node node = new Node(arr[mid]);

    node.left = createSearchTree(arr, start, mid - 1);
    node.right = createSearchTree(arr, mid + 1, end); 

    return node;
  }

  public static Node BST()
  {
    int[] arr = new int[10];

    for(int i = 0; i < 10; i++)
      arr[i] = (i + 1) * 10;

    Node root = createSearchTree(arr, 0, arr.length - 1);
    
    return root;
  } 
  
  public static void printInRange(Node node, int leftNodeValue, int rightNodeValue)
  {
    if(node == null)
      return;

    // ! If the Given range is smaller than Current node's value -> 
    if(leftNodeValue < node.data && rightNodeValue < node.data)
      printInRange(node.left, leftNodeValue, rightNodeValue);
    
    // ! Vice versa to above ->
    else if(leftNodeValue > node.data && rightNodeValue > node.data)
      printInRange(node.right, leftNodeValue, rightNodeValue);
    
    // ! If Current Node's value is in the Given Range -> 
    else
    {
      // * We use InOrder Traversal ->>
      printInRange(node.left, leftNodeValue, rightNodeValue);
      System.out.print(node.data + " ");
      printInRange(node.right, leftNodeValue, rightNodeValue);
    }      
  }

  public static void main(String[] args)
  {
    System.out.println();
    Node root = BST();
    
    System.out.print("Value of the left Node to it's LCA: ");
    int leftValue = scn.nextInt();
    System.out.print("Value of the right Node to it's LCA: ");
    int rightValue = scn.nextInt();
    System.out.print("Print All Nodes which are In a Given Range: ");
    printInRange(root, leftValue, rightValue);
    System.out.println();
  }
}
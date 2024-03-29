// ^ Lowest Common Ancestor of any two node means Common Parent of those two nodes.

import java.util.*;

public class LowestCommonAncestor_LCAInBST
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
  
  public static int LowestCommonAncestor(Node node, int leftNodeValue, int rightNodeValue)
  {
    if(node == null)
      return 0;

    if(leftNodeValue < node.data && rightNodeValue < node.data)
      return LowestCommonAncestor(node.left, leftNodeValue, rightNodeValue);
    else if(leftNodeValue > node.data && rightNodeValue > node.data)
      return LowestCommonAncestor(node.right, leftNodeValue, rightNodeValue);
    else
      return node.data;
  }

  public static void main(String[] args)
  {
    System.out.println();
    Node root = BST();

    System.out.print("Value of the left Node to it's LCA: ");
    int leftValue = scn.nextInt();
    System.out.print("Value of the right Node to it's LCA: ");
    int rightValue = scn.nextInt();
    System.out.println("Lowest Common Ancestor of any Two Nodes: " + LowestCommonAncestor(root, leftValue, rightValue)); 
  }
}
// ^ In this Question, We have to find a Pair of Nodes to match a Target Value.
// & Where, We would print the pair in ascending order with the Pair as (smallerValue, biggerValue).
// * Unique Pairs are Not Handled.

import java.util.*;

public class TargetSumPairInBST
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
  
  public static boolean find(Node node, int data)
  {
    if(node == null)
      return false;

    if(node.data == data)
      return true;
      
    boolean leftChild = find(node.left, data);
    if(leftChild == true) 
      return true;
      
    boolean rightChild = find(node.right, data);
    if(rightChild == true)
      return true;
     
    return false;  
  }
  
  public static void targetSumPair(Node root, Node node, int target)
  {
    if(node == null)
      return;

    targetSumPair(root, node.left, target);

    int complement = target - node.data;
    if(node.data < complement)
    {
      if(find(root, complement) == true)
        System.out.println(node.data + " " + complement);
    }

    targetSumPair(root, node.right, target);
  }

  public static void main(String[] args)
  {
    System.out.println();
    Node root = BST();
    
    System.out.print("Enter a Target Value: ");
    int target = scn.nextInt();
    System.out.println("Target Sum Pair in Ascending Order: ");
    targetSumPair(root, root, target);     
  }
}
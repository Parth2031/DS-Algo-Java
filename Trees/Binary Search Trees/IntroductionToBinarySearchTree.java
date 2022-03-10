// ^ Binary Search Tree Default Working :-

// ? We define a Mid Value and all smaller values are transfered to the left side of the tree and higher to right side.

// ! "-1" refers to Null Value in either Left or Right Side of the Binary Tree. 

import java.util.*;

public class IntroductionToBinarySearchTree
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
      str += (right != null ? right.data:".");
      str += "\n";

      if(left != null)
        str += left.toString();
      if(right != null)
        str += right.toString();

      return str;    
    }
  }

  public static Node createSearchTree(int[] arr, int startIndex, int endIndex)
  {
    if(startIndex > endIndex)
      return null;

    int mid = (startIndex + endIndex) >> 1;
    Node node = new Node(arr[mid]);
   
    node.left = createSearchTree(arr, startIndex, mid - 1);
    node.right = createSearchTree(arr, mid + 1, endIndex);

    return node;
  }

  public static Node BST()
  {
    int[] arr = new int[10];

    for(int i = 0; i < 10; i++)
      arr[i] = (i + 1) * 10;

    Node root = createSearchTree(arr,0,arr.length - 1);

    return root;  
  }

  public static void main(String[] args)
  {
    System.out.println();
    
    Node root = BST();
    System.out.println("Binary Search Tree in PreOrder: ");
    System.out.print(root);
    
  }
}
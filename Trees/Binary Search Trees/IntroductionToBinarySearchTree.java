// ^ Binary Search Tree Default Working :-



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

  

  public static void main(String[] args)
  {
    System.out.println();
    
    int[] arr = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1};
    
    // Node root = createTree(arr);
    System.out.println("Binary Search Tree in PreOrder: ");
    System.out.print(root);
    
  }
}
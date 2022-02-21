import java.util.*;

public class TraversalInBinaryTree
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
      str += (left != null ? left.data : ".");
      str += (" -> " + data + " <- ");
      str += (right != null ? right.data : ".");
      str += "\n";

      if(left != null)
        str += left.toString();
      if (right != null)
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

  public static void traversalPreorder(Node node)
  {
    if(node == null)
      return;
    
    System.out.print(node.data + " ");
    traversalPreorder(node.left);
    traversalPreorder(node.right);
  }

  public static void traversalInorder(Node node)
  {
    if(node == null)
      return;
    
    traversalPreorder(node.left);
    System.out.print(node.data + " ");
    traversalPreorder(node.right);
  }

  public static void traversalPostorder(Node node)
  {
    if(node == null)
      return;
    
    traversalPreorder(node.left);
    traversalPreorder(node.right);
    System.out.print(node.data + " ");
  }

  public static void main(String[] args)
  {
    System.out.println();

    int[] arr = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1}; 
    Node root = createTree(arr);

    System.out.print("Binary Tree in PreOrder: ");
    traversalPreorder(root);
    System.out.println();
    System.out.print("Binary Tree in InOrder: ");
    traversalInorder(root);
    System.out.println();
    System.out.print("Binary Tree in PostOrder: ");
    traversalPostorder(root);
    System.out.println();
  }
}
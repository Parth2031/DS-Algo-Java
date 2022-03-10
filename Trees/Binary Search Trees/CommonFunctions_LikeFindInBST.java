import java.util.*;

public class CommonFunctions_LikeFindInBST
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
  
  public static int max(Node node)
  {
    if(node.right == null) 
      return node.data;
    else 
      return max(node.right);
  }
  
  public static int min(Node node)
  {
    if(node.left == null)
      return node.data;
    else
      return min(node.left);  
  }

  public static int size(Node node)
  {
    if(node == null) 
      return 0;

    int leftSize = size(node.left);
    int rightSize = size(node.right);
    int totalSize = leftSize + rightSize + 1;

    return totalSize;
  }

  public static int sum(Node node)
  {
    if(node == null)
      return 0;

    int leftSum = sum(node.left);
    int rightSum = sum(node.right);
    int totalSum = node.data + leftSum + rightSum;
    
    return totalSum;
  }

  public static boolean find_1(Node node, int val)
  {
    if(node == null)
      return false;

    if(node.data == val)
      return true;
      
    boolean leftChild = find_1(node.left, val);
    if(leftChild)
      return true;
      
    boolean rightChild = find_1(node.right, val);
    if(rightChild)
      return true;
      
    return false;  
  }

  public static boolean find_2(Node node, int val)
  {
    while(node != null)
    {
      if(node.data == val)
        return true;
      else if(val < node.data)
        node = node.left;
      else
        node = node.right;    
    }
    
    return false;
  }

  public static void main(String[] args)
  {
    System.out.println();

    Node root = BST();
    System.out.println("Maximum Value in Binary Search Tree: " + max(root));
    System.out.println("Minimum Value in Binary Search Tree: " + min(root));
    System.out.println("Size of Binary Search Tree: " + size(root));
    System.out.println("Sum of Binary Search Tree: " + sum(root));
    System.out.print("Enter a Value to be found: ");
    int key = scn.nextInt();
    System.out.println("Value/Item is Present in Binary Tree or not: " + find_1(root, key));
    System.out.println("Value is Present in Binary Tree or not (Alternative): " + find_2(root, key));
  }
}
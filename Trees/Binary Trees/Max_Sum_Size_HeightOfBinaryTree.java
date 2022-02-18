import java.util.*;

public class Max_Sum_Size_HeightOfBinaryTree
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
      String str = " ";
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

  public static int maxValue(Node node)
  {
    if(node == null)
      return Integer.MIN_VALUE;

    int leftMax = maxValue(node.left);
    int rightMax = maxValue(node.right);
    int overallMax = Math.max(leftMax, rightMax);

    return Math.max(node.data, overallMax);
  }
  
  public static int minValue(Node node)
  {
    if(node == null)
      return Integer.MAX_VALUE;

    int leftMin = minValue(node.left);
    int rightMin = minValue(node.right);
    int overallMin = Math.min(leftMin, rightMin);

    return Math.min(node.data, overallMin);
  }
  
  // ! Size - It counts every node as value = 1 and adds up with +1 value.  

  public static int size(Node node)
  {
    if(node == null)
      return 0;

    int leftSize = size(node.left);
    int rightSize = size(node.right);
    int overallSize = leftSize + rightSize + 1;
    
    return overallSize;
  }
  
  public static int sum(Node node)
  {
    if(node == null)
      return 0;
    
    int leftSum = sum(node.left);
    int rightSum = sum(node.right);
    int overallSum = leftSum + rightSum + node.data;

    return overallSum;
  }

  public static int height(Node node)
  {
    if(node == null)
      return -1;
    
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    int overallHeight = Math.max(leftHeight, rightHeight) + 1;

    return overallHeight; 
  }
  
  public static boolean find(Node node, int item)
  {
    if(node == null)
      return false;
      
    if(node.data == item)
      return true;
      
    boolean result = false;

    result = result || find(node.left, item);
    result = result || find(node.right, item);
    return result;
  }

  public static void main(String[] args)
  {
    System.out.println();
    int[] arr = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1};
    
    Node root = createTree(arr);
    System.out.println("Maximum Value in Binary Tree: " + maxValue(root));
    System.out.println("Minimum Value in Binary Tree: " + minValue(root));
    System.out.println("Size of Binary Tree: " + size(root));
    System.out.println("Sum of Binary Tree: " + sum(root));
    System.out.println("Height of Binary Tree: " + height(root));
    System.out.print("Enter the Value to be found: ");
    int item = scn.nextInt();
    System.out.println("Value/Item is Present in Binary Tree or not: " + find(root, item));
  }
}
// ^ Number of Questions are - 
// & Max, Min, Sum, Size, Height / Max Depth, Diameter, Tilt and Find in Bianry Tree.

import java.util.*;

public class MathFunction_LikeHeightInBinaryTree
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

  public static int heightOrMaxDepth(Node node)
  {
    if (node == null)
      return -1;

    int leftHeight = heightOrMaxDepth(node.left);
    int rightHeight = heightOrMaxDepth(node.right);
    int overallHeight = Math.max(leftHeight, rightHeight) + 1;

    return overallHeight;
  }
  
  public static int diameter(Node node)
  {
    if (node == null)
      return 0;

    int leftDiameter = diameter(node.left);
    int rightDiameter = diameter(node.right);
    int overallDiameter = Math.max(leftDiameter, rightDiameter);
    int resultDiameter = Math.max(heightOrMaxDepth(node), overallDiameter);

    return resultDiameter;
  }

  public static int t = 0;
  
  public static int tilt(Node node)
  {
    if(node == null)
      return 0;
    
    int leftTilt = tilt(node.left);
    int rightTilt = tilt(node.right);
    int totalTilt = leftTilt + rightTilt + node.data;

    // ! Tilt in Binary Tree = Absolute Difference between leftSum - rightSum.
    t += Math.abs(leftTilt - rightTilt);
    
    return totalTilt;
  }

  public static boolean isBalance;

  public static int balanced(Node node)
  {
    if(node == null)
      return 0;

    int leftBalancedHeight = balanced(node.left);
    int rightBalancedHeight = balanced(node.right);

    int gapOrTilt = Math.abs(leftBalancedHeight - rightBalancedHeight);
    
    // ! Unbalanced means when Two Single Child Nodes are Present at Once.
    if(gapOrTilt > 1)
      isBalance = false;
    else
      isBalance = true;

    int totalBalancedHeight = Math.max(leftBalancedHeight, rightBalancedHeight) + 1;
    return totalBalancedHeight;
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
    System.out.println("Height/Maximum Depth of Binary Tree: " + heightOrMaxDepth(root));
    System.out.println("Diameter of a Binary Tree: " + diameter(root));
    System.out.println("Tilt of a Binary Tree: " + tilt(root));
    balanced(root);
    System.out.println("Is Binary Tree Balanced  or Not: " + isBalance);
    System.out.print("Enter the Value to be found: ");
    int item = scn.nextInt();
    System.out.println("Value/Item is Present in Binary Tree or not: " + find(root, item));
  }
}
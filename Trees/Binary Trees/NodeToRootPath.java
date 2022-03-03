import java.util.*;

public class NodeToRootPath
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

  public static ArrayList<Integer> nodeToRootPath(Node node, int data)
  {
    if(node == null) 
      return new ArrayList<>();

    if(node.data == data) 
    {
      ArrayList< Integer> list = new ArrayList<>();
      list.add(node.data);
      return list;
    }

    ArrayList<Integer> leftList = nodeToRootPath(node.left, data);
    if(leftList.size() > 0) 
    {
      leftList.add(node.data);
      return leftList;
    }

    ArrayList< Integer> rightList = nodeToRootPath(node.right, data);
    if(rightList.size() > 0) 
    {
      rightList.add(node.data);
      return rightList;
    }

    return new ArrayList<>();
  }

  public static ArrayList<Integer> path = new ArrayList<>();;

  public static boolean findPlusNodeToRootPath(Node node, int data)
  {
    if(node == null)
      return false;

    if(node.data == data)
    {
      path.add(node.data);
      return true;
    }

    boolean foundInLeftChild = findPlusNodeToRootPath(node.left, data);
    if(foundInLeftChild)
    {
      path.add(node.data);
      return true;
    }

    boolean foundInRightChild = findPlusNodeToRootPath(node.right, data);
    if(foundInRightChild)
    {
      path.add(node.data);
      return true;
    }

    return false;
  }

  public static void main(String[] args)
  {
    System.out.println();
    int[] arr = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1}; 
    
    Node root = createTree(arr);
    System.out.print("Enter a Value: ");
    int item = scn.nextInt();

    // boolean res = find(root, item);
    // System.out.println("Whether the Item is Present in Tree or Not: " + res);
    // System.out.print("Path from Node to Root: ");
    // ArrayList<Integer> ans = nodeToRootPath(root, item);
    // for(int i : ans)
    //   System.out.print(i + " ");
    // System.out.println(); 

    boolean ans = findPlusNodeToRootPath(root, item);
    System.out.println("If the Data/Item is found or not: " + ans);
    System.out.print("Path from Node to Root: ");
    System.out.print(path + " ");
    System.out.println();
  }
}
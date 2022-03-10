import java.util.*;

public class AddRemoveNodeInBST
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

  public static Node addNode(Node node, int data)
  {
    if(node == null)
      return new Node(data, null, null);

    if(data < node.data)
    {
      node.left = addNode(node.left, data);
      return node;
    }  
    else if(data > node.data)
    {
      node.right = addNode(node.right, data);
      return node;
    }
    else
      return node;   
  }
  
  public static int max(Node node)
  {
    if(node.right == null)
      return node.data;
    else
      return max(node.right);  
  }
  
  public static Node removeNode(Node node, int data)
  {
    if(node == null) 
      return null;

    if(data > node.data) 
    {
      node.right = removeNode(node.right, data);
      return node;
    } 
    else if(data < node.data) 
    {
      node.left = removeNode(node.left, data);
      return node;
    } 
    else 
    {
      if(node.left == null && node.right == null) 
        return null;
      else if(node.left == null) 
        return node.right;
      else if(node.right == null) 
        return node.left;
      else 
      {
        int max = max(node.left);
        node.data = max;
        node.left = removeNode(node.left, max);
        return node;
      }
    }
  }

  public static void main(String[] args)
  {
    System.out.println();
    
    Node root = BST();
    System.out.print("Enter a Value for New Node: ");
    int data = scn.nextInt();
    System.out.println("Binary Search Tree after Adding New Node: ");
    addNode(root, data);
    System.out.println(root);
    System.out.print("Enter a Value to Remove a Node: ");
    int item = scn.nextInt();
    System.out.println("Binary Search Tree after Removing a Node: ");
    removeNode(root, item);
    System.out.println(root);
  }
}
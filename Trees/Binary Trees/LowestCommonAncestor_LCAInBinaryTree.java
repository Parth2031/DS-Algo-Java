import java.util.*;

public class LowestCommonAncestor_LCAInBinaryTree
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

  public static ArrayList<Node> rootToNodePath(Node node, int data)
  {
    if(node == null)
    {
      ArrayList<Node> base = new ArrayList<>();
      return base;                                 
    }
 
    if(node.data == data)
    {
      ArrayList<Node> ans = new ArrayList<>();
      ans.add(node);
      return ans; 
    }

    ArrayList<Node> left = rootToNodePath(node.left,data);
    if(left.size() != 0)                                         
    {
      left.add(node);
      return left;
    }

    ArrayList<Node> right = rootToNodePath(node.right,data);
    if(right.size() != 0)
    {
      right.add(node);
      return right;
    }

    return new ArrayList<>();  
  }

  public static int LCA(Node node, int data_1, int data_2)
  {
    if(node == null)
      return 0;

    ArrayList<Node> list_1 = rootToNodePath(node, data_1);
    ArrayList<Node> list_2 = rootToNodePath(node, data_2);

    int ans = -1;
    int i = list_1.size() - 1;
    int j = list_2.size() - 1;

    while(i >= 0 && j >= 0)
    {
      if(list_1.get(i) != list_2.get(j))
        break;

      ans = list_1.get(i).data;
      i--;
      j--;   
    }

    return ans;  
  }
  
  public static void main(String[] args)
  {
    System.out.println();
    int[] arr = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1};
    
    Node root = createTree(arr);
    System.out.print("Enter the Value of Left Node: ");
    int left = scn.nextInt();
    System.out.print("Enter the Value of Right Node: ");
    int right = scn.nextInt();
    System.out.println("Lowest Common Ancestor in Binary Tree: " + LCA(root, left, right));
  }
}
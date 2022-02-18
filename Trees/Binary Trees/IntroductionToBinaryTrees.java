// ^ Binary Tree Default Working :-

// ? There are 3 Types of Orders - 
// & PreOrder : Root->Left->Right
// & InOrder : Left->Root->Right
// & PostOrder : Left->Right->Root 
// ~ In which, Tree is created by Deafult in PreOrder.

// ! "-1" refers to Null Value in either Left or Right Sise of Tree. 


import java.util.*;

public class IntroductionToBinaryTrees
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

  public static void display(Node node)
  {
    if(node == null)
      return;

    System.out.print(node.left != null ? node.left.data:".");
    System.out.print(" -> " + node.data + " <- ");
    System.out.println(node.right != null ? node.right.data:".");
                                             
    display(node.left);      // ! Display in terms of Index:  display(2*idx+1);   <-- Avoided for saving space.
    display(node.right);     // & Display in terms of Index:  display(2*idx+2);   <-- Avoided for saving space.
  }   
  
  static int idx = 0;

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

  // ! Using ArrayList :-
  
  // public static Node createTree(ArrayList<Integer> arr)
  // {
  //   if(idx == arr.size() || arr.get(idx) == -1)
  //   {
  //     idx++;
  //     return null;
  //   }
  
  //   Node node = new Node(arr.get(idx));
  //   idx++;

  //   node.left = createTree(arr);
  //   node.right = createTree(arr);

  //   return node;
  // }

    

  public static void main(String[] args)
  {
    System.out.println();
    
    int[] arr = {10,20,30,40,-1,-1,50,-1,-1,60,-1,70,-1,-1,80,90,100,120,-1,-1,130,-1,-1,110,-1,-1,140,-1,-1};

    // System.out.print("Enter the size for Binary Tree: ");
    // int n = scn.nextInt();
    // System.out.print("Enter the Values for Binary Tree: ");
    // ArrayList<Integer> arr = new ArrayList<>();
    // for(int i = 0; i < n; i++)
    //   arr.add(scn.nextInt());
    
    Node root = createTree(arr);
    System.out.println("Binary Tree in PreOrder: ");
    System.out.print(root);

    // System.out.println();
    // System.out.println("Binary Tree using Display: ");
    // display(root);
  }
}
import java.util.*;

public class ReverseLinkedList
{
  public static Scanner scn = new Scanner(System.in);

  public static class LinkedList 
  {
    private class Node
    {
      int data;
      Node next;
       
      public Node() {

      }
    }
    
    private Node head;
    private Node tail;
    private int size;

    public int size() {
      return size;
    }

    Node getNodeAt(int idx)
    {
      if(idx < 0 || idx >= size)
      {
        System.out.println("Invalid Index");
        return null;
      }
      if(size == 0)
      {
        System.out.println("LinkedList is Empty");
        return null;
      }
      Node temp = head;
      for(int i = 1; i <= idx; i++)
        temp = temp.next;
      return temp;  
    }
    
    public void display()
    {
      for(Node temp = head; temp != null; temp = temp.next)
        System.out.print(temp.data + " ");
      System.out.println();
    }

    public void addLast(int val)
    {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if(size == 0)
        head = tail = temp;
      else 
      {
        tail.next = temp;
        tail = temp;
      }
      size++;
    }
    
    public void ReverseLL_DataIterative()
    {
      int start = 0;
      int end = size - 1;

      while(start < end)
      {
        Node left = getNodeAt(start);
        Node right = getNodeAt(end);

        int temp = left.data;
        left.data = right.data;
        right.data = temp;

        start++;
        end--;
      }
    }

    // ! In this, We are making Pointers from tail to head and So, after Swapping tail becomes head and vice versa.  

    public void ReverseLL_PointerIterative()
    {
      Node prev = null;
      Node curr = head;

      while(curr != null)
      {
        Node ahead = curr.next;
        curr.next = prev;
        prev = curr;
        curr = ahead;
      }

      Node temp = head;
      head = tail;
      tail = temp;
    }

    public void ReverseLL_Recursive()
    {
      
    }

    public void ReverseLL_PointerRecursive()
    {
      
    }
  }
  
  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Linked List: ");
    int n = scn.nextInt();
    LinkedList list = new LinkedList();
    System.out.print("Enter the Values for Linked List: ");
    for (int i = 0; i < n; i++)
      list.addLast(scn.nextInt());
    
    System.out.print("Reversed Linked List by Data Iterative: ");
    list.ReverseLL_DataIterative();
    list.display();

    System.out.print("Reversed Linked List by Pointer Iterative: ");
    list.ReverseLL_PointerIterative();
    list.display();

    // System.out.print("Reversed Linked List by Recursive: ");
    // list.ReverseLL_DataIterative();
    // list.display();

    // System.out.print("Reversed Linked List by Pointer Recursive: ");
    // list.ReverseLL_DataIterative();
    // list.display();
  }
}
import java.util.*;

public class KthNodeFromEndOfLL
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

    public void display()
    {
      for(Node temp = head; temp != null; temp = temp.next)
        System.out.print(temp.data + " ");
      System.out.println();  
    }
    
    private Node getNodeAt(int idx)
    {
      if(size == 0)
      {
        System.out.println("LinkedList is Empty");
        return null;
      }
      if(idx < 0 || idx >= size)
      {
        System.out.println("Invalid Index");
        return null;
      }
      Node temp = head;
      for(int i = 1; i <= idx; i++)
        temp = temp.next;
      return temp;  
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

    public int KthNodeAtEndOfLL(int k)
    {
      Node node = getNodeAt(k);
      return node.data;
    }
    
    public int KthNodeAtEnd_Alternative(int k)
    {
      Node slow = head;
      

      return slow.data;
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
    System.out.print("Enter the Kth Index: ");
    int k = scn.nextInt();

    System.out.print("Kth Node From End of Linked List (Alternative): " + list.KthNodeAtEnd_Alternative(k));

    list.ReverseLL_PointerIterative();
    System.out.print("Kth Node From End of Linked List: " + list.KthNodeAtEndOfLL(k));

    System.out.println();
  }
}
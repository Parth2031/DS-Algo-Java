import java.util.*;

public class MidPointInLL
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
  
    public void display()
    {
      for(Node temp = head; temp != null; temp = temp.next)
        System.out.print(temp.data + " ");
      System.out.println();  
    }

    public int MidPointofLinkedList()
    {
      Node slow = head;
      Node fast = head;

      while(fast != null && fast.next != null)
      {
        slow = slow.next;                          // ! 1x Speed
        fast = fast.next.next;                     // ! 2x Speed
      }
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
    // list.display();
    System.out.println("Mid Point Value of Linked List: " + list.MidPointofLinkedList());
  }
}
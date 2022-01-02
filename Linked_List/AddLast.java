import java.util.*;

public class AddLast
{
  public static Scanner scn = new Scanner(System.in);
  
  public static class LinkedList
  {
    private class Node 
    {
      int data;
      Node next;

      public Node(int data) {
        this.data = data;
      }

      public Node() {

      }
    }
    
    private Node head;                  // ! Pointer
    private Node tail;                  // ! Pointer
    private int size;
    
    public boolean isEmpty() {
      return size == 0;
    }

    public int size() {
      return size;
    }

    public void display() 
    {
      for (Node temp = head; temp != null; temp = temp.next)
        System.out.print(temp.data + " ");
      System.out.println();
    }

    void addLast(int val) 
    {
      Node temp = new Node();                  
      temp.data = val;
      temp.next = null;

      // Node AlternativeTemp = new Node(10);

      if (size == 0) 
        head = tail = temp; 
      else 
      {
        tail.next = temp;                                 // ! Joining the tail with New Node temp
        tail = temp;                                      // ! Updating the tail on the Current Node 
      }

      size++;
    }
  }

  public static void main(String[] args)
  {
    System.out.println();
    LinkedList list = new LinkedList();
    System.out.println("Size of linked List: " + list.size()); 
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.display();
    System.out.println("Size of linked List: " + list.size());
  }
}
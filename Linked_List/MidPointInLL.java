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

    void addlast(int val)
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
    LinkedList list = new LinkedList();
    list.addlast(10);
    list.addlast(20);
    list.addlast(30);
    list.addlast(40);
    list.addlast(50);
    list.addlast(60);
    list.addlast(70);
    list.display();
    System.out.println("Mid Point of Linked List: " + list.MidPointofLinkedList());
  }
}
import java.util.*;

public class MergeLinkedList
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
    
    public void MergeTwoLinkedList()
    {
      
    }
  }
  
  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of 1st LinkedList: ");
    int n = scn.nextInt();
    LinkedList list_1 = new LinkedList();
    System.out.print("Enter the Values for 1st Linked List: ");
    for(int i = 0; i < n; i++)
      list_1.addLast(scn.nextInt());
    System.out.print("Enter the Size of 2nd LinkedList: ");
    int m = scn.nextInt();
    LinkedList list_2 = new LinkedList();
    System.out.print("Enter the Values for 2nd Linked List: ");
    for (int i = 0; i < m; i++)
      list_2.addLast(scn.nextInt());

  }
}
import java.util.*;

public class RemoveDuplicatesInLL
{
  public static Scanner scn = new Scanner(System.in);

  public static class LinkedList
  {
    private class Node
    {
      int data;
      Node next;

      public Node(){
        
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
    
    public int getFirst()
    {
      if (size == 0)
      {
        System.out.println("LinkedList is Empty");
        return -1;
      }
      else  
        return head.data;
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
    
    public void removeFirst()
    {
      if(size == 0)
        System.out.println("LinkedList is Empty");
      else if(size == 1)
      {
        head = tail = null;
        size = 0;
      }
      else
      {
        head = head.next;
        size--;
      }
    }

    public void Sort()
    {
      for(Node curr = head; curr != null; curr = curr.next)
      {
        for(Node ahead = curr; ahead != null; ahead = ahead.next)
        {
          if(curr.data > ahead.data)
          {
            int temp = curr.data;
            curr.data = ahead.data;
            ahead.data = temp;
          }
        }
      }
    }
    
    public void RemoveDuplicates(LinkedList ll)
    { 
      LinkedList res = new LinkedList();

      while (ll.size() > 0) 
      {
        int val = ll.getFirst();
        ll.removeFirst();

        if (res.size() == 0 || val != res.tail.data) 
          res.addLast(val);
      }

      ll.head = res.head;
      ll.tail = res.tail;
      ll.size = res.size;
      
      res.display();
    }
    
    // ! So, "this" works as Original LinkedList.

    public void removeDuplicates_usingThis() 
    {
      LinkedList res = new LinkedList();

      while(this.size() > 0) 
      {
        int val = this.getFirst();
        this.removeFirst();

        if (res.size() == 0 || val != res.tail.data)
          res.addLast(val);
      }

      // ! Using this concept, We are Setting up Original Now as Result LinkedList for list.display()
      this.head = res.head;
      this.tail = res.tail;
      this.size = res.size;

      // ^ Above Code, Alternative to this ->>
      // res.display();
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
    System.out.print("Sorted Linked List: ");
    list.Sort();
    list.display();
    System.out.print("Linked List Without Duplicate Values using This Approach: ");
    list.removeDuplicates_usingThis();
    list.display();
    System.out.print("Linked List Without Duplicate Values: ");
    LinkedList ans = new LinkedList();
    ans.RemoveDuplicates(list);
  }
}
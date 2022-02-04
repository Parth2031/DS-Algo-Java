// ^ Question Explanation :--
// The function is expected to tweak the list such that all groups of k elements in the list get reversed and linked.
// If the last set has less than k elements,leave it as it is(don't reverse).
// * Example : {1 2 3 4 5 6 7 8 9 10 11} with (k = 3) --> {3 2 1 6 5 4 9 8 7 10 11}

import java.util.*;

public class KReverseInLL
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
    
    public int getFirst()
    {
      if(size == 0)
      {
        System.out.println("LinkedList is Empty");
        return -1;
      }
      else  
        return head.data;  
    }
    
    public void addFirst(int val) 
    {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0)
        head = tail = temp;
      else 
      {
        temp.next = head;
        head = temp;
      }
      size++;
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
    
    public void KReverseLL(int k)
    {
      LinkedList prev = null;

      while(this.size > 0)
      {
        LinkedList curr = new LinkedList();
        
        if(this.size >= k)                              // ! For Reversing Values
        {
          for(int i = 0; i < k; i++)
          {
            int val = this.getFirst();
            this.removeFirst();
            curr.addFirst(val);
          }
        }
        else                                           // ! For Not Reversing Values
        {
          int originalSize = this.size;
          for (int i = 0; i < originalSize; i++) 
          {
            int val = this.getFirst();
            this.removeFirst();
            curr.addLast(val);
          }
        } 
      
        if(prev == null)
          prev = curr;
        else 
        {
          prev.tail.next = curr.head;
          prev.tail = curr.tail;
          prev.size += curr.size;
        } 
      }   
      
      this.head = prev.head;
      this.tail = prev.tail;
      this.size = prev.size; 
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
    System.out.print("Linked List with K Reverse: ");
    list.KReverseLL(k);
    list.display();
  }
}
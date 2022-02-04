// ^ In this Program, We have to separate Odd and Even Values and then Merge them Starting From Odd an End with Even Values.
// * We have to Retain their Order Values
// & Example : From {2 3 8 1 5 4 9} ---> To {3 1 5 9 2 8 4} 

import java.util.*;

public class OddEvenInLL
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

      if(size == 0)
        head = tail = temp;
      else 
      {
        temp.next = head;
        temp = head;
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
    
    public void OddEvenLL()
    {
      LinkedList odd = new LinkedList();
      LinkedList even = new LinkedList();
      
      while(this.size() > 0)
      {
        int val = this.getFirst();
        this.removeFirst();

        if(val % 2 == 0)
          even.addLast(val);
        else
          odd.addLast(val); 
      }
      
      if(odd.size > 0 && even.size > 0) 
      {
        odd.tail.next = even.head;
        this.head = odd.head;
        this.tail = even.tail;
        this.size = odd.size + even.size;
      } 
      else if(odd.size > 0) 
      {
        this.head = odd.head;
        this.tail = odd.tail;
        this.size = odd.size;
      }
      else if(even.size > 0)
      {
        this.head = even.head;
        this.tail = even.tail;
        this.size = even.size; 
      }
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
    System.out.print("Linked List starting with Odd Values and end with Even Values: ");
    list.OddEvenLL();
    list.display();
  }
}
import java.util.*;

public class CheckPalindromeInLL
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
      for (Node temp = head; temp != null; temp = temp.next)
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
    
    public boolean IsPalindromeLLHelper(Node right)
    {
      if(right == null)
        return true;

      boolean recAns = IsPalindromeLLHelper(right.next);

      if(recAns == false)
        return false;
      else if (left.data != right.data)
        return false;
      left = left.next;
      return true;
    }

    // ! Data Member on Heap
    Node left;
    
    public boolean IsPalindromeLL()
    {
      left = head;
      return IsPalindromeLLHelper(head);      
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
    System.out.println("Is Linked List is Palindrome or Not: " + list.IsPalindromeLL());    
  }
}
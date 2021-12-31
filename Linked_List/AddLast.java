import java.util.*;

public class AddLast
{
  public static Scanner scn = new Scanner(System.in);
 
  public static class Node
  {
    int data;
    Node next;
  }
  
  public static class LinkedList
  {
    Node head;
    Node tail;
    int size;

    void addLast(int val) 
    {
      Node temp = new Node();                  
      temp.data = val;
      temp.next = null;

      if (size == 0) 
        head = tail = temp; 
      else 
      {
        tail.next = temp;                                 // ! temp = Pointing at New Node
        tail = temp;
      }

      size++;
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
  }

  // public static void testList(LinkedList list) 
  // {
  //   for (Node temp = list.head; temp != null; temp = temp.next) 
  //     System.out.println(temp.data);
  //   System.out.println(list.size);

  //   if (list.size > 0) 
  //     System.out.println(list.tail.data);
  // }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Value: ");
    int val = scn.nextInt();
    LinkedList list = new LinkedList();
    list.addLast(val);
    list.display();
  }
}
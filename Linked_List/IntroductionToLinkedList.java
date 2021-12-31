// ^ Linked List Working :-

// & Linked List is Dynamic Array where it stores data of itself and address of the next element. 
// * Syntax :-- LinkedList<Data_Type> ll = new LinkedList<>();

// ? Linked List Node Working - 
// public static class LinkedList {
//     Node head;          // ~ head of the list
//     Node tail;          // ~ tail of the list
//     int size;

//     /* Linked list Node*/
//     public static class Node {
//         int data;
//         Node next;

// ~      Constructor to create a new node
// ~      Next is by default initialized as null
//         Node(int d) { data = d; }
//     }
// }
// * LinkedList ll = new LinkedList();
//   ll.head = new Node(index); 

// ! Linked List Built-In Functions :

// ? .add(int index, E element/O object);                        [.addFirst() & .addLast()]
// * Syntax :--> ll.add(1, "Parth");   OR   ll.add("Parth");
// ? .remove(int index); OR .remove(O object);                   [.removeFirst() & .removeLast()]
// * Syntax :--> ll.remove(1);   OR   ll.remove("Parth");
// ? .get(index);                                              -->> Index starts from 0 to n-1.
// ? .set(index, E element);

import java.util.*;

public class IntroductionToLinkedList {
  public static Scanner scn = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println();

    LinkedList<String> ll = new LinkedList<>();
    ll.add(scn.next());
    ll.add("B");
    ll.addLast("C");
    ll.addFirst("D");
    ll.add(2, "E");

    System.out.println(ll);
    System.out.println(ll.get(0));

    ll.remove("B");
    ll.remove(3);
    ll.removeFirst();
    ll.removeLast();

    System.out.println(ll);

    ll.set(0, "B");
    System.out.println(ll);
  }
}
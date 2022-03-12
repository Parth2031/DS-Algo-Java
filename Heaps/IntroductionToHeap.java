// ^ Heap Working :-

// & It works using Priority Queue.
// ? Priorty Queue chooses Peek Value as either Smaller Value High Priority or Largest Value High Priority in Priorty Queue.
// ~ By Default - It has Smaller Value as High Priority.
// * Syntax -> PriorityQueue<Data_Type> pq = new PriorityQueue<>();
// ! In Order to have Higher Value as Higher Priority, then -
// * Syntax -> PriorityQueue<Data_Type> pq = new PriorityQueue<>(Collections.reverseOrder());

// Todo:: Functions which are common are ->>

// ? .add()
// ? .remove()
// ? .peek()
// ? .size()

import java.util.*;

public class IntroductionToHeap
{
  public static Scanner scn = new Scanner(System.in);

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Size of Array: ");
    int n = scn.nextInt();
    int[] arr = new int[n];
    System.out.print("Enter the Array: ");
    for(int i= 0; i < n; i++)
      arr[i] = scn.nextInt();
      
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    PriorityQueue<Integer> pq_HigherValue = new PriorityQueue<>(Collections.reverseOrder());

    for(int val : arr)
    {
      pq.add(val);
      pq_HigherValue.add(val);
    } 
    
    System.out.print("Heap Sort Array in Ascending Order: ");  
    while(pq.size() > 0)
    {
      System.out.print(pq.peek() + " ");
      pq.remove();
    }
    System.out.println();

    System.out.print("Heap Sort Array in Descending Order: ");
    while(pq_HigherValue.size() > 0)
    {
      System.out.print(pq_HigherValue.peek() + " ");
      pq_HigherValue.remove();
    }
    System.out.println();
  }
}
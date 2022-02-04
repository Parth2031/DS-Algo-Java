import java.util.*;

public class OddEvenNumberPrint
{
  public static Scanner scn = new Scanner(System.in);

  public static void OddEvenPrint(int n)
  {
    if(n == 0)
      return;
    if(n % 2 == 0)
    {
      OddEvenPrint(n-1);
      System.out.print(n);
      System.out.println();
    }
    else 
    {
      System.out.print(n);
      System.out.println();
      OddEvenPrint(n-1); 
    }  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Ending Number: ");
    int n = scn.nextInt();
    System.out.println("Odd Number and then Even Number Print: "); 
    OddEvenPrint(n);
  }
}
import java.util.*;

public class ReverseNumber
{
  public static Scanner scn = new Scanner(System.in);

  public static int ReversedNumber(int n)
  {
    int revNum = 0;
    while(n>0 || n!=0)
    {
      revNum = (revNum * 10) + (n % 10);
      n = n / 10;
    }
    return revNum;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    System.out.println("Reversed Number: " + ReversedNumber(n)); 
  }
}
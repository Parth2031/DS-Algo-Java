import java.util.*;

public class ReverseNumber
{
  public static Scanner scn = new Scanner(System.in);

  public static int reverseNumber(int n)
  {
    int rev = 0;

    while(n != 0)
    {
      rev = (rev * 10) + n % 10;
      n = n / 10;
    }

    return rev;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    System.out.println("Reverse Number: " + reverseNumber(n));
  }
}
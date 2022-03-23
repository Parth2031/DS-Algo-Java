// ^ Digital Root of a Number is the Repeated Sum of Digits until there is only One Digit is Left.

import java.util.*;

public class DigitalRoot
{
  public static Scanner scn = new Scanner(System.in);

  public static int digitalRoot(int n)
  {
    int root = 0;

    while(n > 0 || root > 9)
    {
      if(n == 0)
      {
        n = root;
        root = 0;
      }

      root += n % 10;
      n = n / 10;
    }
    
    return root;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    System.out.println("Digital Root of an Integer: " + digitalRoot(n));
  }
}
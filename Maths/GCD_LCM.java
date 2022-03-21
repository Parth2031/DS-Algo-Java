import java.util.*;

public class GCD_LCM
{
  public static Scanner scn = new Scanner(System.in);

  public static int gcd(int a, int b)
  {
    while(a != b)
    {
      if(a > b)
        a = a - b;
      else
        b = b - a;
    }
    
    return b;
  }

  public static int lcm(int a, int b, int gcd)
  {
    int res = (a * b) / gcd;
    return res;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter 1st Number: ");
    int a = scn.nextInt();
    System.out.print("Enter 2nd Number: ");
    int b = scn.nextInt();
    System.out.println("Highest/Greatest Common Divisor(HCF/GCD): " + gcd(a, b));
    int gcd = gcd(a, b);
    System.out.println("Lowest Common Mulitplier(LCM): " + lcm(a, b, gcd));
  }
}
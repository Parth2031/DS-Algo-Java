import java.util.Scanner;

public class CountNoOfDigits
{
  public static Scanner scn = new Scanner(System.in);

  public static int CountNumberOfDigits(int n)
  {
    int count=0;
    while(n!=0 || n>0)
    {
      n=n/10;
      count++;
    }
    return count;
  }

  public static void main(String[] args) 
  {
    System.out.println("Enter a Number: "); 
    int n = scn.nextInt();
    System.out.print("Number of Digits are: " + CountNumberOfDigits(n));
    System.out.println();
  }
}
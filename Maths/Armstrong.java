// Todo::        Armstrong of a number :-
// ? Example :-> 371 = (3*3*3)+(7*7*7)+(1*1*1)    
// *             where:    
// ^              (3*3*3)=27    
// ^              (7*7*7)=343    
// ^              (1*1*1)=1    
// *             So:    
// ^              27+343+1=371

import java.util.*;

public class Armstrong
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isArmstrong(int n)
  {
    int sum = 0;
    int originalNum = n;

    while(n != 0 || n < 0)
    {
      int r = n % 10;
      sum += (r * r * r);
      n = n / 10;
    }

    if(sum == originalNum)
      return true;
    else
      return false;  
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a Number: ");
    int n = scn.nextInt();
    System.out.println("Check Whether the Given Number is Armstrong or Not: " + isArmstrong(n));
  }
}
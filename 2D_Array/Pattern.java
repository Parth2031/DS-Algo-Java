// ^ 

// * Some abbreviation in Pattern Questions are: csp - Count of Spaces & nsp - Number of Spaces.
// &                                           : cst - Count of Stars  & nst - Number of Stars.

import java.util.*;

public class Pattern
{
  public static Scanner scn = new Scanner(System.in);

  public static void HalfPyramid(int n)                                 // ! Pattern - 1 (a)
  {
    if(n == 0)
      System.out.print(" ");

    int nst = 1; 
      
    for(int i = 1; i <= n; i++)
    {
      for(int cst = 1; cst <= nst; cst++)
        System.out.print("* ");

      System.out.println();
      nst++;
    }
  }
  
  public static void MirrorHalfPyramid(int n)                           // ! Pattern - 1 (b)
  {
    if(n == 0)
      System.out.print(" ");
    
    int nsp = n - 1;
    int nst = 1; 

    for(int i = 1; i <= n; i++)
    {
      for(int csp = 1; csp <= nsp; csp++)
        System.out.print(" ");
      for(int cst = 1; cst <= nst; cst++)
        System.out.print("*");

      System.out.println();
      nsp--;
      nst++;    
    }  
  }
  
  public static void Triangle(int n)                                       // ! Pattern - 2             
  {
    if(n == 0)
      System.out.print(" ");
    
    int nsp = n - 1;
    int nst = 1; 

    for(int i = 1; i <= n; i++)
    {
      for(int csp = 1; csp <= nsp; csp++)
        System.out.print(" ");
      for(int cst = 1; cst <= nst; cst++)
        System.out.print("* ");

      System.out.println();
      nsp--;
      nst++;    
    }  
  }
  
  public static void MegaDiamond(int n)                                    // ! Pattern - 3 (a)
  {
    if(n == 0)
      System.out.print(" ");

    int nsp = n - 1;
    int nst = 1;
    
    for(int i = 1; i <= n; i++)
    {
      for (int csp = 1; csp <= nsp; csp++)
        System.out.print(" ");
      for (int cst = 1; cst <= nst; cst++)
        System.out.print("* ");

      System.out.println();
      nsp--;
      nst++;
    }
    
    nsp = 1;
    nst = n - 1;

    for(int i = n; i > 0; i--)
    {
      for(int csp = 1; csp <= nsp; csp++)
        System.out.print(" ");
      for(int cst = 1; cst <= nst; cst++)
        System.out.print("* ");
        
      System.out.println();
      nst--;
      nsp++;  
    }
  }

  public static void DiamondWithoutSpaces(int n)                           // ! Pattern - 3 (b)
  {
    if(n == 0)
      System.out.print(" ");

    int nst = 1;
    int nsp = (n/2);

    for(int i = 1; i <= (n/2) + 1; i++)
    {
      for(int csp = 1; csp <= nsp; csp++)
        System.out.print(" ");
      for (int cst = 1; cst <= nst; cst++)
        System.out.print("*");
        
      System.out.println();
      nsp--;
      nst += 2; 
    }
    
    nsp = 1;
    
    for(int i = (n/2); i > 0; i--)
    {
      for(int csp = 1; csp <= nsp; csp++)
        System.out.print(" ");
      for(int cst = 1; cst <= (2*i)-1; cst++)                                    // * Note -> (2*i)-1
        System.out.print("*");

      System.out.println();
      nsp++;
    }
  }

  public static void DiamondWithSpaces(int n)                              // ! Pattern - 3 (c)
  {
    if(n == 0)
      System.out.print(" ");

  }
  
  public static void Pyramid(int n)                                          // ! Patterm - 4
  {
    if(n == 0)
      System.out.print(" ");

  }

  public static void PatternWithDiamondMissing(int n)                        // ! Pattern - 5
  {
    if(n == 0)
      System.out.print(" ");
 
  }
  
   











  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter the Number of Pattern: ");
    int n = scn.nextInt();                                                     
    HalfPyramid(n);                                                            // ! Pattern - 1 (a)
    MirrorHalfPyramid(n);                                                      // ! Pattern - 1 (b)
    Triangle(n);                                                               // ! Pattern - 2
    MegaDiamond(n);                                                            // ! Pattern - 3 (a)
    DiamondWithoutSpaces(n);                                                   // ! Pattern - 3 (b)
    DiamondWithSpaces(n);                                                      // ! Pattern - 3 (c)
    Pyramid(n);                                                                // ! Pattern - 4
    PatternWithDiamondMissing(n);                                              // ! Pattern - 5
    // CrossPattern(n);                                                           // ! Pattern - 6
    // HalfNumberPyramid(n);                                                      // ! Pattern - 7 (a)
    // NumberIncreasingPyramid(n);                                                // ! Pattern - 7 (b)
    // FibonacciPattern(n);                                                       // ! Pattern - 8
    // BinomialPattern(n);                                                        // ! Pattern - 9
    // NumberIncreasingDecreasingPyramid(n);                                      // ! Pattern - 10
    // NumberIncreasingDecreasingDiamond(n);                                      // ! Pattern - 11
  }
}

/* Output-1(a): Half Pyramid Shape
   *
   * *
   * * *
   * * * *
   * * * * *
*/

/* Output-1(b): Mirror Half Pyramid Shape
        *
       **
      ***
     ****
    ***** 
*/

/* Output-2: Triangle
       *
      * *
     * * *
    * * * *
   * * * * *   
*/

/* Output-3(a): Mega Diamond Shape
      *
     * *
    * * *   
   * * * *
  * * * * *
   * * * *
    * * *
     * *
      *
*/

/* Output-3(b): Diamond Shape Without Spaces
     *
    ***   
   *****
    ***
     *
*/

/* Output-3(c): Diamond Shape With Spaces
       *
     * * *   
   * * * * *
     * * *
       *
*/

/* Output-4: Pyramid
           *
         * * *
       * * * * *
     * * * * * * *
   * * * * * * * * * 
*/

/* Output-5: Pattern With Diamond Shape of Space
   *** *** 
   **   **
   *     *
   **   **
   *** ***
*/  

/* Output-6: Cross Shape
   *   *
    * * 
     *
    * *
   *   *
*/    

/* Output-7(a): Half Number Pyamid Shape
   1
   2  5    
   3  6  8
   4  7  9  10
*/  

/* Output-7(b): Number Increasing Half Pyamid 
   1
   2  3    
   4  5  6
   7  8  9  10
*/

/* Output-8: Fibonacci Pattern
   0
   1  1    
   2  3  5
   8  13 21 34
*/

/* Output-9: Binomial Pattern (Pascal Triangle concept) {Remember: This works on Combination of nCk=nC(n-k)}
   1                                       // ! {Important Formula: nCk+1 = [nCk*(n-k)]/{k+1}.}
   1 1
   1 2 1
   1 3 3 1
   1 4 6 4 1
   1 5 10 10 5 1
*/

/* Output-10: Number Increasing & Decreasing Pyramid (Use Double Space as space and Single Space for numbers)
          1
       2  3  2
    3  4  5  4  3
 4  5  6  7  6  5  4  
*/

/* Output-11: Number Increasing & Decreasing Diamond
       1
     2 3 2
   3 4 5 4 3
 4 5 6 7 6 5 4
   3 4 5 4 3
     2 3 2
       1 
*/

/* Output-12: V-Shape (Use Tab as Space)
   1           1
   1 2       2 1
   1 2 3   3 2 1
   1 2 3 4 3 2 1
*/
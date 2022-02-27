// ^ In this Question, Given string num representing a non-negative integer num, and an integer k, 
// &                   Print the smallest possible integer after removing k digits from num.
// * Example1 - Input = {1432219} with k = {3} & Output = {1219}.
// * Example2 - Input = {10200} with k = {3} & Output = {0}.

import java.util.*;

public class RemoveKDigits
{
  public static Scanner scn = new Scanner(System.in);

  public static String removeKDigits(String num, int k)
  {
    if(num.length() <= k) 
      return "0";

    Stack<Character> st = new Stack<>();
    
    for(int i = 0; i < num.length(); i++)
    {
      while(st.size() > 0 && k > 0 && st.peek() > num.charAt(i))
      {
        st.pop();
        k--;
      }
      st.push(num.charAt(i));
    }
    
    while(st.size() > 1 && k > 0)
    {
      st.pop();
      k--;
    }

    // ! Storing the Stack Value in a Character Array :->
    char ans[] = new char[st.size()];
    int i = ans.length - 1;
    while(i >= 0)
      ans[i--] = st.pop();
        
    // ! Removing Starting "0" :->
    int j = 0;
    while(j < ans.length-1 && ans[j] == '0')
      j++;

    return new String(ans, j, ans.length - j);
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String num = scn.next();
    System.out.print("Enter a K Digit: ");
    int k = scn.nextInt();
    System.out.println("Smallest Possible Integer after Removing K Digits: " + removeKDigits(num, k));
  }
}
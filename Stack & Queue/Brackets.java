//  ^ There are 2 Questions - Duplicate Brackets & Balanced Brackets.
// ? Balanced Brackets - 
// * Example - String = "{ [ ( a + b ) * ( c + d ) ] / e } ^ f" --> true

import java.util.*;

public class Brackets
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean DuplicateBrackets(String str)
  {
    Stack<Character> st = new Stack<>();
    for(int i = 0; i < str.length(); i++)
    {
      char ch = str.charAt(i);
      if(ch == ')')
      {
        if(st.peek() == '(')
          return true;
        else
        {
          while(st.peek() != '(')
            st.pop();
          st.pop();  
        }
      }
      else
        st.push(ch);
    }
    return false;
  }

  public static boolean handleClosing(Stack<Character> st, char corresopondingCharacter)
  {
    if(st.size() == 0)
      return false;
    else if(st.peek() != corresopondingCharacter)
      return false;
    else
    {
      st.pop();
      return true;
    }
  }

  public static boolean BalancedBrackets(String str)
  {
    Stack<Character> st = new Stack<>();

    for(int i = 0; i < str.length(); i++)
    {
      char ch = str.charAt(i);
      if(ch == '(' || ch == '{' || ch == '[' || ch == '<')
        st.push(ch);
      else if(ch == ')')
      {
        boolean val = handleClosing(st, '(');
        if(val == false)
          return false;
      }
      else if(ch == '}')
      {
        boolean val = handleClosing(st, '{');
        if(val == false)
          return false;
      }  
      else if(ch == ']')
      {
        boolean val = handleClosing(st, '[');
        if(val == false)
          return false;
      }   
      else if(ch == '>')
      {
        boolean val = handleClosing(st, '<');
        if(val == false)
          return false;
      }  
      else {}
    }
    
    if(st.size() == 0)
      return true;
    else
      return false;
  }
  
  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.nextLine();
    System.out.println("Does String has Duplicate Brackets with Different Values or Not: " + DuplicateBrackets(str));
    System.out.println("Does String has Balanced Brackets or Not: " + BalancedBrackets(str));
  }
}
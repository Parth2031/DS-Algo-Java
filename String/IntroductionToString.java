// Todo:: String Defined Functions and Conversion ---->> 

// ? String is Immutable in Java means we cannot directly change any value in Java.
// & Input a String till Space => String str.scn.next();
// ~ Input a String for Complete Line => String str = scn.nextLine();
// ^ String str = new String("any value");
// * Character Array to String -> String str = new String(arr);  where, char arr[].

// ! To Check a String is Empty or Not: str.isEmpty() OR str == null.

// Todo:: To Remove All Special Characters from String --> str.replaceAll("[^a-zA-Z0-9]", "")
// & To Remove Space from String --> str.split("\\s"); and then Add to Another String using For Loop.

// ! Difference between .equals and "==" :
// ? In .equals, we use it in Comparison, as it check address as well as character by character whereas, "==" only check address.
// * s1.equals(s2);

// ! Main Functions :

// ? .charAt(i) :- This Function is used to check every character of a string. 
// * Syntax :--> string_defined_variable.charAt(i) in a "i" loop. 
// ? .substring(starting index,ending index) :- This function is used to check a string from starting index to ending index. 
// ?                                            Where, it takes the starting index value but not ending index value.
// * Syntax :--> string_defined_variable.substring(0, 3); 
// ? .length() :- This Function will be used as loop iterator.

// & To Convert anything in String, we use Integer/Anything_Data_Type.toString() or String.valueOf().
// ^ Converting String Number into Integer Number using Integer.parseInt(str);

// ~ Important point:- In String, .charAt() is the method to perform Character Array usage of this str[].

// Todo:: Very Important ->> To Convert a Character Number into Integer Number, Like "0" to 0.
// *                Syntax - int val = ch - '0'; OR int num = str.charAt(i) - '0';

// ! To Sort a String using Character Array :

// char arr[] = str.toCharArray();
// Arrays.sort(arr);
// String sortedString = new String(arr);

// ! StringBuilder is used as "It is Mutable" :

// * StringBuilder sb = new StringBuilder(int size/String str);
// ? It is an empty String which is similar to String
// * sb.append(character);
//   sb.setCharAt(int index, character);                  // ! Used to Replace any value present in String using StringBuilder.
// * sb.insert(index, character);
// * sb.deleteCharAt(character);
// ~ To convert StringBuilder in String, sb.toString();  

// ^ To Convert a Whole String in Lower Case --> str = str.toLowerCase();

// ! To Check or Convert in UpperCase or LowerCase :
// Character.isUpperCase(ch);
// Character.toUpperCase(ch);
// Character.isLowerCase(ch);
// Character.toLowerCase(ch);
// Character.isDigit(ch);
// Character.isAlphabetic(ch);

import java.util.*;

public class IntroductionToString 
{
  public static Scanner scn = new Scanner(System.in);

  public static void display(String str) 
  {
    System.out.print(str.substring(0, str.length()));

    // ! To print a Character and Append those in String:
    // for(int i=0;i<str.length();i++)
    // char ch = str.charAt(i); 
    // char ch = str[i];
    // str += ch;
  }

  public static void main(String[] args) 
  {
    // String str = "";
    System.out.println();
    System.out.print("Enter the string: ");
    // String str = scn.next();
    String str = scn.nextLine();
    display(str);
    System.out.println();
  }
}

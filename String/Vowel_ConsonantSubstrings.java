// ^ In this Question, We have to Count Number of Substrings which Starts with Vowel and ends with Consonants and Vice Versa.
// * Example 1 - Input = {aba} and Output = {2} because [a, ab, b, ba, aba] so, {ab, ba} are the Cases.
// & Example 2 - Input = {a} and Output = {0}.

import java.util.*;

public class Vowel_ConsonantSubstrings
{
  public static Scanner scn = new Scanner(System.in);

  public static boolean isVowel(char ch)
  {
    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
      return true;
    return false;  
  }
  

  public static int countVowel_ConsonantSubstring(String str)
  { 
    int vowels = 0;
    int consonants = 0;

    for(int i = 0; i < str.length(); i++) 
    {
      if (isVowel(str.charAt(i)))
        vowels++;
      else
        consonants++;
    }
    
    // ! It was Mentioned in Question to Return Count of Substring [% 10^9 + 7].
    return (vowels * consonants) % (1000000007);
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    int ans = countVowel_ConsonantSubstring(str);
    System.out.println("Count Number of Substrings Starting with Vowel and End with Consonant and Vice Versa: " + ans);
  }
}
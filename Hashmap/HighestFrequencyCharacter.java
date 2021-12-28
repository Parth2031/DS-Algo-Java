// ^ Highest Frequency Character - Character with Highest Frequency 
// ? Example - "abracadabra" has "a" with Highest Frequency.

import java.util.*;

public class HighestFrequencyCharacter
{
  public static Scanner scn = new Scanner(System.in);

  public static Character MaximumOccuringCharacter(String str)
  {    
    HashMap<Character, Integer> hm = new HashMap<>();
    for (int i = 0; i < str.length(); i++)
    {
      char ch = str.charAt(i);
      if (hm.containsKey(ch)) 
      {
        int old = hm.get(ch);
        int freq = old + 1;
        hm.put(ch, freq);
      } 
      else
        hm.put(ch, 1);
    }
    
    char max = str.charAt(0);
    for(Character key : hm.keySet())
    {
      if(hm.get(key) > hm.get(max))
        max = key;
    }

    return max;
  }

  public static void main(String[] args)
  {
    System.out.println();
    System.out.print("Enter a String: ");
    String str = scn.next();
    System.out.print("Character with Highest Frequency: " + MaximumOccuringCharacter(str));
    System.out.println();
  }
}
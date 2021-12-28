// & Hashmap Working and Functions :-->

// ^ Hashmap basically runs on O(1) and is used for Key-Value Pair which are not sorted.
// ? It is used on Table of Information.
// * Syntax -> HashMap<key_DataType, value_DataType> hm = new HashMap<>();

// ! Hashmap Built-In Functions ->

// ? .put(key, value) - Insert a new Key-Value Pair.
// * Syntax - hm.put("key", value);
// ? .get(key) - Returns the Value of key if no value to key, then it will return Null Value.
// ? .containsKey(key) - Returns true if Key is present else false.
// ? .remove(key)
// ~ .keySet() - Used to Iterate through Loop

import java.util.*;

public class IntroductionToHashmap 
{
  public static void main(String[] args) 
  {
    HashMap<String, Integer> hm = new HashMap<>();

    hm.put("India", 1391);
    hm.put("China", 1398);
    hm.put("USA", 329);
    hm.put("Indonesia", 268);

    // ! Using keySet() to Iterate through the Hashmap
    
    for (String key : hm.keySet())
    {
      Integer val = hm.get(key);
      System.out.print(key + ":" + val + "  ");
    }
  }
}

// https://leetcode.com/problems/isomorphic-strings/

// For Solution 1, Solution 2, Solution 3 
// Time complexity: O(N) where N represents the number of words in the s or the number of characters in the pattern.
// Space complexity: O(M) where M is the number of unique characters in pattern and words in s.

// Solution 1: Single Index Hash Map
class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    HashMap<Character, Character> map = new HashMap();
    for (int i = 0; i < s.length(); i++) {
      char s_char = s.charAt(i);
      char t_char = t.charAt(i);

      if (map.containsKey(s_char)) {
        if (!map.get(s_char).equals(t_char)) {
          return false;
        }
      } else {
        if (map.containsValue(t_char)) {
          return false;
        }
        map.put(s_char, t_char);
      }
    }
    return true;
  }
}

// Solution 2: Two Hash Maps

class Solution {
   public boolean isIsomorphic(String s, String t) {
    if (t.length() != s.length()) {
      return false;
    }

    HashMap<Character, Character> sMap = new HashMap();
    HashMap<Character, Character> tMap = new HashMap();

    for (int i = 0; i < s.length(); i++) {
      char s_char = s.charAt(i);
      char t_char = t.charAt(i);

      if (!sMap.containsKey(s_char)) { // if (sMap.get(s_char) == null) {
        sMap.put(s_char, t_char);
      } else {
        if (!sMap.get(s_char).equals(t_char)) { // if (sMap.get(s_char) != t_char) {
          return false;
        }
      }

      // you can have separate for loops too for above and below if'ssss (one for s.length() and other for t.length())

      if (!tMap.containsKey(t_char)) { // if (tMap.get(t_char) == null) {
        tMap.put(t_char, s_char);
      } else {
        if (!tMap.get(t_char).equals(s_char)) { // if (tMap.get(t_char) != s_char) {
          return false;
        }
      }

    }
    return true;
  }
}

// Solution 3: Using 1 HashMap and 1 HashSet

class Solution {
   public boolean isIsomorphic(String s, String t) {
    if (t.length() != s.length()) {
      return false;
    }

    HashMap<Character, Character> map = new HashMap();
    HashSet<Character> set = new HashSet();

    for (int i = 0; i < s.length(); i++) {
      char s_char = s.charAt(i);
      char t_char = t.charAt(i);

      if (!map.containsKey(s_char)) {
        if (set.contains(t_char)) {
          return false;
        }
        map.put(s_char, t_char);
        set.add(t_char);
      } else {
        if (!map.get(s_char).equals(t_char)) { 
          return false;
        }
        set.add(t_char);
      }

    }
    return true;
  }
}

// Solution 4: Character Mapping with Dictionary

// Time Complexity: O(N). We process each character in both the strings exactly once to determine if the strings are isomorphic.
// Space Complexity: O(1) since the size of the ASCII character set is fixed and the keys in our dictionary are all 
// valid ASCII characters according to the problem statement.

class Solution {
    public boolean isIsomorphic(String s, String t) {
        
      int[] mappingDictStoT = new int[256];
      Arrays.fill(mappingDictStoT, -1);
      
      int[] mappingDictTtoS = new int[256];
      Arrays.fill(mappingDictTtoS, -1);
      
      for (int i = 0; i < s.length(); ++i) {
          char c1 = s.charAt(i);
          char c2 = t.charAt(i);
          
          // Case 1: No mapping exists in either of the dictionaries
          if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
              mappingDictStoT[c1] = c2;
              mappingDictTtoS[c2] = c1;
          }
          
          // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
          // it doesn't match in either of the dictionaries or both 
          else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
              return false;
          }
      }
      
      return true;
    }
}

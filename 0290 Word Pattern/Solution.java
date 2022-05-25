// https://leetcode.com/problems/word-pattern/

// Time complexity: O(N) where N represents the number of words in the s or the number of characters in the pattern.
// Space complexity: O(M) where M is the number of unique characters in pattern and words in s.

//for solution 2: Even though we have two hash maps, the character to word hash map has space complexity of O(1) since there can at most be 26 keys.

// Solution 1: Single Index Hash Map

class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }

    HashMap<Character, String> map = new HashMap();
    for (int i = 0; i < pattern.length(); i++) {
      char current_char = pattern.charAt(i);
      if (map.containsKey(current_char)) {
        if (!map.get(current_char).equals(words[i])) {
          return false;
        }
      } else {
        if (map.containsValue(words[i])) {
          return false;
        }
        map.put(current_char, words[i]);
      }
    }
    return true;
  }
}

// Solution 2: Two Hash Maps

class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] words = s.split(" ");
    if (words.length != pattern.length()) {
      return false;
    }

    HashMap<Character, String> pMap = new HashMap();
    HashMap<String, Character> sMap = new HashMap();

    for (int i = 0; i < pattern.length(); i++) {
      char current_char = pattern.charAt(i);

      if (!pMap.containsKey(current_char)) {
        pMap.put(current_char, words[i]);
      } else {
        if (!pMap.get(current_char).equals(words[i])) {
          return false;
        }
      }

      if (!sMap.containsKey(words[i])) {
        sMap.put(words[i], current_char);
      } else {
        if (!sMap.get(words[i]).equals(current_char)) {
          return false;
        }
      }

    }
    return true;
  }
}

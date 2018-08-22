package main.com.leetcode.problems.problem0290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean wordPattern(String pattern, String str) {
    if (pattern == null || str == null) {
      return false;
    }
    String[] words = str.split(" ");
    char[] chars = pattern.toCharArray();
    if (words.length != chars.length) {
      return false;
    }
    Map<Character, String> charToWord = new HashMap<>();
    Map<String, Character> wordToChar = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      char c = chars[i];
      String matchedWord = charToWord.get(c);
      Character matchedChar = wordToChar.get(word);
      if (matchedChar == null && matchedWord == null) {
        charToWord.put(c, word);
        wordToChar.put(word, c);
      }
      else if (matchedChar == null && matchedWord != null ||
               matchedChar != null && matchedWord == null) {
        return false;
      }
      else {
        if (!matchedWord.equals(word) || !matchedChar.equals(matchedChar)) {
          return false;
        }
      }
    }
    return true;
  }
}

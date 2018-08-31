package main.com.leetcode.problems.problem0890;

import java.util.*;

public class Solution {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> wordsMatchingPattern = new ArrayList<>();
    for (String word : words) {
      if (matchesPattern(word, pattern)) {
        wordsMatchingPattern.add(word);
      }
    }
    return wordsMatchingPattern;
  }

  private boolean matchesPattern(String word, String pattern) {
    if (word.length() != pattern.length()) {
      return false;
    }
    Map<Character, Character> wordLetterToPatternLetter = new HashMap<>();
    Set<Character> matchedPatternChars = new HashSet<>();
    for (int i = 0; i < word.length(); i++) {
      char wordChar = word.charAt(i);
      char patternChar = pattern.charAt(i);
      Character existingCharPattern = wordLetterToPatternLetter.get(wordChar);
      if (existingCharPattern == null) {
        if (matchedPatternChars.contains(patternChar)) {
          return false;
        }
        else {
          wordLetterToPatternLetter.put(wordChar, patternChar);
        }
      }
      else if (existingCharPattern != patternChar) {
          return false;
      }
      matchedPatternChars.add(patternChar);
    }
    return true;
  }
}

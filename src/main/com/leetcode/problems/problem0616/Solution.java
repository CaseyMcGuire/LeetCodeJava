package main.com.leetcode.problems.problem0616;

import java.util.*;

public class Solution {
  public String addBoldTag(String s, String[] dict) {
    Map<Character, List<String>> startingCharToWord = new HashMap<>();
    for (String str : dict) {
      List<String> words = startingCharToWord.getOrDefault(str.charAt(0), new ArrayList<>());
      words.add(str);
      startingCharToWord.put(str.charAt(0), words);
    }
    StringBuilder builder = new StringBuilder();
    int currentEndIndex = -1;
    for (int i = 0; i < s.length(); i++) {
      int endTagIndexForCurrentPlace = getEndTagIndex(s, i, startingCharToWord);
      if (i == currentEndIndex) {
        boolean hasAdjacentBoldTag = endTagIndexForCurrentPlace != -1;
        if (!hasAdjacentBoldTag) {
          builder.append("</b>");
          currentEndIndex = -1;
        }
      }

      if (endTagIndexForCurrentPlace > currentEndIndex) {
        if (currentEndIndex == -1) {
          builder.append("<b>");
        }
        currentEndIndex = endTagIndexForCurrentPlace;
      }
      builder.append(s.charAt(i));
    }
    if (currentEndIndex != -1) {
      builder.append("</b>");
    }
    return builder.toString();
  }

  private int getEndTagIndex(String s, int startIndex, Map<Character, List<String>> startingCharToWord) {
    if (startIndex >= s.length()) {
      return -1;
    }
    int longestEndIndex = -1;
    List<String> possibleSubstrings = startingCharToWord.getOrDefault(s.charAt(startIndex), Collections.emptyList());
    for (String possibleSubstring : possibleSubstrings) {
      if (possibleSubstring.length() + startIndex < longestEndIndex) {
        continue;
      }
      int currentEndIndex = getEndTagIndex(s, startIndex, possibleSubstring);
      longestEndIndex = currentEndIndex > longestEndIndex ? currentEndIndex : longestEndIndex;
    }
    return longestEndIndex;
  }

  private int getEndTagIndex(String s, int startIndex, String possibleSubstring) {
    for (int i = 0; i < possibleSubstring.length(); i++) {
      int sIndex = startIndex + i;
      if (sIndex == s.length()) {
        return -1;
      }
      if (s.charAt(sIndex) != possibleSubstring.charAt(i)) {
        return -1;
      }
    }
    return startIndex + possibleSubstring.length();
  }
}

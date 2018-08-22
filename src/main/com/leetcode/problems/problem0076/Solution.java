package main.com.leetcode.problems.problem0076;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public String minWindow(String s, String t) {
    Map<Character, List<Integer>> charToIndices = new HashMap<>();
    Map<Character, Integer> charToFrequency = new HashMap<>();
    for (char c : t.toCharArray()) {
      charToFrequency.merge(c, 1, (cur, iter) -> cur + iter);
    }

    for (int i = s.length() - 1; i >= 0; i--) {
      if (!charToFrequency.containsKey(s.charAt(i))) {
        continue;
      }
      List<Integer> indices = charToIndices.getOrDefault(s.charAt(i), new ArrayList<>());
      indices.add(i);
      charToIndices.put(s.charAt(i), indices);
    }
    String minimumSoFar = null;
    for (int i = 0; i < s.length(); i++) {
      if (!charToFrequency.containsKey(s.charAt(i))) {
        continue;
      }
      String minimumWindowSubstring = getMinimumWindowSubstring(s, i, charToIndices, charToFrequency);
      if (minimumWindowSubstring.isEmpty()) {
        if (minimumSoFar == null) {
          return "";
        }
        else {
          return minimumSoFar;
        }
      }
      if (minimumSoFar == null || minimumWindowSubstring.length() < minimumSoFar.length()) {
        minimumSoFar = minimumWindowSubstring;
      }
      List<Integer> indices = charToIndices.get(s.charAt(i));
      indices.remove(indices.size() - 1);
    }
    return minimumSoFar == null ? "" : minimumSoFar;
  }

  private String getMinimumWindowSubstring(String s, int index, Map<Character, List<Integer>> charToIndices, Map<Character, Integer> charToFrequency) {
    Integer rightIndex = null;
    for (Map.Entry<Character, Integer> entry : charToFrequency.entrySet()) {
      int frequency = entry.getValue();
      char c = entry.getKey();
      List<Integer> indices = charToIndices.get(c);
      if (indices == null || indices.size() < frequency) {
        return "";
      }
      int rightMostIndex = indices.get(indices.size() - frequency);
      if (rightIndex == null || rightMostIndex > rightIndex) {
        rightIndex = rightMostIndex;
      }
    }
    return s.substring(index, rightIndex + 1);
  }

}

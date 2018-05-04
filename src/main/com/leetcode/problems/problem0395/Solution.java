package main.com.leetcode.problems.problem0395;

import java.util.*;

public class Solution {
  public int longestSubstring(String s, int k) {
    return longestSubstring(s, 0, s.length() - 1, k);
  }

  private int longestSubstring(String s, int start, int end, int k) {
    int currentLength = end - start + 1;
    if (currentLength < k) {
      return 0;
    }
    Map<Character, Integer> characterToFrequency = new HashMap<>();
    for (int i = start; i <= end; i++) {
      characterToFrequency.merge(s.charAt(i), 1, (cur, iter) -> cur + iter);
    }

    Set<Character> infrequentChars = new HashSet<>();
    for (Map.Entry<Character, Integer> entry : characterToFrequency.entrySet()) {
      if (entry.getValue() < k) {
        infrequentChars.add(entry.getKey());
      }
    }
    if (infrequentChars.isEmpty()) {
      return currentLength;
    }

    //essentially, we want to search on any substrings that don't contain characters that appear less than k times
    List<StartEndPair> startEndPairs = new ArrayList<>();
    StartEndPair current = null;
    for (int i = start; i < currentLength + start; i++) {
      if (infrequentChars.contains(s.charAt(i))) {
        if (current != null) {
          current.end = i - 1;
          startEndPairs.add(current);
          current = null;
        }
      }
      else {
        if (current == null) {
          current = new StartEndPair(i);
        }
      }
    }
    if (current != null) {
      current.end = currentLength - 1;
      startEndPairs.add(current);
    }
    int max = 0;
    for (StartEndPair startEndPair : startEndPairs) {
      max = Math.max(max, longestSubstring(s, startEndPair.start, startEndPair.end, k));
    }
    return max;
  }

  private static class StartEndPair {
    int start;
    int end;

    StartEndPair(int start) {
      this.start = start;
    }
  }
}



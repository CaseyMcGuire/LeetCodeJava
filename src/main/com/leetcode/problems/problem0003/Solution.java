package main.com.leetcode.problems.problem0003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    int longestSubStringSoFar = 0;
    int runningSubstringLength = 0;
    Map<Character, Integer> charToIndex = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (charToIndex.containsKey(c)) {
        runningSubstringLength = 0;
        i = charToIndex.get(c);
        charToIndex = new HashMap<>();
      }
      else {
        runningSubstringLength++;
        charToIndex.put(c, i);
        if (runningSubstringLength > longestSubStringSoFar) {
          longestSubStringSoFar = runningSubstringLength;
        }
      }
    }
    return longestSubStringSoFar;
  }
}

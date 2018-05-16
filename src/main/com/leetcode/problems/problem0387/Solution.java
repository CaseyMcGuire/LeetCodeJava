package main.com.leetcode.problems.problem0387;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int firstUniqChar(String s) {
    Map<Character, Integer> charToFrequency = new HashMap<>();
    for (char c : s.toCharArray()) {
      charToFrequency.merge(c, 1, (cur, iter) -> cur + iter);
    }

    for (int i = 0; i < s.length(); i++) {
      int frequency = charToFrequency.get(s.charAt(i));
      if (frequency == 1) {
        return i;
      }
    }
    return -1;
  }
}

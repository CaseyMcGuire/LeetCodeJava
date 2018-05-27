package main.com.leetcode.problems.problem0266;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean canPermutePalindrome(String s) {
    if (s == null) {
      return false;
    }
    else if (s.isEmpty()) {
      return true;
    }
    Map<Character, Integer> charToFrequency = new HashMap<>();
    for (char c : s.toCharArray()) {
      charToFrequency.merge(c, 1, (current, iterate) -> current + iterate);
    }
    boolean canHaveOneOdd = s.length() % 2 == 1;
    for (Map.Entry<Character, Integer> entry : charToFrequency.entrySet()) {
      int num = entry.getValue();
      if (num % 2 == 1) {
        if (canHaveOneOdd) {
          canHaveOneOdd = false;
        }
        else {
          return false;
        }
      }
    }
    return true;
  }
}

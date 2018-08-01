package main.com.leetcode.problems.problem0392;

public class Solution {
  public boolean isSubsequence(String s, String t) {
    if (s.isEmpty()) {
      return true;
    }
    int subsequenceIndex = 0;
    for (char c : t.toCharArray()) {
      if (c == s.charAt(subsequenceIndex)) {
        subsequenceIndex++;
      }
      if (subsequenceIndex == s.length()) {
        return true;
      }
    }
    return false;
  }
}

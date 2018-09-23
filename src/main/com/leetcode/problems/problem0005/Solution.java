package main.com.leetcode.problems.problem0005;

public class Solution {
  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    for (int interval = s.length(); interval > 0; interval--) {
      for (int i = 0; i + interval <= s.length(); i++) {
        if (isPalindrome(s, i, interval + i)) {
          return s.substring(i, interval + i);
        }
      }
    }
    return null;
  }

  private boolean isPalindrome(String s, int start, int end) {
    for (int i = start, j = end - 1; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}

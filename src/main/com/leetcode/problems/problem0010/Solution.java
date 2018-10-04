package main.com.leetcode.problems.problem0010;

public class Solution {
  public boolean isMatch(String s, String p) {
    return isMatch(s, 0, p, 0, null);
  }

  private boolean isMatch(String s, int i, String p, int j, Character repeating) {
    if (s.length() == i) {
      if ((p.length() - j) % 2 != 0) {
        return false;
      }
      for (; j < p.length(); j += 2) {
        if (p.charAt(j + 1) != '*') {
          return false;
        }
      }
      return true;
    }
    if (repeating != null) {
      if (s.charAt(i) == repeating || repeating == '.') {

        boolean matches = isMatch(s, i + 1, p, j, repeating);
        if (matches) {
          return true;
        }
      }
    }
    if (j >= p.length()) {
      return false;
    }
    boolean isStar = j < p.length() - 1 && p.charAt(j + 1) == '*';
    if (isStar) {
      return isMatch(s, i, p, j + 2, p.charAt(j));
    }
    boolean matches = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    if (!matches) {
      return false;
    }
    else {
      return isMatch(s, i + 1, p, j + 1, null);
    }
  }
}

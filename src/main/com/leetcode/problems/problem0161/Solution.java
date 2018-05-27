package main.com.leetcode.problems.problem0161;

public class Solution {
  public boolean isOneEditDistance(String s, String t) {
    if (s.isEmpty() && t.isEmpty() || s.equals(t)) {
      return false;
    }
    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }
    if (s.length() == t.length()) {
      return isEqualExceptOne(s, t);
    }
    else {
      return canInsertOrRemoteToEqual(s, t);
    }
  }

  private boolean canInsertOrRemoteToEqual(String s, String t) {
    String shorter;
    String longer;
    if (s.length() > t.length()) {
      shorter = t;
      longer = s;
    }
    else {
      shorter = s;
      longer = t;
    }
    boolean foundUnequal = false;
    for (int i = 0, j = 0; i < shorter.length() && j < longer.length(); i++, j++) {
      if (shorter.charAt(i) != longer.charAt(j)) {
        if (!foundUnequal) {
          foundUnequal = true;
          i--;
        }
        else {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isEqualExceptOne(String s, String t) {
    boolean foundUnequal = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (!foundUnequal) {
          foundUnequal = true;
        }
        else {
          return false;
        }
      }
    }
    return true;
  }
}

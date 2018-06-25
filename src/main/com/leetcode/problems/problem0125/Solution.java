package main.com.leetcode.problems.problem0125;

public class Solution {
  public boolean isPalindrome(String s) {
    if (s == null) {
      return false;
    }
    if (s.trim().isEmpty()) {
      return true;
    }
    int i = getNextI(0, s);
    int j = getNextJ(s.length() - 1, s);
    while (i < j) {
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
      i = getNextI(i + 1, s);
      j = getNextJ(j - 1, s);
    }
    return true;
  }

  private int getNextI(int currentI, String s) {
    for (int i = currentI; i < s.length(); i++) {
      if (isAlphaNumeric(s.charAt(i))) {
        return i;
      }
    }
    return s.length();
  }

  private int getNextJ(int currentJ, String s) {
    for (int i = currentJ; i >= 0; i--) {
      if (isAlphaNumeric(s.charAt(i))) {
        return i;
      }
    }
    return -1;
  }

  private boolean isAlphaNumeric(char c) {
    return Character.isAlphabetic(c) || Character.isDigit(c);
  }
}

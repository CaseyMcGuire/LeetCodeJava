package main.com.leetcode.problems.problem0680;

public class Solution {
  public boolean validPalindrome(String s) {
    return validPalindrome(s, 0, s.length() - 1, false);
  }

  private boolean validPalindrome(String s, int i, int j, boolean deletedChar) {
    for (; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        if (deletedChar) {
          return false;
        }
        if (i + 1 == j) {
          return true;
        }
        if (validPalindrome(s, i + 1, j, true)) {
          return true;
        }
        else {
          return validPalindrome(s, i, j - 1, true);
        }
      }
    }
    return true;
  }

}

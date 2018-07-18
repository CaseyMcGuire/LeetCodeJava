package main.com.leetcode.problems.problem0028;

public class Solution {
  public int strStr(String haystack, String needle) {
    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (substringEquals(haystack, needle, i)) {
        return i;
      }
    }
    return -1;
  }

  private boolean substringEquals(String haystack, String needle, int startIndex) {
    for (int i = 0; i < needle.length(); i++) {
      if (haystack.charAt(i + startIndex) != needle.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}

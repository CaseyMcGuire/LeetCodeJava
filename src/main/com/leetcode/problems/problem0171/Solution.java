package main.com.leetcode.problems.problem0171;

public class Solution {
  public int titleToNumber(String s) {
    int columnNumber = 0;
    for (int i = 0; i < s.length(); i++) {
      int num = (s.charAt(s.length() - 1 - i)) - 64;
      columnNumber += (Math.pow(26, i) * num);
    }
    return columnNumber;
  }

}

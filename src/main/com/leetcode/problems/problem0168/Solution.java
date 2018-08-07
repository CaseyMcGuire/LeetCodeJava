package main.com.leetcode.problems.problem0168;

public class Solution {

  private static final int BASE = 26;

  public String convertToTitle(int n) {
    StringBuilder builder = new StringBuilder();
    while (n > 0) {
      n--;
      char curColumn = convertNumToExcelLetter(n % BASE);
      builder.append(curColumn);
      n = n / BASE;
    }
    return builder.reverse().toString();
  }

  private char convertNumToExcelLetter(int num) {
    return (char) (num + 'A');
  }
}

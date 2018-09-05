package main.com.leetcode.problems.problem0008;

public class Solution {
  public int myAtoi(String str) {
    if (str == null) {
      return 0;
    }
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }

    StringBuilder builder = new StringBuilder();
    boolean isNegative = str.charAt(0) == '-';
    boolean skipFirstChar = isNegative || str.charAt(0) == '+';
    if (isNegative) {
      builder.append('-');
    }
    for (int i = skipFirstChar ? 1 : 0; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
      builder.append(str.charAt(i));
    }
    String strNum = builder.toString();
    if (strNum.isEmpty() || strNum.length() == 1 && strNum.charAt(0) == '-') {
      return 0;
    }

    try {
      return Integer.parseInt(strNum);
    }
    catch (NumberFormatException e) {
      if (isNegative) {
        return Integer.MIN_VALUE;
      }
      else {
        return Integer.MAX_VALUE;
      }
    }
  }
}

package main.com.leetcode.problems.problem0065;

class Solution {
  public boolean isNumber(String s) {
    if (s == null) {
      return false;
    }
    s = s.trim();
    if (s.isEmpty()) {
      return false;
    }

    int startIndex = s.charAt(0) == '-' ? 1 : 0;
    if (startIndex == s.length()) {
      return false;
    }

    if (".".equals(s)) {
      return false;
    }

    if (s.startsWith(".")) {
      s = "0" + s;
    }
    boolean allowExponent = true;
    boolean allowDecimal = true;
    for (int i = startIndex; i < s.length(); i++) {
      boolean isExponent = s.charAt(i) == 'e';
      boolean isDecimal = s.charAt(i) == '.';
      boolean isNegative = s.charAt(i) == '-';
      if ((isExponent || isNegative) && (i == startIndex || i == s.length() - 1)) {
        return false;
      }
      else if (isExponent) {
        boolean isValidPlace = Character.isDigit(s.charAt(i - 1)) && (s.charAt(i + 1) == '-' || Character.isDigit(s.charAt(i + 1)));
        if (!allowExponent || !isValidPlace) {
          return false;
        }
        allowExponent = false;
        allowDecimal = false;
      }
      else if (isDecimal) {
        boolean isValidPlace = i == s.length() - 1 ||
            Character.isDigit(s.charAt(i - 1)) && Character.isDigit(s.charAt(i + 1));
        if (!allowDecimal || !isValidPlace) {
          return false;
        }
        allowDecimal = false;
      }
      else if (isNegative) {
        if (s.charAt(i - 1) != 'e' || !Character.isDigit(s.charAt(i + 1))) {
          return false;
        }
      }
      else if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}

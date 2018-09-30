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

    if (s.startsWith("-") || s.startsWith("+")) {
      s = s.substring(1, s.length());
    }
    if (s.startsWith(".e")) {
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
    for (int i = 0; i < s.length(); i++) {
      boolean isExponent = s.charAt(i) == 'e';
      boolean isDecimal = s.charAt(i) == '.';
      boolean isSign = s.charAt(i) == '-' || s.charAt(i) == '+';
      if ((isExponent || isSign) && (i == 0 || i == s.length() - 1)) {
        return false;
      }
      else if (isExponent) {

        if (!allowExponent || !isValidPlace(s, i)) {
          return false;
        }
        allowExponent = false;
        allowDecimal = false;
      }
      else if (isDecimal) {

        if (!allowDecimal || !isValidPlace(s, i)) {
          return false;
        }
        allowDecimal = false;
      }
      else if (isSign) {
        if (!isValidPlace(s, i)) {
          return false;
        }
      }
      else if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private boolean isValidPlace(String s, int i) {
    char c = s.charAt(i);
    if (c == 'e') {
      boolean validPreviousChar = s.charAt(i - 1) == '.' || Character.isDigit(s.charAt(i - 1));
      boolean validNextChar = s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+' || Character.isDigit(s.charAt(i + 1));
      return validPreviousChar && validNextChar;
    }
    else if (c == '.') {
      return i == s.length() - 1 || Character.isDigit(s.charAt(i - 1)) && (Character.isDigit(s.charAt(i + 1)) || s.charAt(i + 1) == 'e');
    }
    else if (c == '-' || c == '+') {
      return s.charAt(i - 1) == 'e' && Character.isDigit(s.charAt(i + 1));
    }
    return true;
  }
}
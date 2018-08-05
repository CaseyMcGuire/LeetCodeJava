package main.com.leetcode.problems.problem0013;

public class Solution {
  public int romanToInt(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int index = 0;
    int totalValue = 0;
    while (index < s.length()) {
      RomanToken token = getNextToken(s, index);
      totalValue += token.value;
      index = token.nextIndex;
    }
    return totalValue;
  }

  private RomanToken getNextToken(String romanNumeral, int index) {
    int curValue = getRomanNumeralValue(romanNumeral.charAt(index));
    int nextValue = index < romanNumeral.length() - 1 ? getRomanNumeralValue(romanNumeral.charAt(index + 1)) : 0;
    if (nextValue > curValue) {
      return new RomanToken(nextValue - curValue, index + 2);
    }
    else {
      return new RomanToken(curValue, index + 1);
    }
  }

  private int getRomanNumeralValue(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        throw new IllegalArgumentException();
    }
  }

  private static class RomanToken {
    int nextIndex;
    int value;
    RomanToken(int value, int nextIndex) {
      this.nextIndex = nextIndex;
      this.value = value;
    }
  }
}

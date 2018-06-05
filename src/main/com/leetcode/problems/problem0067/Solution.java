package main.com.leetcode.problems.problem0067;

public class Solution {
  public String addBinary(String a, String b) {
    StringBuilder added = new StringBuilder();
    boolean remainder = false;
    int aIndex = a.length() - 1;
    int bIndex = b.length() - 1;
    for (; aIndex >= 0 && bIndex >= 0; aIndex--, bIndex--) {
      char aChar = a.charAt(aIndex);
      char bChar = b.charAt(bIndex);
      int sum = Character.getNumericValue(aChar) + Character.getNumericValue(bChar);
      if (remainder) {
        sum++;
        remainder = false;
      }
      if (sum == 0) {
        added.append('0');
      }
      else if (sum == 1) {
        added.append('1');
      }
      else if (sum == 2) {
        added.append('0');
        remainder = true;
      }
      else { //sum == 3
        added.append('1');
        remainder = true;
      }
    }

    if (aIndex >= 0 || bIndex >= 0) {
      String remainderString;
      int remainderIndex;
      if (aIndex >= 0) {
        remainderString = a;
        remainderIndex = aIndex;
      }
      else {
        remainderString = b;
        remainderIndex = bIndex;
      }
      for (int i = remainderIndex; i >= 0; i--) {
        int sum = Character.getNumericValue(remainderString.charAt(i));
        if (remainder) {
          sum++;
        }
        if (sum == 0 || sum == 2) {
          added.append('0');
        }
        else { //if (sum == 1) {
          added.append('1');
          remainder = false;
        }

      }
    }

    if (remainder) {
      added.append('1');
    }
    return added.reverse().toString();
  }
}

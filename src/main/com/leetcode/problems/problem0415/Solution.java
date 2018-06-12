package main.com.leetcode.problems.problem0415;

public class Solution {
  public String addStrings(String num1, String num2) {
    if (num1.equals("0")) {
      return num2;
    }
    if (num2.equals("0")) {
      return num1;
    }
    StringBuilder sumBuilder = new StringBuilder();
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    boolean remainder = false;
    for (; i >= 0 && j >= 0; i--, j--) {
      int first = Character.getNumericValue(num1.charAt(i));
      int second = Character.getNumericValue(num2.charAt(j));
      int curPlaceSum = first + second;
      if (remainder) {
        curPlaceSum++;
      }
      if (curPlaceSum < 10) {
        remainder = false;
      } else {
        remainder = true;
        curPlaceSum -= 10;
      }
      sumBuilder.append(curPlaceSum);
    }
    if (i >= 0 || j >= 0) {

      String remainingString;
      int remainingIndex;
      if (i >= 0) {
        remainingString = num1;
        remainingIndex = i;
      } else {
        remainingString = num2;
        remainingIndex = j;
      }
      for (; remainingIndex >= 0; remainingIndex--) {
        int num = Character.getNumericValue(remainingString.charAt(remainingIndex));
        if (remainder) {
          num++;
        }
        if (num < 10) {
          remainder = false;
        } else {
          remainder = true;
          num -= 10;
        }
        sumBuilder.append(num);
      }
    }
    if (remainder) {
      sumBuilder.append('1');
    }
    return sumBuilder.reverse().toString();
  }
}

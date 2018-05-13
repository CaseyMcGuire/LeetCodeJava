package main.com.leetcode.problems.problem0043;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    final String smaller;
    final String larger;
    if (num1.length() > num2.length()) {
      larger = num1;
      smaller = num2;
    }
    else {
      larger = num2;
      smaller = num1;
    }
    List<Number> nums = new ArrayList<>();
    int numZeroesToAppend = 0;
    for (int i = smaller.length() - 1; i >= 0; i--) {
      Number curNum = new Number();
      if (smaller.charAt(i) == '0') {
        numZeroesToAppend++;
        continue;
      }
      int curDigit = Character.getNumericValue(smaller.charAt(i));
      int remainder = 0;
      for (int j = larger.length() - 1; j >= 0; j--) {
        int multipliedValue = Character.getNumericValue(larger.charAt(j)) * curDigit;
        int totalValue = multipliedValue + remainder;
        String totalValueStr = totalValue + "";
        if (totalValueStr.length() == 2) {
          remainder = Character.getNumericValue(totalValueStr.charAt(0));
          totalValue = Character.getNumericValue(totalValueStr.charAt(1));
        }
        else {
          remainder = 0;
        }
        curNum.prepend(totalValue);
      }
      if (remainder != 0) {
        curNum.prepend(remainder);
      }
      for (int j = 0; j < numZeroesToAppend; j++) {
        curNum.append(0);
      }
      nums.add(curNum);
      numZeroesToAppend++;
    }

    Number product = new Number();
    product.prepend(0);
    for (Number num : nums) {
      product = add(product, num);
    }
    //first multiply, then add
    return product.toString();
  }

  private Number add(Number n1, Number n2) {
    Number added = new Number();
    Number longer;
    Number shorter;
    if (n1.digits.size() > n2.digits.size()) {
      longer = n1;
      shorter = n2;
    }
    else {
      longer = n2;
      shorter = n1;
    }

    int remainder = 0;
    for (int i = shorter.length() - 1, j = longer.length() - 1; i >= 0; i--, j--) {
      int sum = shorter.get(i) + longer.get(j) + remainder;
      if (sum >= 10) {
        remainder = 1;
        sum -= 10;
      }
      else {
        remainder = 0;
      }
      added.prepend(sum);
    }

    for (int i = longer.length() - 1 - shorter.length(); i >= 0; i--) {
      int sum = longer.get(i) + remainder;
      if (sum >= 10) {
        sum -= 10;
        remainder = 1;
      }
      else {
        remainder = 0;
      }
      added.prepend(sum);
    }

    if (remainder != 0) {
      added.prepend(1);
    }
    return added;
  }

  private static class Number {
    LinkedList<Integer> digits;

    Number() {
      digits = new LinkedList<>();
    }

    void append(int i) {
      digits.addLast(i);
    }

    void prepend(int i) {
      digits.addFirst(i);
    }

    int get(int index) {
      return digits.get(index);
    }

    int length() {
      return digits.size();
    }

    public String toString() {
      StringBuilder builder = new StringBuilder();
      for (Integer i : digits) {
        builder.append(i);
      }
      return builder.toString();
    }
  }
}

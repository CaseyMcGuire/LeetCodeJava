package main.com.leetcode.problems.problem0066;

import java.util.LinkedList;

public class Solution {
  public int[] plusOne(int[] digits) {
    LinkedList<Integer> newNum = new LinkedList<>();
    int remainder = 0;
    int plusOne = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int curSum = digits[i] + remainder + plusOne;
      if (curSum == 10) {
        remainder = 1;
        curSum -= 10;
      }
      else {
        remainder = 0;
      }
      plusOne = 0;
      newNum.addFirst(curSum);
    }
    if (remainder != 0) {
      newNum.addFirst(remainder);
    }

    int[] sum = new int[newNum.size()];
    int i = 0;
    for (Integer num : newNum) {
      sum[i] = num;
      i++;
    }
    return sum;
  }
}

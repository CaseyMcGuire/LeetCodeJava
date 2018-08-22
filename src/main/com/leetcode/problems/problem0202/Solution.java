package main.com.leetcode.problems.problem0202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean isHappy(int n) {
    if (n == 1) {
      return true;
    }
    Set<Integer> visitedNums = new HashSet<>();
    int curNum = n;
    while (visitedNums.add(curNum)) {
      if (curNum == 1) {
        return true;
      }
      curNum = getNextNum(curNum);
    }
    return false;
  }

  private int getNextNum(int num) {
    String numStr = num + "";
    int sum = 0;
    for (char c : numStr.toCharArray()) {
      sum += Math.pow(Character.getNumericValue(c), 2);
    }
    return sum;
  }
}

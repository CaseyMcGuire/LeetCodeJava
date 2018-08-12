package main.com.leetcode.problems.problem0738;

public class Solution {
  public int monotoneIncreasingDigits(int N) {
    if (isMonotoneIncreasing(N)) {
      return N;
    }
    char[] numStr = (N + "").toCharArray();
    int leftMostNonMonotoneIncreasingIndex = numStr.length;
    for (int i = numStr.length - 1; i > 0; i--) {
      if (numStr[i] < numStr[i - 1]) {
        leftMostNonMonotoneIncreasingIndex = i;
        numStr[i - 1]--;
      }
    }
    for (int i = leftMostNonMonotoneIncreasingIndex; i < numStr.length; i++) {
      numStr[i] = '9';
    }
    return Integer.parseInt(new String(numStr));
  }

  private boolean isMonotoneIncreasing(int N) {
    String numStr = N + "";
    for (int i = 1; i < numStr.length(); i++) {
      if (Character.getNumericValue(numStr.charAt(i)) < Character.getNumericValue(numStr.charAt(i - 1))) {
        return false;
      }
    }
    return true;
  }
}

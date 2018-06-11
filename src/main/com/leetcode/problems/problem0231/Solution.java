package main.com.leetcode.problems.problem0231;

public class Solution {
  public boolean isPowerOfTwo(int n) {
    if (n < 0) {
      return false;
    }
    boolean foundOne = false;
    for (int i = 0; i < 31; i++) {
      int currentBit = (n >>> i) & 1;
      if (currentBit == 1) {
        if (foundOne) {
          return false;
        }
        foundOne = true;
      }
    }
    return foundOne;
  }
}

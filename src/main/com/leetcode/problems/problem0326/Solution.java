package main.com.leetcode.problems.problem0326;

public class Solution {
  public boolean isPowerOfThree(int n) {
    if (n == 1) {
      return true;
    }
    if (n % 3 != 0 || n < 3) {
      return false;
    }

    int current = 1;
    int previous = current;
    while (true) {
      current *= 3;
      if (current == n) {
        return true;
      }
      else if (current < previous) {
        // in case we overflow
        return false;
      }
      previous = current;
    }
  }
}

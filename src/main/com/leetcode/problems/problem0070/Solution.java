package main.com.leetcode.problems.problem0070;

public class Solution {

  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int[] numCombos = new int[n];
    numCombos[0] = 1;
    numCombos[1] = 2;
    for (int i = 2; i < n; i++) {
      numCombos[i] = numCombos[i - 1] + numCombos[i - 2];
    }
    return numCombos[n - 1];
  }
}

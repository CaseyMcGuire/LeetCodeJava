package main.com.leetcode.problems.problem0461;

public class Solution {
  public int hammingDistance(int x, int y) {
    int numDifferingBits = 0;
    for (int i = 0; i < 32; i++) {
      int curBitX = x >> i;
      int curBitY = y >> i;
      if ((curBitX & 1) != (curBitY & 1)) {
        numDifferingBits++;
      }
    }
    return numDifferingBits;
  }
}

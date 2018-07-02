package main.com.leetcode.problems.problem0191;

public class Solution {
  public int hammingWeight(int n) {
    int numOneBits = 0;
    for (int i = 0; i < 32; i++) {
      boolean isOneBit = ((n >> i) & 1) == 1;
      if (isOneBit) {
        numOneBits++;
      }
    }
    return numOneBits;
  }
}

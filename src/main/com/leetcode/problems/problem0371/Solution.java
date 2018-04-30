package main.com.leetcode.problems.problem0371;

public class Solution {
  public int getSum(int a, int b) {
    boolean hasRemainder = false;
    int sum = 0;
    for (int i = 0; i < 32; i++) {
      int aBit = (a >> i) & 1;
      int bBit = (b >> i) & 1;
      boolean bothOne = aBit == 1 && bBit == 1;
      final int currentBit;
      if (bothOne && hasRemainder) {
        currentBit = 1;
      }
      else if (bothOne || (aBit == 1 || bBit == 1) && hasRemainder) {
        currentBit = 0;
        hasRemainder = true;
      }
      else if ((aBit == 1 || bBit == 1) && !hasRemainder || (aBit == 0 || bBit == 0) && hasRemainder) {
        currentBit = 1;
        hasRemainder = false;
      }
      else {// aBit == 0, bBit == 0, and hasRemainder == false
        currentBit = 0;
      }
      sum = sum | (currentBit << i);
    }
    return sum;
  }
}

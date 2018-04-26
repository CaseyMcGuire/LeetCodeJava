package main.com.leetcode.problems.problem0338;

public class Solution {
  public int[] countBits(int num) {
    int[] nums = new int[num + 1];
    for (int i = 0; i <= num; i++) {
      nums[i] = numBits(i);
    }
    return nums;
  }

  private int numBits(int num) {
    int numBits = 0;
    while (num > 0) {
      if ((num & (Integer.MIN_VALUE + 1)) == 1) {
        numBits++;
      }
      num = num >> 1;
    }
    return numBits;
  }

}

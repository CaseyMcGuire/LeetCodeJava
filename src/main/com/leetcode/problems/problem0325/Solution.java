package main.com.leetcode.problems.problem0325;

public class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
    int[] sums = getSumArray(nums);
    for (int windowSize = nums.length; windowSize > 0; windowSize--) {
      for (int start = 0; start + windowSize <= nums.length; start++) {
        int end = start + windowSize - 1;
        int sum;
        if (start == 0) {
          sum = sums[end];
        }
        else {
          sum = sums[end] - sums[start - 1];
        }
        if (sum == k) {
          return windowSize;
        }
      }
    }
    return 0;
  }

  private int[] getSumArray(int[] nums) {
    int[] sums = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (i > 0) {
        sums[i] = sums[i - 1] + nums[i];
      }
      else {
        sums[i] = nums[i];
      }
    }
    return sums;
  }
}

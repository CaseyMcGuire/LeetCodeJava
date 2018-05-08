package main.com.leetcode.problems.problem0053;

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxSubarraySum;
    int currentMaxSubarraySum;
    maxSubarraySum = currentMaxSubarraySum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      currentMaxSubarraySum = Math.max(nums[i] + currentMaxSubarraySum, nums[i]);
      if (maxSubarraySum < currentMaxSubarraySum) {
        maxSubarraySum = currentMaxSubarraySum;
      }
    }
    return maxSubarraySum;
  }
}

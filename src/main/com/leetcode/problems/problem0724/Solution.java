package main.com.leetcode.problems.problem0724;

class Solution {
  public int pivotIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int sum = getSum(nums);
    int leftSum = 0;
    int rightSum = sum;
    for (int i = 0; i < nums.length; i++) {
      rightSum -= nums[i];
      if (i != 0) {
        leftSum += nums[i - 1];
      }
      if (leftSum == rightSum) {
        return i;
      }
    }
    return -1;
  }

  private int getSum(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum;
  }
}
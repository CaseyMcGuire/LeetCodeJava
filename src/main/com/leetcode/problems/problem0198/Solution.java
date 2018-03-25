package main.com.leetcode.problems.problem0198;

public class Solution {

  public int rob(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }
    int[] max = new int[nums.length];
    max[nums.length - 1] = nums[nums.length - 1];
    max[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
    for (int i = nums.length - 3; i >= 0; i--) {
      max[i] = Math.max(nums[i] + max[i + 2], max[i + 1]);
    }
    return max[0];
  }

  public static void main(String[] args) {

  }
}

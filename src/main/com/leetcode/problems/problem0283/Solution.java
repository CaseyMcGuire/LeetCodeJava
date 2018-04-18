package main.com.leetcode.problems.problem0283;

public class Solution {
  public void moveZeroes(int[] nums) {
    int numZeroes = countNumZeroes(nums);
    int curIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[curIndex] = nums[i];
        curIndex++;
      }
    }
    for (int i = nums.length - numZeroes; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

  private int countNumZeroes(int[] nums) {
    int numZeroes = 0;
    for (int num : nums) {
      if (num == 0) {
        numZeroes++;
      }
    }
    return numZeroes;
  }
}

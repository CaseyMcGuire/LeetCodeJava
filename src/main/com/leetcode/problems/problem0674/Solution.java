package main.com.leetcode.problems.problem0674;

public class Solution {
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int longestSoFar = 1;
    int previousNum = nums[0];
    int currentLength = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > previousNum) {
        currentLength++;
      }
      else {
        currentLength = 1;
      }
      previousNum = nums[i];
      if (longestSoFar < currentLength) {
        longestSoFar = currentLength;
      }
    }
    return longestSoFar;
  }
}

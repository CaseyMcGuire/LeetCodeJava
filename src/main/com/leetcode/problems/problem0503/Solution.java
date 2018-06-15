package main.com.leetcode.problems.problem0503;


public class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int[] greaterElements = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      Integer greaterElementIndex = null;
      for (int j = i + 1; j < nums.length + i; j++) {
        int greaterIndex = j;
        if (j >= nums.length) {
          greaterIndex -= nums.length;
        }
        if (nums[greaterIndex] > nums[i]) {
          greaterElementIndex = greaterIndex;
          break;
        }
      }
      if (greaterElementIndex == null) {
        greaterElements[i] = -1;
      }
      else {
        greaterElements[i] = nums[greaterElementIndex];
      }
    }
    return greaterElements;
  }
}

package main.com.leetcode.problems.problem0747;

public class Solution {
  public int dominantIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int largestElementIndex = findLargestElementIndex(nums);
    for (int i = 0; i < nums.length; i++) {
      if (i == largestElementIndex) {
        continue;
      }
      int twiceElement = nums[i] * 2;
      if (twiceElement > nums[largestElementIndex]) {
        return -1;
      }
    }
    return largestElementIndex;
  }


  private int findLargestElementIndex(int[] nums) {
    Integer largestElement = null;
    Integer largestElementIndex = null;
    for (int i = 0; i < nums.length; i++) {
      if (largestElement == null || nums[i] > largestElement) {
        largestElement = nums[i];
        largestElementIndex = i;
      }
    }
    return largestElementIndex;
  }

}


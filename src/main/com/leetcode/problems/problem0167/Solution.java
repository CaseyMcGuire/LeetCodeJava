package main.com.leetcode.problems.problem0167;

import java.util.Arrays;

public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int[] nums = new int[2];
    for (int i = 0; i < numbers.length; i++) {
      int remainder = target - numbers[i];
      int remainderIndex = Arrays.binarySearch(numbers, remainder);
      if (remainderIndex >= 0 && remainderIndex != i) {
        nums[0] = i + 1;
        nums[1] = remainderIndex + 1;
        Arrays.sort(nums);
        break;
      }
    }
    return nums;
  }
}

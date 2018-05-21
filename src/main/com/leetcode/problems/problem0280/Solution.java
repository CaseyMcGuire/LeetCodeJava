package main.com.leetcode.problems.problem0280;

import java.util.Arrays;

public class Solution {
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int half = nums.length / 2;
    int[] copy = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      copy[i] = nums[i];
    }
    boolean useSmall = true;

    int smallIndex = 0;
    int largeIndex = nums.length % 2 == 0 ? half : half + 1;
    for(int i = 0; i < nums.length; i++) {
      if (useSmall) {
        nums[i] = copy[smallIndex];
        smallIndex++;
      }
      else {
        nums[i] = copy[largeIndex];
        largeIndex++;
      }
      useSmall = !useSmall;
    }
  }
}

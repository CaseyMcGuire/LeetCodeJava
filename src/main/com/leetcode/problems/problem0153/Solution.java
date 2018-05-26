package main.com.leetcode.problems.problem0153;

public class Solution {
  public int findMin(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    while (low < high) {
      int middle = (low + high) / 2;
      if (isMin(nums, middle)) {
        return nums[middle];
      }
      if (nums[high] > nums[middle]) {
        high = middle - 1;
      }
      else { // nums[high] < nums[middle]
        low = middle + 1;
      }
    }
    return nums[high];
  }

  private boolean isMin(int[] nums, int index) {
    boolean isLessThanRight = index == 0 ? true : nums[index - 1] > nums[index];
    boolean isLessThanLeft = index == nums.length - 1 ? true : nums[index + 1] > nums[index];
    return isLessThanLeft && isLessThanRight;
  }
}

package main.com.leetcode.problems.problem0033;

import java.util.Arrays;

public class Solution {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int pivotIndex = findPivotIndex(nums);
    final int index;
    if (nums[ nums.length - 1] >= target) {
      index = Arrays.binarySearch(nums, pivotIndex, nums.length, target);
    }
    else {
      index = Arrays.binarySearch(nums, 0, pivotIndex, target);
    }
    if (index < 0) {
      return -1;
    }
    return index;
  }

  private int findPivotIndex(int[] nums) {
    int high = nums.length - 1;
    int low = 0;
    while (low < high) {
      int mid = (low + high) / 2;
      if (isPivot(nums, mid, low, high)) {
        return mid;
      }
      else if (nums[mid] >= nums[high] && nums[mid] >= nums[low] ) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private boolean isPivot(int[] nums, int mid, int low, int high) {
    boolean isLessThanLeftNeighbor = mid == 0 || nums[mid] < nums[mid - 1];
    boolean isLessThanRightNeighbor = mid == nums.length - 1 || nums[mid] < nums[mid + 1];
    return isLessThanLeftNeighbor && isLessThanRightNeighbor && nums[mid] < nums[low] && nums[mid] < nums[high];
  }
}
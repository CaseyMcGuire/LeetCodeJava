package main.com.leetcode.problems.problem0034;

import java.util.Arrays;


public class Solution {

  public int[] searchRange(int[] nums, int target) {
    int index = Arrays.binarySearch(nums, target);
    if (index < 0) {
      return new int[] {-1, -1};
    }
    int left = searchSubRange(nums, target, 0, index, Direction.LEFT);
    int right = searchSubRange(nums, target, index + 1, nums.length, Direction.RIGHT);
    if (left < 0) {
      left = index;
    }
    if (right < 0) {
      right = index;
    }
    return new int[]{left, right};
  }

  private int searchSubRange(int[] nums, int target, int start, int end, Direction direction) {
    int index = Arrays.binarySearch(nums, start, end, target);
    if (index < 0) {
      return -1;
    }

    int furtherIndex;
    if (direction == Direction.RIGHT) {
      furtherIndex = searchSubRange(nums, target, index + 1, end, Direction.RIGHT);
    }
    else {
      furtherIndex = searchSubRange(nums, target, start, index, Direction.LEFT);
    }
    if (furtherIndex >= 0) {
      return furtherIndex;
    }
    else {
      return index;
    }
  }

  private enum Direction {
    RIGHT,
    LEFT
  }

  public static void main(String[] args) {
    System.out.println(new Solution().searchRange(new int[]{1, 1, 2}, 1)[1]);
  }
}

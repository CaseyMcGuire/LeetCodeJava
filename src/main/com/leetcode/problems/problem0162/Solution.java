package main.com.leetcode.problems.problem0162;

public class Solution {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int high = nums.length - 1;
    int low = 0;
    while (true) {
      int middle = (high + low) / 2;
      State currentState = getState(nums, middle);
      if (currentState == State.IS_PEAK) {
        return middle;
      }
      else if (currentState == State.IS_ASCENDING) {
        low = middle + 1;
      }
      else { //currentState == State.IS_DESCENDING
        high = middle - 1;
      }
    }
  }

  private State getState(int[] nums, int index) {
    int left = index == 0 ? Integer.MIN_VALUE : nums[index - 1];
    int right = index == nums.length - 1 ? Integer.MIN_VALUE : nums[index + 1];
    int num = nums[index];
    if (left < num && right > num) {
      return State.IS_ASCENDING;
    }
    else if (left > num && right < num) {
      return State.IS_DESCENDING;
    }
    else if (left < num && right < num) {
      return State.IS_PEAK;
    }
    else { //left > num && right > num
      //arbitrary, could choose either
      return State.IS_ASCENDING;
    }
  }

  private enum State {
    IS_ASCENDING,
    IS_DESCENDING,
    IS_PEAK
  }
}

package main.com.leetcode.problems.problem0042;

public class Solution {
  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int[] highestToTheLeft = new int[height.length];
    highestToTheLeft[0] = height[0];
    for (int i = 1; i < height.length; i++) {
      highestToTheLeft[i] = Math.max(highestToTheLeft[i - 1], height[i]);
    }

    int[] highestToTheRight = new int[height.length];
    highestToTheRight[height.length - 1] = height[height.length - 1];
    for (int i = height.length - 2; i >= 0; i--) {
      highestToTheRight[i] = Math.max(highestToTheRight[i + 1], height[i]);
    }

    int totalTrapped = 0;
    for (int i = 0; i < height.length; i++) {
      int amountTrappedInCurrentLevel = Math.min(highestToTheLeft[i], highestToTheRight[i]);
      totalTrapped -= (height[i] - amountTrappedInCurrentLevel);
    }
    return totalTrapped;
  }
}

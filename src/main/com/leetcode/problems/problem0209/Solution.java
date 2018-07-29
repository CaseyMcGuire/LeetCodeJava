package main.com.leetcode.problems.problem0209;

public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null) {
      return 0;
    }
    int start = 0;
    int sum = 0;
    Integer minSoFar = null;
    for (int end = 0; end < nums.length; end++) {
      sum += nums[end];
      while (sum >= s && start <= end) {
        int currentLength = (end - start + 1);
        if (minSoFar == null || currentLength < minSoFar) {
          minSoFar = currentLength;
        }
        sum -= nums[start];
        start++;
      }
    }
    return minSoFar != null ? minSoFar : 0;
  }
}

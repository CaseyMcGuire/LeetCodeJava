package main.com.leetcode.problems.problem0485;

public class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int currentNumConsecutiveOnes = 0;
    int maxConsecutiveOnes = 0;
    for (int num : nums) {
      if (num == 1) {
        currentNumConsecutiveOnes++;
      }
      else {
        currentNumConsecutiveOnes = 0;
      }
      if (currentNumConsecutiveOnes > maxConsecutiveOnes) {
        maxConsecutiveOnes = currentNumConsecutiveOnes;
      }
    }
    return maxConsecutiveOnes;
  }
}

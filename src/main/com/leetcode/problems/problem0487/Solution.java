package main.com.leetcode.problems.problem0487;

public class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int currentLengthOfConsecutiveOnes = 0;
    int lengthOfPreviousIfSeparatedByOneZero = 0;
    int maxSoFar = 0;
    boolean seenOneZero = false;
    boolean seenAnyZeroes = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        seenAnyZeroes = true;
        if (seenOneZero) {
          lengthOfPreviousIfSeparatedByOneZero = 0;
        }
        else {
          lengthOfPreviousIfSeparatedByOneZero = currentLengthOfConsecutiveOnes;
          seenOneZero = true;
        }
        currentLengthOfConsecutiveOnes = 0;
      }
      else {
        seenOneZero = false;
        currentLengthOfConsecutiveOnes++;
      }
      if (currentLengthOfConsecutiveOnes + lengthOfPreviousIfSeparatedByOneZero > maxSoFar) {
        maxSoFar = currentLengthOfConsecutiveOnes + lengthOfPreviousIfSeparatedByOneZero;
      }
    }
    if (seenAnyZeroes) {
      maxSoFar++;
    }
    return maxSoFar;
  }
}

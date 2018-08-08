package main.com.leetcode.problems.problem0673;

import java.util.TreeMap;

public class Solution {
  public int findNumberOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] lisAtIndex = new int[nums.length];
    int[] numLongestSubsequenceAtIndex = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      numLongestSubsequenceAtIndex[i] = 1;
      int curLongest = 1;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] > nums[i]) {
          int subsequenceLength = 1 + lisAtIndex[j];
          if (subsequenceLength > curLongest) {
            curLongest = 1 + lisAtIndex[j];
            numLongestSubsequenceAtIndex[i] = numLongestSubsequenceAtIndex[j];
          }
          else if (subsequenceLength == curLongest){
            numLongestSubsequenceAtIndex[i] += numLongestSubsequenceAtIndex[j];
          }
        }
      }
      lisAtIndex[i] = curLongest;
    }

    int largestLIS = lisAtIndex[0];
    int numLargestLIS = numLongestSubsequenceAtIndex[0];
    for (int i = 1; i < nums.length; i++) {
      if (lisAtIndex[i] > largestLIS) {
        largestLIS = lisAtIndex[i];
        numLargestLIS = numLongestSubsequenceAtIndex[i];
      }
      else if (lisAtIndex[i] == largestLIS) {
        numLargestLIS += numLongestSubsequenceAtIndex[i];
      }
    }
    return numLargestLIS;
  }

}

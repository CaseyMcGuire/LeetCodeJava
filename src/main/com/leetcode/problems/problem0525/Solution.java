package main.com.leetcode.problems.problem0525;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int findMaxLength(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Map<Integer, Integer> numToIndex = new HashMap<>();
    numToIndex.put(0, -1);
    int longestSoFar = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      count += (nums[i] == 0 ? -1 : 1);
      Integer earliestIndex = numToIndex.get(count);
      if (earliestIndex == null) {
        numToIndex.put(count, i);
      }
      else {
        int lengthOfCurrentSubarray = i - earliestIndex;
        if (lengthOfCurrentSubarray > longestSoFar) {
          longestSoFar = lengthOfCurrentSubarray;
        }
      }
    }

    return longestSoFar;
  }
}

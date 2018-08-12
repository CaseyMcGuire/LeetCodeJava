package main.com.leetcode.problems.problem0645;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int[] findErrorNums(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    Set<Integer> numSet = new HashSet<>();
    int duplicatedNum = -1;
    for (int num : nums) {
      if (!numSet.add(num)) {
        duplicatedNum = num;
      }
    }

    int missingNum = -1;
    for (int i = 1; i <= nums.length; i++) {
      if (!numSet.contains(i)) {
        missingNum = i;
        break;
      }
    }
    return new int[]{duplicatedNum, missingNum};
  }
}

package main.com.leetcode.problems.problem0163;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    if (nums.length == 0) {
      if (lower == upper) {
        return Collections.singletonList(lower + "");
      }
      else {
        return Collections.singletonList(lower + "->" + upper);
      }
    }
    List<String> missingRanges = new ArrayList<>();
    int first = nums[0];
    if (first != lower) {
      missingRanges.add(getMissingRange(lower - 1, first));
    }
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) {
        continue;
      }
      if (nums[i - 1] + 1 != nums[i]) {
        missingRanges.add(getMissingRange(nums[i - 1], nums[i]));
      }
    }
    int last = nums[nums.length - 1];
    if (last != upper) {
      missingRanges.add(getMissingRange(last, upper + 1));
    }
    return missingRanges;
  }

  private String getMissingRange(int startExclusive, int endExclusive) {
    if (startExclusive + 2 == endExclusive) {
      return (endExclusive - 1) + "";
    }
    else {
      return (startExclusive + 1) + "->" + (endExclusive - 1);
    }
  }
}

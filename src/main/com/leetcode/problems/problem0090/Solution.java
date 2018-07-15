package main.com.leetcode.problems.problem0090;

import java.util.*;

public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Set<List<Integer>> uniqueSubsets = new HashSet<>();
    subsetsWithDup(nums, 0, uniqueSubsets, new ArrayDeque<>());
    return new ArrayList<>(uniqueSubsets);
  }

  private void subsetsWithDup(int[] nums, int index, Set<List<Integer>> uniqueSubsets, Deque<Integer> currentSubset) {
    if (index == nums.length) {
      List<Integer> currentSubsetCopy = new ArrayList<>(currentSubset);
      Collections.sort(currentSubsetCopy);
      uniqueSubsets.add(currentSubsetCopy);
      return;
    }
    currentSubset.push(nums[index]);
    subsetsWithDup(nums, index + 1, uniqueSubsets, currentSubset);
    currentSubset.pop();
    subsetsWithDup(nums, index + 1, uniqueSubsets, currentSubset);
  }
}

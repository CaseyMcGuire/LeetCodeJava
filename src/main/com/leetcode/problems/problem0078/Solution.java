package main.com.leetcode.problems.problem0078;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets(nums, 0, new ArrayList<>(), subsets);
    return subsets;
  }

  private void subsets(int[] nums, int curIndex, List<Integer> curList, List<List<Integer>> subsets) {
    if (curIndex >= nums.length) {
      subsets.add(new ArrayList<>(curList));
      return;
    }
    curList.add(nums[curIndex]);
    subsets(nums, curIndex + 1, curList, subsets);
    curList.remove(curList.size() - 1);
    subsets(nums, curIndex + 1, curList, subsets);
  }
}

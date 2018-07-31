package main.com.leetcode.problems.problem0398;

import java.util.*;

public class Solution {

  private final Map<Integer, List<Integer>> numToIndices;
  private final Random random;

  public Solution(int[] nums) {
    numToIndices = createNumToIndicesMap(nums);
    random = new Random();
  }

  private Map<Integer, List<Integer>> createNumToIndicesMap(int[] nums) {
    Map<Integer, List<Integer>> numToIndices = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
      List<Integer> indices = numToIndices.getOrDefault(nums[i], new ArrayList<>());
      indices.add(i);
      numToIndices.put(nums[i], indices);
    }
    return numToIndices;
  }

  public int pick(int target) {
    List<Integer> indices = numToIndices.get(target);
    return indices.get(random.nextInt(indices.size()));
  }
}

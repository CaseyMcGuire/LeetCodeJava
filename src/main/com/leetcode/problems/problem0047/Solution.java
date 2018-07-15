package main.com.leetcode.problems.problem0047;

import java.util.*;

public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> permutations = new HashSet<>();
    permuteUnique(nums, new HashSet<>(), new LinkedList<>(), permutations);
    return new ArrayList<>(permutations);
  }

  private void permuteUnique(int[] nums, Set<Integer> indices, Deque<Integer> permutation, Set<List<Integer>> permutations) {
    if (permutation.size() == nums.length) {
      List<Integer> permutationCopy = new ArrayList<>(permutation);
      permutations.add(permutationCopy);
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!indices.contains(i)) {
        permutation.addLast(nums[i]);
        indices.add(i);
        permuteUnique(nums, indices, permutation, permutations);
        permutation.removeLast();
        indices.remove(i);
      }
    }
  }
}

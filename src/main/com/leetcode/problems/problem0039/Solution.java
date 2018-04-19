package main.com.leetcode.problems.problem0039;

import java.util.*;

public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    TreeSet<Integer> orderedCandidates = new TreeSet<>();
    for (int candidate : candidates) {
      orderedCandidates.add(candidate);
    }
    Set<List<Integer>> uniqueCombinations = new HashSet<>();
    combinationSum(orderedCandidates, uniqueCombinations, new ArrayList<>(), target);
    return new ArrayList<>(uniqueCombinations);
  }

  private void combinationSum(TreeSet<Integer> orderedCandidates, Set<List<Integer>> uniqueCombinations, List<Integer> runningCombination, int target) {
    if (target == 0) {
      List<Integer> combination = new ArrayList<>(runningCombination);
      Collections.sort(combination);
      uniqueCombinations.add(combination);
      return;
    }
    NavigableSet<Integer> possibleCandidates = orderedCandidates.headSet(target, true);
    for (Integer candidate : possibleCandidates) {
      int remainingTarget = target - candidate;
      runningCombination.add(candidate);
      combinationSum(orderedCandidates, uniqueCombinations, runningCombination, remainingTarget);
      runningCombination.remove(runningCombination.size() - 1);
    }
  }
}

package main.com.leetcode.problems.problem0040;

import java.util.*;

public class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    TreeMap<Integer, Integer> numToOccurrences = new TreeMap<>();
    for (int candidate : candidates) {
      numToOccurrences.merge(candidate, 1, (cur, iter) -> cur + iter);
    }
    Set<List<Integer>> uniqueCombinations = new HashSet<>();
    combinationSum(numToOccurrences, uniqueCombinations, new ArrayList<>(), target);
    return new ArrayList<>(uniqueCombinations);
  }

  private void combinationSum(NavigableMap<Integer, Integer> numToOccurrences, Set<List<Integer>> uniqueCombinations, List<Integer> currentCombination, int target) {
    if (target == 0) {
      currentCombination = new ArrayList<>(currentCombination);
      Collections.sort(currentCombination);
      uniqueCombinations.add(currentCombination);
      return;
    }
    NavigableMap<Integer, Integer> lessThanOrEqualToTarget = numToOccurrences.headMap(target, true);
    for (Map.Entry<Integer, Integer> entry : lessThanOrEqualToTarget.entrySet()) {
      int numOccurrences = entry.getValue();
      if (numOccurrences > 0) {
        lessThanOrEqualToTarget.put(entry.getKey(), entry.getValue() - 1);
        currentCombination.add(entry.getKey());
        combinationSum(lessThanOrEqualToTarget, uniqueCombinations, currentCombination, target - entry.getKey());
        lessThanOrEqualToTarget.put(entry.getKey(), entry.getValue() + 1);
        currentCombination.remove(currentCombination.size() - 1);
      }
    }
  }
}

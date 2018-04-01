package main.com.leetcode.problems.problem0508;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int[] findFrequentTreeSum(TreeNode root) {
    if (root == null) {
      return new int[]{};
    }
    Map<Integer, Integer> subTreeSumToFrequency = new HashMap<>();
    findFrequentTreeSum(root, subTreeSumToFrequency);
    return calculateMostFrequentSums(subTreeSumToFrequency);
  }

  private int[] calculateMostFrequentSums(Map<Integer, Integer> subTreeSumToFrequency) {
    Integer mostFrequencyOccurrences = null;
    List<Integer> numSumsOfMostFrequentOccurrence = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : subTreeSumToFrequency.entrySet()) {
      Integer currentSum = entry.getKey();
      Integer currentFrequency = entry.getValue();
      if (mostFrequencyOccurrences == null || currentFrequency == mostFrequencyOccurrences) {
        mostFrequencyOccurrences = currentFrequency;
        numSumsOfMostFrequentOccurrence.add(currentSum);
      }
      else if (currentFrequency > mostFrequencyOccurrences) {
        mostFrequencyOccurrences = currentFrequency;
        numSumsOfMostFrequentOccurrence = new ArrayList<>();
        numSumsOfMostFrequentOccurrence.add(currentSum);
      }
    }
    int[] mostFrequentSums = new int[numSumsOfMostFrequentOccurrence.size()];
    for (int i = 0; i < numSumsOfMostFrequentOccurrence.size(); i++) {
      mostFrequentSums[i] = numSumsOfMostFrequentOccurrence.get(i);
    }
    return mostFrequentSums;
  }

  private int findFrequentTreeSum(TreeNode root, Map<Integer, Integer> subTreeSumToFrequency) {
    if (root == null) {
      return 0;
    }
    int subTreeSum = root.val + findFrequentTreeSum(root.left, subTreeSumToFrequency) + findFrequentTreeSum(root.right, subTreeSumToFrequency);
    subTreeSumToFrequency.merge(subTreeSum, 1, (current, iter) -> current + iter);
    return subTreeSum;
  }
}

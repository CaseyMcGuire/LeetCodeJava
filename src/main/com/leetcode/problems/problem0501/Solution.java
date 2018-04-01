package main.com.leetcode.problems.problem0501;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int[] findMode(TreeNode root) {
    Map<Integer, Integer> nodeValToFrequency = new HashMap<>();
    findNodeValToFrequency(root, nodeValToFrequency);
    return getHighestFrequencyVals(nodeValToFrequency);
  }

  private int[] getHighestFrequencyVals(Map<Integer, Integer> nodeValToFrequency) {
    Integer highestFrequency = null;
    List<Integer> highestFrequencyNodeVals = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : nodeValToFrequency.entrySet()) {
      Integer nodeVal = entry.getKey();
      Integer frequency = entry.getValue();
      if (highestFrequency == null) {
        highestFrequency = frequency;
        highestFrequencyNodeVals.add(nodeVal);
      }
      else if (frequency.intValue() == highestFrequency) {
        highestFrequencyNodeVals.add(nodeVal);
      }
      else if (frequency.intValue() > highestFrequency) {
        highestFrequency = frequency;
        highestFrequencyNodeVals = new ArrayList<>();
        highestFrequencyNodeVals.add(nodeVal);
      }
    }
    int[] nodeVals = new int[highestFrequencyNodeVals.size()];
    for (int i = 0; i < highestFrequencyNodeVals.size(); i++) {
      nodeVals[i] = highestFrequencyNodeVals.get(i);
    }
    return nodeVals;
  }

  private void findNodeValToFrequency(TreeNode root, Map<Integer, Integer> nodeValToFrequency) {
    if (root == null) {
      return;
    }
    nodeValToFrequency.merge(root.val, 1, (existing, increment) -> existing + increment);
    findNodeValToFrequency(root.left, nodeValToFrequency);
    findNodeValToFrequency(root.right, nodeValToFrequency);
  }
}

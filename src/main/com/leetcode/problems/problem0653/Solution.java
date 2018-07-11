package main.com.leetcode.problems.problem0653;

import main.com.leetcode.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }
    Map<Integer, Integer> frequencies = new HashMap<>();
    fillFrequencyMap(frequencies, root);
    for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
      Integer num = entry.getKey();
      Integer frequency = entry.getValue();
      Integer difference = k - num;
      if (num.intValue() == difference.intValue() && frequency >= 2) {
        return true;
      }
      else if (num.intValue() != difference.intValue() && frequencies.containsKey(difference)) {
        return true;
      }
    }
    return false;
  }

  private void fillFrequencyMap(Map<Integer, Integer> frequency, TreeNode root) {
    if (root == null) {
      return;
    }
    frequency.merge(root.val, 1, (prev, cur) -> prev + cur);
    fillFrequencyMap(frequency, root.left);
    fillFrequencyMap(frequency, root.right);
  }

}

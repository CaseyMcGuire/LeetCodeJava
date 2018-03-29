package main.com.leetcode.problems.problem0530;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int getMinimumDifference(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    fillValuesList(root, values);
    if (values.size() <= 1) {
      return 0;
    }
    int curMaxDifference = Integer.MAX_VALUE;
    for (int i = 0; i < values.size() - 1; i++) {
      int curDifference = Math.abs(values.get(i) - values.get(i + 1));
      if (curDifference < curMaxDifference) {
        curMaxDifference = curDifference;
      }
    }
    return curMaxDifference;
  }

  private void fillValuesList(TreeNode root, List<Integer> values) {
    if (root == null) {
      return;
    }
    fillValuesList(root.left, values);
    values.add(root.val);
    fillValuesList(root.right, values);
  }
}

package main.com.leetcode.problems.problem0337;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public int rob(TreeNode root) {
    return rob(root, false);
  }

  private int rob(TreeNode node, boolean robbedPreviousLevel) {
    if (node == null) {
      return 0;
    }
    if (node.left == null && node.right == null) {
      return robbedPreviousLevel ? 0 : node.val;
    }
    int dontRobThisLevelSum = rob(node.left, false) + rob(node.right, false);
    if (!robbedPreviousLevel) {
      int robThisLevelSum = node.val + rob(node.left, true) + rob(node.right, true);
      return Math.max(robThisLevelSum, dontRobThisLevelSum);
    }
    else {
      return dontRobThisLevelSum;
    }
  }
}

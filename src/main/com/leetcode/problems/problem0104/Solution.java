package main.com.leetcode.problems.problem0104;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSubTreeDepth = 1 + maxDepth(root.left);
    int rightSubTreeDepth = 1 + maxDepth(root.right);
    return Math.max(leftSubTreeDepth, rightSubTreeDepth);
  }
}

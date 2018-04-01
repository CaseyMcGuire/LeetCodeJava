package main.com.leetcode.problems.problem0111;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return getMinDepth(root, 0);
  }

  private Integer getMinDepth(TreeNode node, int currentDepth) {
    if (node == null) {
      return null;
    }
    int newDepth = currentDepth + 1;
    boolean isLeaf = node.left == null && node.right == null;
    if (isLeaf) {
      return newDepth;
    }
    Integer leftDepth = getMinDepth(node.left, newDepth);
    Integer rightDepth = getMinDepth(node.right, newDepth);
    if (leftDepth == null) {
      return rightDepth;
    }
    else if (rightDepth == null) {
      return leftDepth;
    }
    else {
      return Math.min(leftDepth, rightDepth);
    }
  }
}

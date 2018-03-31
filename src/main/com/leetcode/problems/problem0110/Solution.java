package main.com.leetcode.problems.problem0110;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public boolean isBalanced(TreeNode root) {
    return calculateBalancedHeight(root) != null;
  }

  private Integer calculateBalancedHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Integer leftHeight = calculateBalancedHeight(root.left);
    Integer rightHeight = calculateBalancedHeight(root.right);
    if (leftHeight == null || rightHeight == null) {
      return null;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return null;
    }
    return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
  }
}

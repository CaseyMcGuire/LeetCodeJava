package main.com.leetcode.problems.problem0538;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  private Integer currentValue;
  public TreeNode convertBST(TreeNode root) {
    currentValue = 0;
    recurseThroughBST(root);
    return root;
  }

  private void recurseThroughBST(TreeNode root) {
    if (root == null) {
      return;
    }
    recurseThroughBST(root.right);
    root.val += currentValue;
    currentValue = root.val;
    recurseThroughBST(root.left);
  }
}

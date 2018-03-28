package main.com.leetcode.problems.problem0226;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode invertedRight = invertTree(root.right);
    TreeNode invertedLeft = invertTree(root.left);
    root.left = invertedRight;
    root.right = invertedLeft;
    return root;
  }
}

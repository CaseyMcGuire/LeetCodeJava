package main.com.leetcode.problems.problem0114;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  private TreeNode currentNode;
  public void flatten(TreeNode root) {
    flattenRecurse(root);
    currentNode = null;
  }

  private void flattenRecurse(TreeNode node) {
    if (node == null) {
      return;
    }
    if (currentNode == null) {
      currentNode = node;
    }
    else {
      currentNode.right = node;
      currentNode = currentNode.right;
    }
    TreeNode right = node.right;
    TreeNode left = node.left;
    currentNode.left = null;
    flattenRecurse(left);
    flattenRecurse(right);
  }
}


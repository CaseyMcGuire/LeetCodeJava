package main.com.leetcode.problems.problem0623;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public TreeNode addOneRow(TreeNode root, int value, int depth) {
    if (depth == 1) {
      TreeNode newRoot = new TreeNode(value);
      newRoot.left = root;
      return newRoot;
    }
    else {
      addOneRow(root, value, depth, 1);
      return root;
    }
  }

  private void addOneRow(TreeNode node, int value, int depth, int currentDepth) {
    if (node == null) {
      return;
    }
    if (currentDepth == depth - 1) {
      TreeNode left = node.left;
      TreeNode right = node.right;
      node.left = new TreeNode(value);
      node.left.left = left;
      node.right = new TreeNode(value);
      node.right.right = right;
    }
    else {
      addOneRow(node.right, value, depth, currentDepth + 1);
      addOneRow(node.left, value, depth, currentDepth + 1);
    }
  }
}

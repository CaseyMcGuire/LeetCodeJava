package main.com.leetcode.problems.problem0814;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    pruneZeroesFromTree(root);
    if (root.left == null && root.right == null && root.val == 0) {
      return null;
    }
    return root;
  }

  // returns whether this subtree has only zeroes
  private void pruneZeroesFromTree(TreeNode node) {
    if (node == null) {
      return;
    }
    pruneZeroesFromTree(node.right);
    pruneZeroesFromTree(node.left);
    if (isLeaf(node.right) && node.right.val == 0) {
      node.right = null;
    }
    if (isLeaf(node.left) && node.left.val == 0) {
      node.left = null;
    }
  }

  private boolean isLeaf(TreeNode node) {
    return node != null && node.right == null && node.left == null;
  }

}

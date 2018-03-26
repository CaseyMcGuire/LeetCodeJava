package main.com.leetcode.problems.problem0669;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {

  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) {
      return null;
    }
    boolean shouldTrim = root.val < L || root.val > R;
    TreeNode left = trimBST(root.left, L, R);
    TreeNode right = trimBST(root.right, L, R);
    if (!shouldTrim) {
      root.left = left;
      root.right = right;
      return root;
    }

    if (left == null && right == null) {
      return null;
    }
    else if (left == null) {
      return right;
    }
    else if (right == null) {
      return left;
    }
    else {
      TreeNode newRoot = right;
      TreeNode newRootLeft = newRoot.left;
      newRoot.left = left;
      insertNode(newRoot, newRootLeft);
      return newRoot;
    }
  }

  private void insertNode(TreeNode root, TreeNode node) {
    TreeNode iter = root;
    while (true) {
      if (node.val > iter.val) {
        if (iter.right == null) {
          iter.right = node;
          return;
        }
        else {
          iter = iter.right;
        }
      }
      else { //node.val < root.val
        if (iter.left == null) {
          iter.left = node;
          return;
        }
        else {
          iter = iter.left;
        }
      }
    }
  }
}

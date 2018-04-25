package main.com.leetcode.problems.problem0236;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //This relies on object identity, which is not clear from the problem description
    if (root == null || root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
  }
}

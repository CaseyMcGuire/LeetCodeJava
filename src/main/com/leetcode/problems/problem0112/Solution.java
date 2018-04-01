package main.com.leetcode.problems.problem0112;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    int currentSum = sum - root.val;
    boolean isLeaf = root.left == null && root.right == null;
    if (isLeaf && currentSum == 0) {
      return true;
    }
    return hasPathSum(root.left, currentSum) || hasPathSum(root.right, currentSum);
  }
}

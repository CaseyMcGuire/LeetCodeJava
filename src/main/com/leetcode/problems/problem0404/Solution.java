package main.com.leetcode.problems.problem0404;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftLeafVal = 0;
    boolean leftIsLeaf = root.left != null && root.left.left == null && root.left.right == null;
    if (leftIsLeaf) {
      leftLeafVal += root.left.val;
    }
    return leftLeafVal + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
  }
}

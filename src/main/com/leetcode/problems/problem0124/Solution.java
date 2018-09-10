package main.com.leetcode.problems.problem0124;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {

  private Integer maxSoFar;

  public int maxPathSum(TreeNode root) {
    maxSoFar = null;
    findMaxPathSum(root);
    return maxSoFar;
  }


  private int findMaxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSum = findMaxPathSum(root.left);
    int rightSum = findMaxPathSum(root.right);
    int rootToLeft = root.val + leftSum;
    int rootToRight = root.val + rightSum;
    int rootToBoth = root.val + leftSum + rightSum;
    int rootVal = root.val;
    int max = Math.max(Math.max(rootToBoth, rootVal), Math.max(rootToLeft, rootToRight));
    if (maxSoFar == null || maxSoFar < max) {
      maxSoFar = max;
    }
    return Math.max(rootVal, Math.max(rootToLeft, rootToRight));
  }

}

package main.com.leetcode.problems.problem0617;

import main.com.leetcode.datastructures.TreeNode;


public class Solution {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    TreeNode newRoot = new TreeNode(getRootSum(t1, t2));
    newRoot.left = mergeTrees(t1.left ,t2.left);
    newRoot.right = mergeTrees(t1.right, t2.right);
    return newRoot;
  }

  private int getRootSum(TreeNode t1, TreeNode t2) {
    int sum = 0;
    if (t1 != null) {
      sum += t1.val;
    }
    if (t2 != null) {
      sum += t2.val;
    }
    return sum;
  }
}

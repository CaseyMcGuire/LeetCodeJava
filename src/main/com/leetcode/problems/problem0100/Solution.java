package main.com.leetcode.problems.problem0100;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    else if (p == null || q == null) {
      return false;
    }
    return p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
  }
}

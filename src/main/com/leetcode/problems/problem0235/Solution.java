package main.com.leetcode.problems.problem0235;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode iter = root;
    while (true) {
      if (iter.val >= p.val && iter.val <= q.val || iter.val <= p.val && iter.val >= q.val) {
        return iter;
      }
      else if (iter.val < p.val && iter.val < q.val) {
        iter = iter.right;
      }
      else if (iter.val > p.val && iter.val > q.val) {
        iter = iter.left;
      }
    }
  }
}

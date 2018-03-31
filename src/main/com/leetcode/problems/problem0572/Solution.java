package main.com.leetcode.problems.problem0572;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (t == null || s == null) {
      return false;
    }
    if (isEqual(s, t)) {
      return true;
    }
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public boolean isEqual(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    return root1.val == root2.val && isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
  }

}

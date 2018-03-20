package main.com.leetcode.problems.problem0098;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode root, Integer min, Integer max) {
    if (root == null) {
      return true;
    }
    if (max != null && root.val >= max) {
      return false;
    }
    if (min != null && root.val <= min) {
      return false;
    }
    boolean isLeftValid = isValidBST(root.left, min, root.val);
    if (!isLeftValid) {
      return false;
    }
    return isValidBST(root.right, root.val, max);
  }
}

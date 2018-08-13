package main.com.leetcode.problems.problem0606;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public String tree2str(TreeNode t) {
    if (t == null) {
      return "";
    }
    StringBuilder builder = new StringBuilder();
    tree2str(t, builder);
    return builder.toString();
  }

  private void tree2str(TreeNode t, StringBuilder builder) {
    if (t == null) {
      return;
    }
    builder.append(t.val);

    if (t.left != null || t.right != null) {
      builder.append("(");
      tree2str(t.left, builder);
      builder.append(")");
    }

    if (t.right != null) {
      builder.append("(");
      tree2str(t.right, builder);
      builder.append(")");
    }
  }
}

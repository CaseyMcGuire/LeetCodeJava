package main.com.leetcode.problems.problem0144;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    preorderTraversal(root, values);
    return values;
  }

  private void preorderTraversal(TreeNode root, List<Integer> values) {
    if (root == null) {
      return;
    }
    values.add(root.val);
    preorderTraversal(root.left, values);
    preorderTraversal(root.right, values);
  }
}

package main.com.leetcode.problems.problem0094;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> values = new ArrayList<>();
    inorderTraversal(root, values);
    return values;
  }

  private void inorderTraversal(TreeNode node, List<Integer> values) {
    if (node == null) {
      return;
    }
    inorderTraversal(node.left, values);
    values.add(node.val);
    inorderTraversal(node.right, values);
  }
}

package main.com.leetcode.problems.problem0230;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int kthSmallest(TreeNode root, int k) {
    List<Integer> values = new ArrayList<>();
    kthSmallest(root, values);
    return values.get(k - 1);
  }

  public void kthSmallest(TreeNode node, List<Integer> values) {
    if (node == null) {
      return;
    }
    kthSmallest(node.left, values);
    values.add(node.val);
    kthSmallest(node.right, values);
  }
}

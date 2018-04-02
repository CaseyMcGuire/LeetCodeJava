package main.com.leetcode.problems.problem0783;

import main.com.leetcode.datastructures.TreeNode;

import java.util.TreeSet;

public class Solution {
  public int minDiffInBST(TreeNode root) {
    return minDiffInBst(root, new TreeSet<>());
  }

  private int minDiffInBst(TreeNode node, TreeSet<Integer> nodeValues) {
    if (node == null) {
      return Integer.MAX_VALUE;
    }
    int difference = Integer.MAX_VALUE;
    Integer greaterNodeVal = nodeValues.higher(node.val);
    if (greaterNodeVal != null) {
      difference = Math.min(difference, Math.abs(node.val - greaterNodeVal));
    }
    Integer lesserNodeVal = nodeValues.lower(node.val);
    if (lesserNodeVal != null) {
      difference = Math.min(difference, Math.abs(node.val - lesserNodeVal));
    }
    nodeValues.add(node.val);
    difference = Math.min(difference, minDiffInBst(node.left, nodeValues));
    return Math.min(difference, minDiffInBst(node.right, nodeValues));
  }
}

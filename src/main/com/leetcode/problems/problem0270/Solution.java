package main.com.leetcode.problems.problem0270;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int closestValue(TreeNode root, double target) {
    Integer lessThanClosest = null;
    Integer greaterThanClosest = null;
    Deque<TreeNode> nodeStack = new ArrayDeque<>();
    nodeStack.push(root);
    while (!nodeStack.isEmpty()) {
      TreeNode node = nodeStack.pop();
      if (node.val <= target) {
        if (lessThanClosest == null || node.val > lessThanClosest) {
          lessThanClosest = node.val;
        }
      }
      else {
        if (greaterThanClosest == null || node.val < greaterThanClosest) {
          greaterThanClosest = node.val;
        }
      }
      if (node.left != null) {
        nodeStack.push(node.left);
      }
      if (node.right != null) {
        nodeStack.push(node.right);
      }
    }
    if (lessThanClosest == null) {
      return greaterThanClosest;
    }
    else if (greaterThanClosest == null) {
      return lessThanClosest;
    }
    double lessThanDifference = target - lessThanClosest.doubleValue();
    double greaterThanDifference = greaterThanClosest.doubleValue() - target;
    return lessThanDifference < greaterThanDifference ? lessThanClosest : greaterThanClosest;
  }
}

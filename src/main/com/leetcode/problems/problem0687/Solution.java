package main.com.leetcode.problems.problem0687;

import main.com.leetcode.datastructures.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {


  public int longestUnivaluePath(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Set<TreeNode> visitedNodes = new HashSet<>();
    return longestUnivaluePath(root, visitedNodes);
  }

  private int longestUnivaluePath(TreeNode node, Set<TreeNode> visitedNodes) {
    if (node == null) {
      return 0;
    }
    int longestPath = 0;
    if(visitedNodes.add(node)) {
      longestPath = calculateLongestUnivaluePath(node, visitedNodes);
    }
    int leftPath = longestUnivaluePath(node.left, visitedNodes);
    int rightPath = longestUnivaluePath(node.right, visitedNodes);
    return leftPath > rightPath ? Math.max(leftPath, longestPath) : Math.max(rightPath, longestPath);
  }

  private int calculateLongestUnivaluePath(TreeNode node, Set<TreeNode> visitedNodes) {
    return calculateLongestUnivaluePath(node.left, visitedNodes, node.val, 0) + calculateLongestUnivaluePath(node.right, visitedNodes, node.val, 0);
  }

  private int calculateLongestUnivaluePath(TreeNode node, Set<TreeNode> visitedNodes, int value, int pathLength) {
    if (node == null || node.val != value) {
      return pathLength;
    }
    visitedNodes.add(node);
    return Math.max(calculateLongestUnivaluePath(node.left, visitedNodes, value, pathLength + 1), calculateLongestUnivaluePath(node.right, visitedNodes, value, pathLength + 1));
  }
}

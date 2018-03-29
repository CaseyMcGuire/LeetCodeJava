package main.com.leetcode.problems.problem0543;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {

  private Integer largestDiameterSoFar;
  public int diameterOfBinaryTree(TreeNode root) {
    largestDiameterSoFar = null;
    if (root == null) {
      return 0;
    }
    calculatePathLength(root);
    return largestDiameterSoFar;
  }

  private int calculatePathLength(TreeNode node) {

    int leftPathLength = node.left != null ? 1 + calculatePathLength(node.left) : 0;
    int rightPathLength = node.right != null ? 1 + calculatePathLength(node.right) : 0;
    int currentDiameter = leftPathLength + rightPathLength;
    if (largestDiameterSoFar == null || largestDiameterSoFar < currentDiameter) {
      largestDiameterSoFar = currentDiameter;
    }
    return leftPathLength > rightPathLength ? leftPathLength : rightPathLength;
  }
}

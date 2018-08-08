package main.com.leetcode.problems.problem0663;

import main.com.leetcode.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean checkEqualTree(TreeNode root) {
    if (root == null) {
      return false;
    }
    Map<TreeNode, Integer> nodeToSubtreeSum = getNodeToSubtreeSum(root);
    int totalSum = nodeToSubtreeSum.get(root);
    return checkEqualTree(root.right, totalSum, nodeToSubtreeSum) || checkEqualTree(root.left, totalSum, nodeToSubtreeSum);
  }

  private boolean checkEqualTree(TreeNode root, int totalSum, Map<TreeNode, Integer> nodeToSubtreeSum) {
    if (root == null) {
      return false;
    }
    int subtreeSum = nodeToSubtreeSum.get(root);
    int remainingSum = totalSum - subtreeSum;
    if (subtreeSum == remainingSum) {
      return true;
    }
    return checkEqualTree(root.right, totalSum, nodeToSubtreeSum) || checkEqualTree(root.left, totalSum, nodeToSubtreeSum);
  }

  private Map<TreeNode, Integer> getNodeToSubtreeSum(TreeNode root) {
    Map<TreeNode, Integer> nodeToSubtreeSum = new HashMap<>();
    getNodeToSubtreeSum(root, nodeToSubtreeSum);
    return nodeToSubtreeSum;
  }

  private int getNodeToSubtreeSum(TreeNode root, Map<TreeNode, Integer> nodeToSubtreeSum) {
    if (root == null) {
      return 0;
    }
    int leftSubtreeSum = getNodeToSubtreeSum(root.left, nodeToSubtreeSum);
    int rightSubtreeSum = getNodeToSubtreeSum(root.right, nodeToSubtreeSum);
    int totalSum = leftSubtreeSum + rightSubtreeSum + root.val;
    nodeToSubtreeSum.put(root, totalSum);
    return totalSum;
  }
}

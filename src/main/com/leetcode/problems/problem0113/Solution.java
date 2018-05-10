package main.com.leetcode.problems.problem0113;

import main.com.leetcode.datastructures.TreeNode;

import java.util.*;

public class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> paths = new ArrayList<>();
    pathSum(root, paths, new ArrayList<>(), 0, sum);
    return paths;
  }

  private void pathSum(TreeNode node, List<List<Integer>> paths, List<Integer> currentPath, int currentSum, int targetSum) {
    if (node == null) {
      return;
    }
    currentPath.add(node.val);
    currentSum += node.val;
    boolean isLeaf = node.left == null && node.right == null;
    if (isLeaf) {
      if (currentSum == targetSum) {
        paths.add(new ArrayList<>(currentPath));
      }
    }
    else {
      pathSum(node.left, paths, currentPath, currentSum, targetSum);
      pathSum(node.right, paths, currentPath, currentSum, targetSum);
    }
    currentPath.remove(currentPath.size() - 1);
  }
}

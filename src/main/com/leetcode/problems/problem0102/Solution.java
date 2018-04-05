package main.com.leetcode.problems.problem0102;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> levelOrderValues = new ArrayList<>();
    List<TreeNode> currentLevel = new ArrayList<>();
    List<TreeNode> nextLevel = new ArrayList<>();
    currentLevel.add(root);

    while (!currentLevel.isEmpty()) {
      List<Integer> currentLevelValues = new ArrayList<>();

      for (TreeNode node : currentLevel) {
        currentLevelValues.add(node.val);
        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }

      currentLevel = nextLevel;
      nextLevel = new ArrayList<>();
      levelOrderValues.add(currentLevelValues);
    }
    return levelOrderValues;
  }
}

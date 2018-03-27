package main.com.leetcode.problems.problem0637;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<Double> averageOfLevels(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Double> averagePerLevel = new ArrayList<>();
    List<TreeNode> curLevel = new ArrayList<>();
    List<TreeNode> nextLevel = new ArrayList<>();
    curLevel.add(root);
    while (!curLevel.isEmpty()) {
      double average = 0;
      for (TreeNode node : curLevel) {
        average += node.val;
        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }
      average = average / (double) curLevel.size();
      averagePerLevel.add(average);
      curLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }
    return averagePerLevel;
  }
}

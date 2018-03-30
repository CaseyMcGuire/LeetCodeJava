package main.com.leetcode.problems.problem0107;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    LinkedList<List<Integer>> levelValues = new LinkedList<>();
    List<TreeNode> curLevel = new ArrayList<>();
    List<TreeNode> nextLevel = new ArrayList<>();

    curLevel.add(root);
    while(!curLevel.isEmpty()) {
      List<Integer> curLevelValues = new ArrayList<>();
      for (TreeNode node : curLevel) {
        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
        curLevelValues.add(node.val);
      }
      levelValues.addFirst(curLevelValues);
      curLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }
    return levelValues;
  }
}

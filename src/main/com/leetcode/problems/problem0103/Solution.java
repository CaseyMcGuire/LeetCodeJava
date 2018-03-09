package main.com.leetcode.problems.problem0103;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    boolean moveRight = true;
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null) {
      return levels;
    }
    List<TreeNode> curLevel = Arrays.asList(root);
    List<TreeNode> nextLevel = new ArrayList<>();
    while (!curLevel.isEmpty()) {
      LinkedList<Integer> curLevelNums = new LinkedList<>();
      for (TreeNode node : curLevel) {
        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
        if (moveRight) {
          curLevelNums.add(node.val);
        }
        else {
          curLevelNums.addFirst(node.val);
        }
      }
      moveRight = !moveRight;
      levels.add(curLevelNums);
      curLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }
    return levels;
  }
}

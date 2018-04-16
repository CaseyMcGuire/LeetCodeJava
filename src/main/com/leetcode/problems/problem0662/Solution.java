package main.com.leetcode.problems.problem0662;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int widthOfBinaryTree(TreeNode root) {
    List<TreeLevelWidth> treeLevelWidths = new ArrayList<>();
    widthOfBinaryTree(root, 0, 0, treeLevelWidths);
    int maxWidth = -1;
    for (TreeLevelWidth treeLevelWidth : treeLevelWidths) {
      if (treeLevelWidth.getWidth() > maxWidth) {
        maxWidth = treeLevelWidth.getWidth();
      }
    }
    return maxWidth;
  }

  private void widthOfBinaryTree(TreeNode node, int treeLevel, int index, List<TreeLevelWidth> treeLevelWidths) {
    if (node == null) {
      return;
    }
    if (treeLevel == treeLevelWidths.size()) {
      TreeLevelWidth treeLevelWidth = new TreeLevelWidth(index, index);
      treeLevelWidths.add(treeLevelWidth);
    }
    else {
      TreeLevelWidth treeLevelWidth = treeLevelWidths.get(treeLevel);
      if (index < treeLevelWidth.leftMostIndex) {
        treeLevelWidth.leftMostIndex = index;
      }
      else if (index > treeLevelWidth.rightMostIndex) {
        treeLevelWidth.rightMostIndex = index;
      }
    }
    int newLeftIndex = 2 * index;
    widthOfBinaryTree(node.left, treeLevel + 1, newLeftIndex, treeLevelWidths);
    widthOfBinaryTree(node.right, treeLevel + 1, newLeftIndex + 1, treeLevelWidths);
  }

  private static class TreeLevelWidth {
    int leftMostIndex;
    int rightMostIndex;

    TreeLevelWidth(int leftMostIndex, int rightMostIndex) {
      this.leftMostIndex = leftMostIndex;
      this.rightMostIndex = rightMostIndex;
    }

    int getWidth() {
      return rightMostIndex - leftMostIndex + 1;
    }
  }
}

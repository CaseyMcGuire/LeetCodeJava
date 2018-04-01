package main.com.leetcode.problems.problem0513;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  private Integer currentLeftMaxDepth;
  private Integer currentLeftMaxTilt;
  private Integer currentMaxVal;
  public int findBottomLeftValue(TreeNode root) {
    findBottomLeftValue(root, 0, 0);
    return currentMaxVal;
  }

  private void findBottomLeftValue(TreeNode node, int currentDepth, int currentTilt) {
    if (node == null) {
      return;
    }
    boolean isLeaf = node.right == null && node.left == null;
    if (isLeaf) {
      if (currentLeftMaxDepth == null ||
          currentDepth > currentLeftMaxDepth ||
          currentLeftMaxDepth == currentTilt && currentTilt < currentLeftMaxTilt) {
        currentLeftMaxDepth = currentDepth;
        currentLeftMaxTilt = currentTilt;
        currentMaxVal = node.val;
      }
    }
    else {
      findBottomLeftValue(node.left, currentDepth + 1, currentTilt - 1);
      findBottomLeftValue(node.right, currentDepth + 1, currentTilt + 1);
    }
  }
}

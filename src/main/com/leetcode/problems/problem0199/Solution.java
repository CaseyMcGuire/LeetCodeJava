package main.com.leetcode.problems.problem0199;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightMostNodeValues = new ArrayList<>();
    rightSideView(root, 0, rightMostNodeValues);
    return rightMostNodeValues;
  }

  private void rightSideView(TreeNode root, int depth, List<Integer> rightMostNodes) {
    if (root == null) {
      return;
    }
    if (rightMostNodes.size() == depth) {
      rightMostNodes.add(root.val);
    }
    rightSideView(root.right, depth + 1, rightMostNodes);
    rightSideView(root.left, depth + 1, rightMostNodes);
  }
}

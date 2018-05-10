package main.com.leetcode.problems.problem0129;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  public int sumNumbers(TreeNode root) {
    return sumNumbers(root, new StringBuilder());
  }

  private int sumNumbers(TreeNode root, StringBuilder currentNum) {
    if (root == null) {
      return 0;
    }
    currentNum.append(root.val);
    boolean isLeaf = root.left == null && root.right == null;
    if (isLeaf) {
      int sum = convertToNum(currentNum);
      currentNum.deleteCharAt(currentNum.length() - 1);
      return sum;
    }
    else {
      int sum = sumNumbers(root.left, currentNum) + sumNumbers(root.right, currentNum);
      currentNum.deleteCharAt(currentNum.length() - 1);
      return sum;
    }
  }

  private int convertToNum(StringBuilder num) {
    return Integer.parseInt(num.toString());
  }
}
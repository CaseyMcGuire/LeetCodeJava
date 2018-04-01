package main.com.leetcode.problems.problem0654;

import main.com.leetcode.datastructures.TreeNode;


public class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaximumBinaryTree(nums, 0, nums.length - 1);
  }

  private TreeNode constructMaximumBinaryTree(int[] nums, int from, int to) {
    if (from > to) {
      return null;
    }
    Integer maxIndex = null;
    Integer maxNum = null;
    for (int i = from; i <= to; i++) {
      if (maxIndex == null || maxNum < nums[i]) {
        maxNum = nums[i];
        maxIndex = i;
      }
    }
    TreeNode root = new TreeNode(nums[maxIndex]);
    root.left = constructMaximumBinaryTree(nums, from, maxIndex - 1);
    root.right = constructMaximumBinaryTree(nums, maxIndex + 1, to);
    return root;
  }
}

package main.com.leetcode.problems.problem0108;

import main.com.leetcode.datastructures.TreeNode;


public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    TreeNode tree = sortedArrayToBST(nums, 0, nums.length - 1);
    return tree;
  }

  private TreeNode sortedArrayToBST(int[] nums, int from, int to) {
    if (from > to) {
      return null;
    }
    int middle = (from + to) / 2;
    TreeNode node = new TreeNode(nums[middle]);
    node.left = sortedArrayToBST(nums, from, middle - 1);
    node.right = sortedArrayToBST(nums, middle + 1, to);
    return node;
  }
}

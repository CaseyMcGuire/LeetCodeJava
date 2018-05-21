package main.com.leetcode.problems.problem0298;

import main.com.leetcode.datastructures.TreeNode;

public class Solution {
  Integer longestConsecutiveSequence;
  public int longestConsecutive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    longestConsecutiveSequence = 1;
    findLongestConsecutiveSequence(root.left, 1, root.val);
    findLongestConsecutiveSequence(root.right, 1, root.val);
    return longestConsecutiveSequence;
  }

  private void findLongestConsecutiveSequence(TreeNode node, int lengthOfCurrentSequence, int lastNum) {
    if (lengthOfCurrentSequence > longestConsecutiveSequence) {
      longestConsecutiveSequence = lengthOfCurrentSequence;
    }
    if (node == null) {
      return;
    }
    boolean continuesSequence = node.val - 1 == lastNum;
    if (continuesSequence) {
      lengthOfCurrentSequence++;
    }
    else {
      lengthOfCurrentSequence = 1;
    }
    findLongestConsecutiveSequence(node.left, lengthOfCurrentSequence, node.val);
    findLongestConsecutiveSequence(node.right, lengthOfCurrentSequence, node.val);
  }
}

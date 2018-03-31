package main.com.leetcode.problems.problem0437;

import main.com.leetcode.datastructures.TreeNode;

import java.util.*;

public class Solution {

  public int pathSum(TreeNode root, int sum) {
    return pathSum(root, sum, Collections.emptyList());
  }

  private int pathSum(TreeNode root, int sum, List<Integer> pathSums) {
    if (root == null) {
      return 0;
    }
    int numCorrectPathSum = root.val == sum ? 1 : 0;
    List<Integer> newPathSums = new ArrayList<>();
    for (int pathSum : pathSums) {
      int newPathSum = root.val + pathSum;
      if (newPathSum == sum) {
        numCorrectPathSum++;
      }
      newPathSums.add(newPathSum);
    }
    newPathSums.add(root.val);
    return numCorrectPathSum + pathSum(root.left, sum, newPathSums) + pathSum(root.right, sum, newPathSums);
  }

}

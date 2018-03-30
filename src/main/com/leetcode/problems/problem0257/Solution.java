package main.com.leetcode.problems.problem0257;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    List<Integer> valsInPath = new ArrayList<>();
    if (root == null) {
      return Collections.emptyList();
    }
    binaryTreePaths(root, valsInPath, paths);
    return paths;
  }

  private void binaryTreePaths(TreeNode node, List<Integer> valsInPath, List<String> paths) {
    if (node == null) {
      return;
    }
    valsInPath.add(node.val);
    if (node.left == null && node.right == null) {
      paths.add(convertValsInPath(valsInPath));
    }
    else {
      binaryTreePaths(node.left, valsInPath, paths);
      binaryTreePaths(node.right, valsInPath, paths);
    }
    valsInPath.remove(valsInPath.size() - 1);
  }

  private String convertValsInPath(List<Integer> valsInPath) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < valsInPath.size(); i++) {
      boolean isLast = i == valsInPath.size() - 1;
      builder.append(valsInPath.get(i));
      if (!isLast) {
        builder.append("->");
      }
    }
    return builder.toString();
  }

}

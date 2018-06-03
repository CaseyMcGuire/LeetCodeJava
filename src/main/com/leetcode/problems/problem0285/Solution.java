package main.com.leetcode.problems.problem0285;

import main.com.leetcode.datastructures.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) {
      return null;
    }
    List<TreeNode> inorder = new ArrayList<>();
    inorderSuccessor(root, inorder);
    List<Integer> inorderValues = inorder.stream().map(node -> node.val).collect(Collectors.toList());
    int index = Collections.binarySearch(inorderValues, p.val);
    if (index < 0 || index >= inorderValues.size() - 1) {
      return null;
    }
    return inorder.get(index + 1);
  }

  private void inorderSuccessor(TreeNode node, List<TreeNode> inorder) {
    if (node == null) {
      return;
    }
    inorderSuccessor(node.left, inorder);
    inorder.add(node);
    inorderSuccessor(node.right, inorder);
  }
}

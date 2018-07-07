package main.com.leetcode.problems.problem0105;

import main.com.leetcode.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    Map<Integer, Integer> inorderNumToIndex = getNumToIndex(inorder);
    TreeNode root = buildTree(preorder, new IntReference(0), 0, inorder.length, inorder, inorderNumToIndex);
    return root;
  }

  private TreeNode buildTree(int[] preorder, IntReference preorderIndex, int inorderStart, int inorderEnd, int[] inorder, Map<Integer, Integer> inorderNumToIndex) {
    if (preorderIndex.i == preorder.length || inorderStart >= inorderEnd) {
      return null;
    }
    int num = preorder[preorderIndex.i];
    TreeNode root = new TreeNode(num);
    preorderIndex.i++;
    int inorderIndex = inorderNumToIndex.get(num);
    root.left = buildTree(preorder, preorderIndex, inorderStart, inorderIndex, inorder, inorderNumToIndex);
    root.right = buildTree(preorder, preorderIndex, inorderIndex + 1, inorderEnd, inorder, inorderNumToIndex);
    return root;
  }

  private Map<Integer, Integer> getNumToIndex(int[] array) {
    Map<Integer, Integer> numToIndex = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      numToIndex.put(array[i], i);
    }
    return numToIndex;
  }

  private static class IntReference {
    int i;
    IntReference(int i) {
      this.i = i;
    }
  }
}

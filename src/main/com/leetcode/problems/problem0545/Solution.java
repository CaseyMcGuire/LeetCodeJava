package main.com.leetcode.problems.problem0545;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> boundary = new ArrayList<>();
    boundary.add(root.val);
    if (isLeaf(root)) {
      return boundary;
    }
    collectBoundaryNodes(root.left, true, boundary);
    collectLeafNodesLeftToRight(root, boundary);
    collectBoundaryNodes(root.right, false, boundary);
    return boundary;
  }

  private void collectBoundaryNodes(TreeNode root, boolean isLeft, List<Integer> boundary) {
    if (root == null || isLeaf(root)) {
      return;
    }

    if (isLeft) {
      boundary.add(root.val);
      if (root.left != null) {
        collectBoundaryNodes(root.left, isLeft, boundary);
      }
      else {
        collectBoundaryNodes(root.right, isLeft, boundary);
      }
    }
    else {
      if (root.right != null) {
        collectBoundaryNodes(root.right, isLeft, boundary);
      }
      else {
        collectBoundaryNodes(root.left, isLeft, boundary);
      }
      boundary.add(root.val);
    }
  }

  private void collectLeafNodesLeftToRight(TreeNode node, List<Integer> boundary) {
    if (node == null) {
      return;
    }
    if (isLeaf(node)) {
      boundary.add(node.val);
    }
    else {
      collectLeafNodesLeftToRight(node.left, boundary);
      collectLeafNodesLeftToRight(node.right, boundary);
    }
  }

  private boolean isLeaf(TreeNode node) {
    return node.right == null && node.left == null;
  }
}

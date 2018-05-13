package main.com.leetcode.problems.problem0173;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

  private Deque<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new ArrayDeque<>();
    addLeftNodes(root);
  }

  private void addLeftNodes(TreeNode root) {

    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode curNode = stack.pop();
    if (curNode.right != null) {
      addLeftNodes(curNode.right);
    }
    return curNode.val;
  }
}

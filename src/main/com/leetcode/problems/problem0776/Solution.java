package main.com.leetcode.problems.problem0776;

import main.com.leetcode.datastructures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
  public TreeNode[] splitBST(TreeNode root, int V) {
    if (root == null) {
      return new TreeNode[]{null, null};
    }
    TreeNode lessThanRoot = null;
    TreeNode greaterThanRoot = null;
    Deque<TreeNode> pending = new LinkedList<>();
    pending.addLast(root);
    while (!pending.isEmpty()) {
      TreeNode cur = pending.removeFirst();
      if (cur.val <= V) {
        lessThanRoot = insert(lessThanRoot, cur.val);
      }
      else {
        greaterThanRoot = insert(greaterThanRoot, cur.val);
      }

      if (cur.right != null) {
        pending.addLast(cur.right);
      }

      if (cur.left != null) {
        pending.addLast(cur.left);
      }
    }
    return new TreeNode[]{lessThanRoot, greaterThanRoot};
  }

  private TreeNode insert(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    TreeNode cur = root;
    while (true) {
      if (val > cur.val) {
        if (cur.right == null) {
          cur.right = new TreeNode(val);
          break;
        }
        else {
          cur = cur.right;
        }
      }
      else {
        if (cur.left == null) {
          cur.left = new TreeNode(val);
          break;
        }
        else {
          cur = cur.left;
        }
      }
    }
    return root;
  }
}

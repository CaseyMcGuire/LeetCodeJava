package main.com.leetcode.problems.problem0101;

import main.com.leetcode.datastructures.TreeNode;
import java.util.LinkedList;

public class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    LinkedList<TreeNode> curLevelLeft = new LinkedList<>();
    LinkedList<TreeNode> nextLevelLeft = new LinkedList<>();
    LinkedList<TreeNode> curLevelRight = new LinkedList<>();
    LinkedList<TreeNode> nextLevelRight = new LinkedList<>();

    boolean isRootSymmetric = areSymmetricNodes(root.left, root.right);
    if (!isRootSymmetric) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return true;
    }
    curLevelLeft.add(root.left);
    curLevelRight.add(root.right);

    while (!curLevelLeft.isEmpty() && !curLevelRight.isEmpty()) {
      for (int i = 0, j = curLevelRight.size() - 1; i < curLevelLeft.size(); i++, j--) {
        TreeNode left = curLevelLeft.get(i);
        TreeNode right = curLevelRight.get(j);
        if (!areSymmetricNodes(left.left, right.right) || !areSymmetricNodes(left.right, right.left)) {
          return false;
        }
        if (left.left != null && right.right != null) {
          nextLevelLeft.add(left.left);
          nextLevelRight.addFirst(right.right);
        }
        if (left.right != null && right.left != null) {
          nextLevelLeft.add(left.right);
          nextLevelRight.addFirst(right.left);
        }
      }
      curLevelLeft = nextLevelLeft;
      curLevelRight = nextLevelRight;
      nextLevelLeft = new LinkedList<>();
      nextLevelRight = new LinkedList<>();
    }
    return true;
  }

  private boolean areSymmetricNodes(TreeNode left, TreeNode right) {
    return left == null && right == null
        || left != null && right != null && left.val == right.val;
  }
}

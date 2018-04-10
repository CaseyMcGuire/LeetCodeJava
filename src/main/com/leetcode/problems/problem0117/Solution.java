package main.com.leetcode.problems.problem0117;

import main.com.leetcode.datastructures.TreeLinkNode;

public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    TreeLinkNode currentLevelLeftMostNode = root;
    while (currentLevelLeftMostNode != null) {
      currentLevelLeftMostNode = connectNextLevel(currentLevelLeftMostNode);
    }
  }

  private TreeLinkNode connectNextLevel(TreeLinkNode currentLevelLeftMostNode) {
    TreeLinkNode curIter = currentLevelLeftMostNode;
    TreeLinkNode nextIter = null;
    TreeLinkNode headOfNextLevel = null;
    while (curIter != null) {
      if (curIter.left != null) {
        if (nextIter == null) {
          nextIter = curIter.left;
          headOfNextLevel = curIter.left;
        }
        else {
          nextIter.next = curIter.left;
          nextIter = nextIter.next;
        }
      }
      if (curIter.right != null) {
        if (nextIter == null) {
          nextIter = curIter.right;
          headOfNextLevel = curIter.right;
        }
        else {
          nextIter.next = curIter.right;
          nextIter = nextIter.next;
        }
      }
      curIter = curIter.next;
    }
    return headOfNextLevel;
  }
}

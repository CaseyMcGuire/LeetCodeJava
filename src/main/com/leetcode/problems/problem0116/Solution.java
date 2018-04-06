package main.com.leetcode.problems.problem0116;

import main.com.leetcode.datastructures.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    List<TreeLinkNode> curLevel = new ArrayList<>();
    List<TreeLinkNode> nextLevel = new ArrayList<>();
    curLevel.add(root);
    while (!curLevel.isEmpty()) {
      for (int i = 0; i < curLevel.size(); i++) {
        TreeLinkNode curNode = curLevel.get(i);
        boolean isLastNode = i == curLevel.size() - 1;
        if (!isLastNode) {
          curNode.next = curLevel.get(i + 1);
        }
        if (curNode.left != null) {
          nextLevel.add(curNode.left);
        }
        if (curNode.right != null) {
          nextLevel.add(curNode.right);
        }
      }
      curLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }
  }
}

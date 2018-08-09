package main.com.leetcode.problems.problem0426;


import java.util.ArrayList;
import java.util.List;

class Solution {
  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    List<Node> nodes = getNodes(root);
    for (int i = 0; i < nodes.size(); i++) {
      Node curNode = nodes.get(i);
      if (i == 0) {
        curNode.left = nodes.get(nodes.size() - 1);
      }
      else {
        curNode.left = nodes.get(i - 1);
      }

      if (i == nodes.size() - 1) {
        curNode.right = nodes.get(0);
      }
      else {
        curNode.right = nodes.get(i + 1);
      }

    }

    return nodes.get(0);
  }

  private List<Node> getNodes(Node root) {
    List<Node> nodes = new ArrayList<>();
    getNodes(root, nodes);
    return nodes;
  }

  private void getNodes(Node root, List<Node> nodes) {
    if (root == null) {
      return;
    }
    getNodes(root.left, nodes);
    nodes.add(root);
    getNodes(root.right, nodes);
  }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }

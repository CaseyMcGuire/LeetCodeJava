package main.com.leetcode.problems.problem0742;


import main.com.leetcode.datastructures.TreeNode;

import java.util.*;

public class Solution {
  public int findClosestLeaf(TreeNode root, int k) {
    List<TreeNode> path = findPathToNode(root, k);
    LeafDistancePair shortestSoFar = null;
    Set<TreeNode> visited = new HashSet<>();
    int length = path.size();
    for (int i = 0; i < length; i++) {
      LeafDistancePair current = findShortestDistanceToLeaf(path.get(path.size() - i - 1), visited);
      if (current == null) {
        continue;
      }
      //we have to adjust for edges as we move up the path
      current.distanceFromNode += i;
      if (shortestSoFar == null || current.distanceFromNode < shortestSoFar.distanceFromNode) {
        shortestSoFar = current;
      }
    }
    return shortestSoFar.valueInLeaf;
  }


  private LeafDistancePair findShortestDistanceToLeaf(TreeNode node, Set<TreeNode> visitedNodes) {
    if (node == null || visitedNodes.contains(node)) {
      return null;
    }
    visitedNodes.add(node);
    if (isLeaf(node)) {
      return new LeafDistancePair(1, node.val);
    }
    LeafDistancePair left = findShortestDistanceToLeaf(node.left, visitedNodes);
    LeafDistancePair right = findShortestDistanceToLeaf(node.right, visitedNodes);
    LeafDistancePair shorter = getShorter(left, right);
    if (shorter != null) {
      shorter.distanceFromNode++;
    }
    return shorter;
  }

  private LeafDistancePair getShorter(LeafDistancePair first, LeafDistancePair second) {
    if (first == null) {
      return second;
    }
    else if (second == null) {
      return first;
    }
    return first.distanceFromNode < second.distanceFromNode ? first : second;
  }

  private List<TreeNode> findPathToNode(TreeNode root, int k) {
    PathToNode p = new PathToNode();
    findPathToNode(root, new ArrayList<>(), k, p);
    return p.path;
  }

  private void findPathToNode(TreeNode node, List<TreeNode> currentPath, int k, PathToNode pathToNode) {
    if (pathToNode.hasPath() || node == null) {
      return;
    }
    currentPath.add(node);
    if (node.val == k) {
      pathToNode.setPath(new ArrayList<>(currentPath));
    }
    findPathToNode(node.left, currentPath, k, pathToNode);
    findPathToNode(node.right, currentPath, k, pathToNode);
    currentPath.remove(currentPath.size() - 1);
  }

  private void pushToBottom(Deque<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }

  private static class LeafDistancePair {
    int distanceFromNode;
    int valueInLeaf;
    LeafDistancePair(int distanceFromNode, int valueInLeaf) {
      this.distanceFromNode = distanceFromNode;
      this.valueInLeaf = valueInLeaf;
    }
  }

  private static class PathToNode {
    List<TreeNode> path;
    PathToNode() {
      path = null;
    }

    boolean hasPath() {
      return path != null;
    }

    void setPath(List<TreeNode> path) {
      this.path = path;
    }
  }
}

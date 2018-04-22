package main.com.leetcode.problems.problem0207;

import java.util.*;

public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Node> nodes = new ArrayList<>();
    Set<Integer> unvisitedNodes = new HashSet<>();

    for (int i = 0; i < numCourses; i++) {
      nodes.add(new Node(i));
      unvisitedNodes.add(i);
    }

    for (int[] pairs : prerequisites) {
      Node from = nodes.get(pairs[0]);
      Node to = nodes.get(pairs[1]);
      from.edges.add(to);
    }

    for (int i = 0; i < numCourses; i++) {
      if (unvisitedNodes.contains(i)) {
        Node curNode = nodes.get(i);
        boolean hasCycle = hasCycle(curNode, unvisitedNodes, new HashSet<>());
        if (hasCycle) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean hasCycle(Node root, Set<Integer> unvisitedNodes, Set<Node> visitedNodes) {
    visitedNodes.add(root);
    unvisitedNodes.remove(root.index);
    for (Node neighbor : root.edges) {
      if (visitedNodes.contains(neighbor)) {
        return true;
      }
      boolean hasCycle = hasCycle(neighbor, unvisitedNodes, visitedNodes);
      if (hasCycle) {
        return true;
      }
    }
    visitedNodes.remove(root);
    return false;
  }

  private static class Node {
    private List<Node> edges;
    private int index;

    public Node(int index) {
      this.index = index;
      edges = new ArrayList<>();
    }
  }

}

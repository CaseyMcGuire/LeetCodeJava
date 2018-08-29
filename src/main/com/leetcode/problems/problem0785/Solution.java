package main.com.leetcode.problems.problem0785;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public boolean isBipartite(int[][] graph) {
    Map<Integer, Set<Integer>> nodeToNeighbors = getNodeToNeighbors(graph);
    return isBipartite(nodeToNeighbors);
  }

  private boolean isBipartite(Map<Integer, Set<Integer>> nodeToNeighbor) {
    Map<Integer, Color> nodeToColor = new HashMap<>();
    for (Integer node : nodeToNeighbor.keySet()) {
      if (!isBipartite(node, Color.WHITE, nodeToNeighbor, nodeToColor)) {
        return false;
      }
    }
    return true;
  }

  private boolean isBipartite(int currentNode, Color currentColor, Map<Integer, Set<Integer>> nodeToNeighbor, Map<Integer, Color> nodeToColor) {
    if (nodeToColor.containsKey(currentNode)) {
      return true;
    }
    nodeToColor.put(currentNode, currentColor);
    Set<Integer> neighborsForCurrentNode = nodeToNeighbor.get(currentNode);
    Color otherColor = getOtherColor(currentColor);
    for (Integer neighbor : neighborsForCurrentNode) {
      if (nodeToColor.get(neighbor) == currentColor || !isBipartite(neighbor, otherColor, nodeToNeighbor, nodeToColor)) {
        return false;
      }
    }
    return true;
  }

  private Color getOtherColor(Color color) {
    return color == Color.WHITE ? Color.BLACK : Color.WHITE;
  }

  private Map<Integer, Set<Integer>> getNodeToNeighbors(int[][] graph) {
    Map<Integer, Set<Integer>> nodeToNeighbors = new HashMap<>();
    for (int i = 0; i < graph.length; i++) {
      Set<Integer> neighbors = new HashSet<>();
      for (int j = 0; j < graph[i].length; j++) {
        neighbors.add(graph[i][j]);
      }
      nodeToNeighbors.put(i, neighbors);
    }
    return nodeToNeighbors;
  }

  private enum Color {
    WHITE,
    BLACK
  }
}

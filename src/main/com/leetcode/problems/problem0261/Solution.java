package main.com.leetcode.problems.problem0261;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public boolean validTree(int n, int[][] edges) {
    if (n == 1 && edges.length == 0) {
      return true;
    }
    if (edges.length + 1 != n) {
      return false;
    }
    Map<Integer, Set<Integer>> nodeToNeighbors = getNodeToNeighborsMap(edges);
    return validTree(n, nodeToNeighbors);
  }

  private boolean validTree(int n, Map<Integer, Set<Integer>> nodeToNeighbors) {
    Set<Integer> allVisitedNodes = new HashSet<>();
    boolean validTree = validTree(nodeToNeighbors, -1, 0, new HashSet<>(), allVisitedNodes);
    return validTree && allVisitedNodes.size() == n;
  }

  private boolean validTree(Map<Integer, Set<Integer>> nodeToNeighbors,
                            int previousNode,
                            int currentNode,
                            Set<Integer> visitedNodesInCurrentPath,
                            Set<Integer> allVisitedNodes) {
    if (visitedNodesInCurrentPath.contains(currentNode)) {
      return false;
    }
    visitedNodesInCurrentPath.add(currentNode);
    allVisitedNodes.add(currentNode);
    Set<Integer> neighbors = nodeToNeighbors.get(currentNode);
    if (neighbors == null) {
      return false;
    }
    if (previousNode != -1 && neighbors.size() == 1) {
      return true;
    }

    for (int neighbor : neighbors) {
      if (neighbor == previousNode) {
        continue;
      }
      if (neighbor == currentNode) {
        return false;
      }
      if (!validTree(nodeToNeighbors, currentNode, neighbor, visitedNodesInCurrentPath, allVisitedNodes)) {
        return false;
      }
    }
    visitedNodesInCurrentPath.remove(currentNode);
    return true;
  }



  private Map<Integer, Set<Integer>> getNodeToNeighborsMap(int[][] edges) {
    Map<Integer, Set<Integer>> nodeToNeighbors = new HashMap<>();
    for (int[] edge : edges) {
      Set<Integer> firstNeighbors = nodeToNeighbors.getOrDefault(edge[0], new HashSet<>());
      Set<Integer> secondNeighbors = nodeToNeighbors.getOrDefault(edge[1], new HashSet<>());
      firstNeighbors.add(edge[1]);
      secondNeighbors.add(edge[0]);
      nodeToNeighbors.put(edge[0], firstNeighbors);
      nodeToNeighbors.put(edge[1], secondNeighbors);
    }
    return nodeToNeighbors;
  }
}

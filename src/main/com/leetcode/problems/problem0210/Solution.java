package main.com.leetcode.problems.problem0210;

import java.util.*;

public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> nodeToNeighbors = createNodeToEdgeMap(numCourses, prerequisites);
    Deque<Integer> orderedCourses = new LinkedList<>();
    Set<Integer> temporary = new HashSet<>();
    Set<Integer> permanent = new HashSet<>();
    for (int i = 0; i < numCourses; i++) {
      boolean containsCycle = visit(i, nodeToNeighbors, temporary, permanent, orderedCourses);
      if (containsCycle) {
        return new int[]{};
      }
    }
    int[] ordered = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      ordered[i] = orderedCourses.removeFirst();
    }
    return ordered;
  }


  private boolean visit(int node, Map<Integer, Set<Integer>> nodeToNeighbor, Set<Integer> temporary, Set<Integer> permanent, Deque<Integer> order) {
    if (permanent.contains(node)) {
      return false;
    }
    if (temporary.contains(node)) {
      return true;
    }
    temporary.add(node);
    for (int neighbor : nodeToNeighbor.get(node)) {
      boolean containsCycle = visit(neighbor, nodeToNeighbor, temporary, permanent, order);
      if (containsCycle) {
        return containsCycle;
      }
    }
    permanent.add(node);
    order.addFirst(node);
    return false;
  }

  private Map<Integer, Set<Integer>> createNodeToEdgeMap(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> nodeToNeighbors = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      nodeToNeighbors.put(i, new HashSet<>());
    }
    for (int[] edge : prerequisites) {
      int prerequisite = edge[1];
      int successor = edge[0];
      Set<Integer> neighbors = nodeToNeighbors.get(prerequisite);
      neighbors.add(successor);
    }
    return nodeToNeighbors;
  }
}

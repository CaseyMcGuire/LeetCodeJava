package main.com.leetcode.problems.problem0277;

import java.util.*;

public class Solution extends Relation {
  public int findCelebrity(int n) {
    Map<Integer, Set<Integer>> nodeToEdges = new HashMap<>();
    List<Integer> possibleCelebrities = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      Set<Integer> edges = new HashSet<>();
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (knows(i, j)) {
          edges.add(j);
        }
      }
      nodeToEdges.put(i, edges);
      if (edges.isEmpty()) {
        possibleCelebrities.add(i);
      }
    }
    for (int possibleCelebrity : possibleCelebrities) {
      if (isCelebrity(possibleCelebrity, nodeToEdges)) {
        return possibleCelebrity;
      }
    }
    return -1;
  }

  private boolean isCelebrity(int candidate, Map<Integer, Set<Integer>> nodeToEdges) {
    for (Map.Entry<Integer, Set<Integer>> entry : nodeToEdges.entrySet()) {
      if (entry.getKey() == candidate) {
        continue;
      }
      if (!entry.getValue().contains(candidate)) {
        return false;
      }
    }
    return true;
  }
}



class Relation {
  boolean knows(int a, int b) {
    return false;
  }
}

package main.com.leetcode.problems.problem0133;

import main.com.leetcode.datastructures.UndirectedGraphNode;

import java.util.*;

public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    Map<Integer, UndirectedGraphNode> labelToNode = new HashMap<>();
    Deque<UndirectedGraphNode> pendingNodes = new ArrayDeque<>();
    Set<UndirectedGraphNode> visitedNodes = new HashSet<>();
    pendingNodes.push(node);
    visitedNodes.add(node);
    while (!pendingNodes.isEmpty()) {
      UndirectedGraphNode currentNode = pendingNodes.pop();
      if (labelToNode.containsKey(currentNode.label)) {
        continue;
      }
      labelToNode.put(currentNode.label, currentNode);
      for (UndirectedGraphNode neighbor : currentNode.neighbors) {
        if (!visitedNodes.contains(neighbor)) {
          pendingNodes.push(neighbor);
          visitedNodes.add(neighbor);
        }
      }
    }

    Map<Integer, UndirectedGraphNode> clonedLabelToNode = new HashMap<>();
    for (Map.Entry<Integer, UndirectedGraphNode> entry : labelToNode.entrySet()) {
      clonedLabelToNode.put(entry.getKey(), new UndirectedGraphNode(entry.getKey()));
    }

    for (Map.Entry<Integer, UndirectedGraphNode> entry : labelToNode.entrySet()) {
      UndirectedGraphNode clonedNode = clonedLabelToNode.get(entry.getKey());
      for (UndirectedGraphNode neighbor : entry.getValue().neighbors) {
        UndirectedGraphNode clonedNeighbor = clonedLabelToNode.get(neighbor.label);
        clonedNode.neighbors.add(clonedNeighbor);
      }
    }
    return clonedLabelToNode.get(node.label);
  }
}

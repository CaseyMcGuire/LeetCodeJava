package main.com.leetcode.problems.problem0366;

import main.com.leetcode.datastructures.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public List<List<Integer>> findLeaves(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
    Set<TreeNode> leaves = new HashSet<>();
    createNodeToParentMap(nodeToParent, root, null);
    List<List<Integer>> leafLevels = new ArrayList<>();
    List<TreeNode> currentLevelOfLeaves = new ArrayList<>();
    for (Map.Entry<TreeNode, TreeNode> entry : nodeToParent.entrySet()) {
      if (isLeaf(entry.getKey(), leaves)) {
        currentLevelOfLeaves.add(entry.getKey());
      }
    }
    while (!currentLevelOfLeaves.isEmpty()) {
      List<Integer> currentLevelNums = currentLevelOfLeaves.stream()
                                                           .map(node -> node.val)
                                                           .collect(Collectors.toList());
      leafLevels.add(currentLevelNums);
      currentLevelOfLeaves = getNextLevelOfLeaves(currentLevelOfLeaves, leaves, nodeToParent);
    }
    return leafLevels;
  }

  private List<TreeNode> getNextLevelOfLeaves(List<TreeNode> currentLevelOfLeaves,
                                              Set<TreeNode> leaves,
                                              Map<TreeNode, TreeNode> nodeToParent) {
    leaves.addAll(currentLevelOfLeaves);
    Set<TreeNode> nextLevel = new HashSet<>();
    for (TreeNode node : currentLevelOfLeaves) {
      TreeNode parent = nodeToParent.get(node);
      boolean isLeaf = parent != null && isLeaf(parent, leaves);
      if (isLeaf) {
        nextLevel.add(parent);
      }
    }
    return new ArrayList<>(nextLevel);
  }

  private boolean isLeaf(TreeNode node, Set<TreeNode> leaves) {
    return (node.left == null || leaves.contains(node.left)) &&
           (node.right == null || leaves.contains(node.right));
  }

  private void createNodeToParentMap(Map<TreeNode, TreeNode> nodeToParent, TreeNode node, TreeNode parent) {
    if (node == null) {
      return;
    }
    nodeToParent.put(node, parent);
    createNodeToParentMap(nodeToParent, node.left, node);
    createNodeToParentMap(nodeToParent, node.right, node);
  }
}

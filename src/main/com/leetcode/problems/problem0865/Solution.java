package main.com.leetcode.problems.problem0865;

import main.com.leetcode.datastructures.TreeNode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null && root.right == null) {
      return root;
    }
    Set<Integer> deepestNodeValues = getDeepestNodeValues(root);
    TreeNode iter = root;
    while (true) {
      if (deepestNodeValues.contains(iter.val)) {
        return iter;
      }
      Set<Integer> leftDeepest = getDeepestNodeValues(iter.left);
      boolean anyIntersectionOnLeft = intersects(deepestNodeValues, leftDeepest);
      boolean foundDeepestNodeSubtree = anyIntersectionOnLeft && leftDeepest.size() != deepestNodeValues.size();
      if (foundDeepestNodeSubtree) {
        return iter;
      }
      else if (anyIntersectionOnLeft) {
        iter = iter.left;
      }
      else {
        iter = iter.right;
      }
    }
  }

  private boolean intersects(Set<Integer> first, Set<Integer> second) {
    for (int num : first) {
      if (second.contains(num)) {
        return true;
      }
    }
    return false;
  }

  private Set<Integer> getDeepestNodeValues(TreeNode root) {
    TreeMap<Integer, Set<Integer>> depthToNodes = new TreeMap<>();
    findDeepestNodeValues(root, 0, depthToNodes);
    if (depthToNodes.isEmpty()) {
      return Collections.emptySet();
    }
    else {
      return depthToNodes.lastEntry().getValue();
    }
  }

  private void findDeepestNodeValues(TreeNode root, int depth, TreeMap<Integer, Set<Integer>> depthToNodes) {
    if (root == null) {
      return;
    }
    Set<Integer> nodesOfDepth = depthToNodes.getOrDefault(depth, new HashSet<>());
    nodesOfDepth.add(root.val);
    depthToNodes.put(depth, nodesOfDepth);
    findDeepestNodeValues(root.left, depth + 1, depthToNodes);
    findDeepestNodeValues(root.right, depth + 1, depthToNodes);
  }
}

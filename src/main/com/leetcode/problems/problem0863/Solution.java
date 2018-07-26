package main.com.leetcode.problems.problem0863;

import main.com.leetcode.datastructures.TreeNode;

import java.util.*;

public class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    if (root == null) {
      return Collections.emptyList();
    }
    Map<Integer, TreeNode> valueToParent = buildValueToParentMap(root);
    List<Integer> numsKDistanceAway = new ArrayList<>();
    Set<TreeNode> visited = new HashSet<>();
    numsKDistanceAway.addAll(getNumsKDistance(target, K, visited));
    TreeNode parent = valueToParent.get(target.val);
    while (parent != null && K >= 0) {
      K--;
      numsKDistanceAway.addAll(getNumsKDistance(parent, K, visited));
      parent = valueToParent.get(parent.val);
    }
    return numsKDistanceAway;
  }

  private List<Integer> getNumsKDistance(TreeNode root, int K, Set<TreeNode> visited) {
    List<Integer> numsKDistanceAway = new ArrayList<>();
    getNumsKDistance(root, K, numsKDistanceAway, visited);
    return numsKDistanceAway;
  }

  private void getNumsKDistance(TreeNode root, int K, List<Integer> list, Set<TreeNode> visited) {
    if (root == null || visited.contains(root)) {
      return;
    }
    visited.add(root);
    if (K == 0) {
      list.add(root.val);
      return;
    }
    getNumsKDistance(root.left, K - 1, list, visited);
    getNumsKDistance(root.right, K - 1, list, visited);
  }

  private Map<Integer, TreeNode> buildValueToParentMap(TreeNode root) {
    Map<Integer, TreeNode> valueToParent = new HashMap<>();
    valueToParent.put(root.val, null);
    Deque<TreeNode> pending = new ArrayDeque<>();
    pending.push(root);
    while (!pending.isEmpty()) {
      TreeNode current = pending.pop();
      if (current.left != null) {
        valueToParent.put(current.left.val, current);
        pending.push(current.left);
      }
      if (current.right != null) {
        valueToParent.put(current.right.val, current);
        pending.push(current.right);
      }
    }
    return valueToParent;
  }
}

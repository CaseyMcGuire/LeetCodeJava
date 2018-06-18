package main.com.leetcode.problems.problem0652;

import main.com.leetcode.datastructures.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Map<Integer, List<SubTreeInfo>> nodeValueToSubTreeInfo = new HashMap<>();
    getSizeAndFillSubTreeInfoMap(root, nodeValueToSubTreeInfo);
    Set<SubTreeInfo> rootsOfDuplicateSubtrees = new HashSet<>();
    for (Map.Entry<Integer, List<SubTreeInfo>> entry : nodeValueToSubTreeInfo.entrySet()) {
      List<SubTreeInfo> subTreesWithSameRootValue = entry.getValue();
      for (int i = 0; i < subTreesWithSameRootValue.size(); i++) {
        for (int j = i + 1; j < subTreesWithSameRootValue.size(); j++) {
          SubTreeInfo first = subTreesWithSameRootValue.get(i);
          SubTreeInfo second = subTreesWithSameRootValue.get(j);
          if (first.size != second.size) {
            continue;
          }
          if (areEqual(first.root, second.root)) {
            rootsOfDuplicateSubtrees.add(first);
          }
        }
      }
    }
    return rootsOfDuplicateSubtrees.stream().map(subTreeInfo -> subTreeInfo.root).collect(Collectors.toList());
  }

  private static boolean areEqual(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    else if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
      return false;
    }
    if (root1.val != root2.val) {
      return false;
    }
    boolean isRightEqual = areEqual(root1.right, root2.right);
    if (!isRightEqual) {
      return false;
    }
    return areEqual(root1.left, root2.left);
  }

  private int getSizeAndFillSubTreeInfoMap(TreeNode root, Map<Integer, List<SubTreeInfo>> nodeValueToSubTreeInfo) {
    if (root == null) {
      return 0;
    }
    int leftSubtreeSize = getSizeAndFillSubTreeInfoMap(root.left, nodeValueToSubTreeInfo);
    int rightSubtreeSize = getSizeAndFillSubTreeInfoMap(root.right, nodeValueToSubTreeInfo);
    int currentSize = leftSubtreeSize + rightSubtreeSize + 1;
    SubTreeInfo currentSubTreeInfo = new SubTreeInfo(root, currentSize);
    List<SubTreeInfo> subtreesWithSameRootValue = nodeValueToSubTreeInfo.getOrDefault(root.val, new ArrayList<>());
    subtreesWithSameRootValue.add(currentSubTreeInfo);
    nodeValueToSubTreeInfo.put(root.val, subtreesWithSameRootValue);
    return currentSize;
  }


  private static class SubTreeInfo {
    TreeNode root;
    int size;
    SubTreeInfo(TreeNode root, int size) {
      this.root = root;
      this.size = size;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      SubTreeInfo that = (SubTreeInfo) o;
      return size == that.size &&
          areEqual(root, that.root);
    }

    @Override
    public int hashCode() {

      return Objects.hash(root.val, size);
    }
  }
}

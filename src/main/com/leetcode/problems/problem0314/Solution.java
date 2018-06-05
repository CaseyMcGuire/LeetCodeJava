package main.com.leetcode.problems.problem0314;

import main.com.leetcode.datastructures.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  private Integer leftMostColumn;
  private Integer rightMostColumn;
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    leftMostColumn = 0;
    rightMostColumn = 0;
    Map<Integer, List<NodeValue>> columnsToValues = new HashMap<>();
    verticalOrder(root, columnsToValues, 0, 0);

    List<List<Integer>> columns = new ArrayList<>();
    for (int i = leftMostColumn; i <= rightMostColumn; i++) {
      List<Integer> values = columnsToValues.get(i)
                                            .stream()
                                            .sorted((o1, o2) -> o1.height - o2.height)
                                            .map(nodeValue -> nodeValue.value)
                                            .collect(Collectors.toList());
      columns.add(values);
    }
    return columns;
  }

  private void verticalOrder(TreeNode node, Map<Integer, List<NodeValue>> columnsToValues, int columnIndex, int height) {
    if (node == null) {
      return;
    }
    if (columnIndex < leftMostColumn) {
      leftMostColumn = columnIndex;
    }
    else if (columnIndex > rightMostColumn) {
      rightMostColumn = columnIndex;
    }
    List<NodeValue> valuesInColumn = columnsToValues.getOrDefault(columnIndex, new ArrayList<>());
    valuesInColumn.add(new NodeValue(node.val, height));
    columnsToValues.put(columnIndex, valuesInColumn);
    verticalOrder(node.left, columnsToValues, columnIndex - 1, height + 1);
    verticalOrder(node.right, columnsToValues, columnIndex + 1, height + 1);
  }

  private static class NodeValue {
    int value;
    int height;
    NodeValue(int value, int height) {
      this.value = value;
      this.height = height;
    }
  }
}

package main.com.dailycodingproblem.expressiontree;

import main.com.leetcode.datastructures.ExpressionTreeNode;

public class Solution {
  public int evaluate(ExpressionTreeNode node) {
    if (node.isNumeric()) {
      return node.getNumericValue();
    }
    int left = evaluate(node.left);
    int right = evaluate(node.right);
    return compute(node.val, left, right);
  }

  private int compute(char operation, int left, int right) {
    switch (operation) {
      case '+':
        return left + right;
      case '-':
        return left - right;
      case '*':
        return left * right;
      case '/':
        return left / right;
      default:
        throw new IllegalArgumentException("Unknown operator: " + operation);
    }
  }
}

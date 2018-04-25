package main.com.leetcode.datastructures;

public class ExpressionTreeNode {
  public char val;
  public ExpressionTreeNode left;
  public ExpressionTreeNode right;

  public ExpressionTreeNode(char val) {
    this.val = val;
  }

  public boolean isNumeric() {
    return Character.getNumericValue(val) != -1;
  }

  public Integer getNumericValue() {
    if (!isNumeric()) {
      return null;
    }
    return Character.getNumericValue(val);
  }
}

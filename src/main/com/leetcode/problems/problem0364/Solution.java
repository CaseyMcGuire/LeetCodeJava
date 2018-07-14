package main.com.leetcode.problems.problem0364;

import java.util.List;

public class Solution {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    int depth = getDepth(nestedList);
    return depthSumInverse(nestedList, depth);
  }

  private int depthSumInverse(List<NestedInteger> nestedList, int inverseDepth) {
    int sum = 0;
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        sum += (nestedInteger.getInteger() * inverseDepth);
      }
      else {
        sum += depthSumInverse(nestedInteger.getList(), inverseDepth - 1);
      }
    }
    return sum;
  }

  private int getDepth(List<NestedInteger> nestedIntegers) {
    int currentDepth = 1;
    for (NestedInteger nestedInteger : nestedIntegers) {
      if (!nestedInteger.isInteger()) {
        int depth = 1 + getDepth(nestedInteger.getList());
        currentDepth = Math.max(currentDepth, depth);
      }
    }
    return currentDepth;
  }
}


interface NestedInteger {
  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // Set this NestedInteger to hold a single integer.
  public void setInteger(int value);

  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  public void add(NestedInteger ni);

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  List<NestedInteger> getList();
}
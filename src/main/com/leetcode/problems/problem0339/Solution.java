package main.com.leetcode.problems.problem0339;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
  public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
  }

  private int depthSum(List<NestedInteger> nestedList, int depth) {
    int sum = 0;
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        sum += (nestedInteger.getInteger() * depth);
      }
      else {
        sum += depthSum(nestedInteger.getList(), depth + 1);
      }
    }
    return sum;
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
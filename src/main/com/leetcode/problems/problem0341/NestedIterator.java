package main.com.leetcode.problems.problem0341;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

  private Deque<OuterNestedList> stack;
  private Integer nextElement;
  private List<NestedInteger> curList;
  private int curIndex;

  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new ArrayDeque<>();
    curList = nestedList;
    curIndex = 0;
    nextElement = findNextElement();
  }

  private Integer findNextElement() {
    while (curList.size() <= curIndex) {
      if (stack.isEmpty()) {
        return null;
      }
      OuterNestedList outerNestedList = stack.pop();
      curList = outerNestedList.outerList;
      curIndex = outerNestedList.currentIndex;
    }

    NestedInteger next = curList.get(curIndex);
    if (next.isInteger()) {
      curIndex++;
      return next.getInteger();
    }
    while (!next.isInteger()) {
      while (curList.size() <= curIndex) {
        if (stack.isEmpty()) {
          return null;
        }
        OuterNestedList outerNestedList = stack.pop();
        curList = outerNestedList.outerList;
        curIndex = outerNestedList.currentIndex;
      }
      next = curList.get(curIndex);
      List<NestedInteger> nextList = next.getList();
      stack.push(new OuterNestedList(curIndex + 1, curList));
      curIndex = 0;
      curList = nextList;
    }
    curIndex++;
    return next.getInteger();
  }


  @Override
  public boolean hasNext() {
    return nextElement != null;
  }

  @Override
  public Integer next() {
    Integer next = nextElement;
    nextElement = findNextElement();
    return next;
  }


  private static class OuterNestedList {
    private final int currentIndex;
    private final List<NestedInteger> outerList;

    public OuterNestedList(int currentIndex, List<NestedInteger> outerList) {
      this.currentIndex = currentIndex;
      this.outerList = outerList;
    }
  }
}



interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  List<NestedInteger> getList();
}
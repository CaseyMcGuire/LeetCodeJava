package main.com.leetcode.problems.problem0251;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

  private Integer currentListIndex;
  private int currentIndexInList;
  private final List<List<Integer>> vec2d;

  public Vector2D(List<List<Integer>> vec2d) {
    this.vec2d = vec2d;
    currentIndexInList = 0;
    currentListIndex = findNextNonEmptyListIndex();
  }

  @Override
  public boolean hasNext() {
    return currentListIndex != null;
  }

  @Override
  public Integer next() {
    int nextElement = vec2d.get(currentListIndex).get(currentIndexInList);
    currentIndexInList++;
    if (vec2d.get(currentListIndex).size() == currentIndexInList) {
      currentListIndex = findNextNonEmptyListIndex();
      currentIndexInList = 0;
    }
    return nextElement;
  }

  private Integer findNextNonEmptyListIndex() {
    int nextStartingIndex = currentListIndex == null ? 0 : currentListIndex + 1;
    while (nextStartingIndex < vec2d.size()) {
      if (!vec2d.get(nextStartingIndex).isEmpty()) {
        return nextStartingIndex;
      }
      nextStartingIndex++;
    }
    return null;
  }
}

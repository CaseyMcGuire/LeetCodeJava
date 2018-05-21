package main.com.leetcode.problems.problem0281;

import java.util.List;

public class ZigzagIterator {
  private final List<Integer> list1;
  private final List<Integer> list2;
  private boolean useFirst;
  private IteratorState state;
  private int firstIndex;
  private int secondIndex;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    list1 = v1;
    list2 = v2;
    useFirst = true;
    firstIndex = 0;
    secondIndex = 0;
    if (v1.isEmpty() && v2.isEmpty()) {
      state = IteratorState.BOTH_EXHAUSTED;
    }
    else if (v1.isEmpty()) {
      state = IteratorState.ONE_EXHAUSTED;
      useFirst = false;
    }
    else if (v2.isEmpty()) {
      state = IteratorState.ONE_EXHAUSTED;
    }
    else {
      state = IteratorState.NEITHER_EXHAUSTED;
    }
  }

  public int next() {
    int toReturn;
    if (useFirst) {
      toReturn = list1.get(firstIndex);
      firstIndex++;
    }
    else {
      toReturn = list2.get(secondIndex);
      secondIndex++;
    }

    if (firstIndex == list1.size() && secondIndex == list2.size()) {
      state = IteratorState.BOTH_EXHAUSTED;
    }
    else if (firstIndex == list1.size()) {
      useFirst = false;
    }
    else if (secondIndex == list2.size()) {
      useFirst = true;
    }
    else {
      useFirst = !useFirst;
    }

    return toReturn;
  }

  public boolean hasNext() {
    return state != IteratorState.BOTH_EXHAUSTED;
  }

  private enum IteratorState {
    NEITHER_EXHAUSTED,
    ONE_EXHAUSTED,
    BOTH_EXHAUSTED
  }

}

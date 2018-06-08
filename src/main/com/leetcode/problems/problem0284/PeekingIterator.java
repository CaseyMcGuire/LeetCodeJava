package main.com.leetcode.problems.problem0284;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class PeekingIterator implements Iterator<Integer> {
  private final Deque<Integer> queue;
  private final Iterator<Integer> iterator;

  public PeekingIterator(Iterator<Integer> iterator) {
    queue = new LinkedList<>();
    this.iterator = iterator;
  }

  public Integer peek() {
    if (!queue.isEmpty()) {
      return queue.peekLast();
    }
    Integer next = iterator.next();
    queue.addFirst(next);
    return peek();
  }

  @Override
  public Integer next() {
    if (!queue.isEmpty()) {
      return queue.removeLast();
    }
    return iterator.next();
  }

  @Override
  public boolean hasNext() {
    return !queue.isEmpty() || iterator.hasNext();
  }
}

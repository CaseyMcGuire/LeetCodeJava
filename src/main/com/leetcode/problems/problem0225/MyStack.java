package main.com.leetcode.problems.problem0225;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {

  private final Deque<Integer> first;
  private final Deque<Integer> second;
  private Deque<Integer> currentQueue;

  public MyStack() {
    first = new LinkedList<>();
    second = new LinkedList<>();
    currentQueue = first;
  }

  /** Push element x onto stack. */
  public void push(int x) {
    currentQueue.addLast(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    Deque<Integer> other = getOtherQueue();
    while (currentQueue.size() != 1) {
      other.addLast(currentQueue.removeFirst());
    }
    int toReturn = currentQueue.removeFirst();
    currentQueue = other;
    return toReturn;
  }

  private Deque<Integer> getOtherQueue() {
    return currentQueue == first ? second : first;
  }

  /** Get the top element. */
  public int top() {
    int top = pop();
    push(top);
    return top;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return currentQueue.isEmpty();
  }
}

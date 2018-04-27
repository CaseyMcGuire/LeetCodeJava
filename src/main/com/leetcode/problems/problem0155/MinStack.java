package main.com.leetcode.problems.problem0155;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
  private final Deque<Integer> stack;
  private final Deque<Integer> maxStack;

  public MinStack() {
    stack = new ArrayDeque<>();
    maxStack = new ArrayDeque<>();
  }

  public void push(int x) {
    if (maxStack.isEmpty()) {
      maxStack.push(x);
    }
    else {
      maxStack.push(Math.min(maxStack.peek(), x));
    }
    stack.push(x);
  }

  public void pop() {
    stack.pop();
    maxStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return maxStack.peek();
  }
}

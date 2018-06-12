package main.com.leetcode.problems.problem0346;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {

  private final double size;
  private final Deque<Double> valueQueue;
  private double sum;

  public MovingAverage(int size) {
    this.size = size;
    this.valueQueue = new LinkedList<>();
    sum = 0;
  }

  public double next(int val) {
    if (valueQueue.size() == size) {
      sum -= valueQueue.removeFirst();
    }
    valueQueue.addLast((double) val);
    sum += val;
    return sum / (double) valueQueue.size();
  }
}

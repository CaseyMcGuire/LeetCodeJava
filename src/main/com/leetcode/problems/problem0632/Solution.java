package main.com.leetcode.problems.problem0632;

import java.util.*;

public class Solution {
  public int[] smallestRange(List<List<Integer>> nums) {
    if (nums == null || nums.isEmpty()) {
      return null;
    }
    Integer min = null;
    Integer max = null;
    PriorityQueue<Group> pq = new PriorityQueue<>();
    for (List<Integer> groupNums : nums) {
      Group currentGroup = new Group(groupNums);
      if (min == null || min > currentGroup.getElement()) {
        min = currentGroup.getElement();
      }
      if (max == null || max < currentGroup.getElement()) {
        max = currentGroup.getElement();
      }
      pq.add(currentGroup);
    }
    Range smallestSoFar = new Range(min, max);
    while (true) {
      Group next = pq.poll().getNext();
      if (next == null) {
        break;
      }
      if (next.getElement() > max) {
        max = next.getElement();
      }
      pq.add(next);
      min = pq.peek().getElement();
      Range currentRange = new Range(min, max);
      if (currentRange.compareTo(smallestSoFar) < 0) {
        smallestSoFar = currentRange;
      }
    }
    return smallestSoFar.getAsArray();
  }

  private static class Group implements Comparable<Group> {
    private List<Integer> nums;
    private int index;

    Group(List<Integer> nums) {
      this(nums, 0);
    }

    Group(List<Integer> nums, int index) {
      this.nums = nums;
      this.index = index;
    }

    public int getElement() {
      return nums.get(index);
    }

    public Group getNext() {
      if (index + 1 == nums.size()) {
        return null;
      }
      return new Group(nums, index + 1);
    }

    public int compareTo(Group other) {
      return nums.get(index) - other.nums.get(other.index);
    }
  }

  private static class Range implements Comparable<Range> {
    private int low;
    private int high;

    Range(int low, int high) {
      this.low = low;
      this.high = high;
    }

    public int getLength() {
      return high - low;
    }

    public int compareTo(Range other) {
      return getLength() - other.getLength();
    }

    public int[] getAsArray() {
      return new int[]{low, high};
    }
  }
}
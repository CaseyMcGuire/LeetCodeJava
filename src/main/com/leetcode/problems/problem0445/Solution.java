package main.com.leetcode.problems.problem0445;

import main.com.leetcode.datastructures.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1.val == 0 && l1.next == null) {
      return l2;
    }
    if (l2.val == 0 && l2.next == null) {
      return l1;
    }
    Deque<Integer> firstNums = createNumberDeque(l1);
    Deque<Integer> secondNums = createNumberDeque(l2);
    padShorterDeque(firstNums, secondNums);

    ListNode iter = null;
    int remainder = 0;
    while (!firstNums.isEmpty()) {
      int first = firstNums.removeLast();
      int second = secondNums.removeLast();
      int sum = first + second + remainder;
      if (sum > 9) {
        remainder = 1;
        sum -= 10;
      }
      else {
        remainder = 0;
      }
      ListNode current = new ListNode(sum);
      current.next = iter;
      iter = current;
    }
    if (remainder != 0) {
      ListNode head = new ListNode(remainder);
      head.next = iter;
      iter = head;
    }
    return iter;
  }

  private void padShorterDeque(Deque<Integer> first, Deque<Integer> second) {
    if (first.size() == second.size()) {
      return;
    }
    Deque<Integer> longer;
    Deque<Integer> shorter;
    if (first.size() > second.size()) {
      longer = first;
      shorter = second;
    }
    else {
      longer = second;
      shorter = first;
    }
    while (shorter.size() < longer.size()) {
      shorter.addFirst(0);
    }
  }

  private Deque<Integer> createNumberDeque(ListNode head) {
    Deque<Integer> nums = new LinkedList<>();
    ListNode iter = head;
    while (iter != null) {
      nums.addLast(iter.val);
      iter = iter.next;
    }
    return nums;
  }
}

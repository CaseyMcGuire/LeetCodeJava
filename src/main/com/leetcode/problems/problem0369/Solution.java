package main.com.leetcode.problems.problem0369;

import main.com.leetcode.datastructures.ListNode;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public ListNode plusOne(ListNode head) {
    Deque<ListNode> nodeStack = new ArrayDeque<>();
    ListNode iter = head;
    while (iter != null) {
      nodeStack.push(iter);
      iter = iter.next;
    }
    int val = 1;
    while (!nodeStack.isEmpty()) {
      ListNode currentNode = nodeStack.pop();
      int currentVal = currentNode.val + val;
      if (currentVal == 10) {
        currentVal = 0;
      }
      else {
        val = 0;
      }
      currentNode.val = currentVal;
    }
    if (val == 1) {
      ListNode newHead = new ListNode(1);
      newHead.next = head;
      return newHead;
    }
    return head;
  }
}

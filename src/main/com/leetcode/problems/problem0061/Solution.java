package main.com.leetcode.problems.problem0061;

import main.com.leetcode.datastructures.ListNode;

public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (k == 0 || head == null || head.next == null) {
      return head;
    }

    int listLength = getListLength(head);
    int numNodesFromEnd = k % listLength;
    if (numNodesFromEnd == 0) {
      return head;
    }
    int frontListLength = listLength - numNodesFromEnd;
    int i = 0;
    ListNode iter = head;
    while (i < frontListLength - 1) {
      iter = iter.next;
      i++;
    }
    ListNode nextHead = iter.next;
    iter.next = null;
    iter = nextHead;
    while (iter.next != null) {
      iter = iter.next;
    }
    iter.next = head;
    return nextHead;
  }

  private int getListLength(ListNode head) {
    int length = 0;
    while (head != null) {
      head = head.next;
      length++;
    }
    return length;
  }
}

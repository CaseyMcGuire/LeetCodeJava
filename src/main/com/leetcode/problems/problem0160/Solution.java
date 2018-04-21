package main.com.leetcode.problems.problem0160;

import main.com.leetcode.datastructures.ListNode;

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int aLength = getLength(headA);
    int bLength = getLength(headB);
    int difference = Math.abs(aLength - bLength);
    ListNode longer;
    ListNode shorter;
    if (aLength > bLength) {
      longer = headA;
      shorter = headB;
    }
    else {
      longer = headB;
      shorter = headA;
    }
    if (difference != 0) {
      longer = getNode(difference, longer);
    }

    while (longer != null && shorter != null) {
      if (longer == shorter) {
        return longer;
      }
      longer = longer.next;
      shorter = shorter.next;
    }

    return null;
  }

  private ListNode getNode(int index, ListNode head) {
    ListNode iter = head;
    for (int i = 0; i < index; i++) {
      iter = iter.next;
    }
    return iter;
  }

  private int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }
}

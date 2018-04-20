package main.com.leetcode.problems.problem0002;

import main.com.leetcode.datastructures.ListNode;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (isZero(l1)) {
      return l2;
    }
    if (isZero(l2)) {
      return l1;
    }
    ListNode sumListHead = null;
    ListNode sumList = null;
    int remainder = 0;
    while (l1 != null && l2 != null) {
      int curTotal = remainder + l1.val + l2.val;
      if (curTotal >= 10) {
        remainder = 1;
        curTotal -= 10;
      }
      else {
        remainder = 0;
      }
      if (sumList == null) {
        sumList = new ListNode(curTotal);
        sumListHead = sumList;
      }
      else {
        sumList.next = new ListNode(curTotal);
        sumList = sumList.next;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    if (l1 == null && l2 == null) {
      if (remainder != 0) {
        sumList.next = new ListNode(remainder);
      }
      return sumListHead;
    }
    ListNode remaining = l1 != null ? l1 : l2;
    while (remaining != null) {
      int total = remainder + remaining.val;
      if (total >= 10) {
        total -= 10;
        remainder = 1;
      }
      else {
        remainder = 0;
      }
      sumList.next = new ListNode(total);
      sumList = sumList.next;
      remaining = remaining.next;
    }
    if (remainder != 0) {
      sumList.next = new ListNode(remainder);
    }
    return sumListHead;
  }

  private boolean isZero(ListNode head) {
    return head.val == 0 && head.next == null;
  }

}

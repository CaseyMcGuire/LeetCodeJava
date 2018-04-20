package main.com.leetcode.problems.problem0234;

import main.com.leetcode.datastructures.ListNode;

public class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    int length = getLength(head);
    if (length == 1) {
      return true;
    }
    else if (length == 2) {
      return head.val == head.next.val;
    }
    final int secondListIndex;
    if (length % 2 != 0) {
      secondListIndex = length / 2 + 1;
    }
    else {
      secondListIndex = length / 2;
    }
    ListNode secondHalf = getSecondListHead(head, secondListIndex, length);
    secondHalf = reverseList(secondHalf);
    return areEqual(head, secondHalf);
  }

  private boolean areEqual(ListNode first, ListNode second) {
    while (first != null && second != null) {
      if (first.val != second.val) {
        return false;
      }
      first = first.next;
      second = second.next;
    }
    return first == null && second == null;
  }

  private ListNode getSecondListHead(ListNode head, int secondListHeadIndex, int length) {
    int curIndex = 0;
    ListNode iter = head;
    while (curIndex < secondListHeadIndex) {
      ListNode next = iter.next;
      if ((length / 2 - 1) == curIndex){
        iter.next = null;
      }
      curIndex++;
      iter = next;
    }
    return iter;
  }


  private ListNode reverseList(ListNode head) {
    ListNode cur = head.next;
    ListNode prev = head;
    head.next = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
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

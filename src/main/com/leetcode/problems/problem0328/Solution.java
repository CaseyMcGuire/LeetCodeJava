package main.com.leetcode.problems.problem0328;

import main.com.leetcode.datastructures.ListNode;

public class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode oddHead = head;
    ListNode evenHead = head.next;
    ListNode oddIter = head;
    ListNode evenIter = head.next;
    ListNode iter = head.next.next;
    oddHead.next = null;
    evenHead.next = null;
    boolean isOdd = true;
    while (iter != null) {
      ListNode nextIter = iter.next;
      iter.next = null;
      if (isOdd) {
        oddIter.next = iter;
        oddIter = oddIter.next;
      }
      else {
        evenIter.next = iter;
        evenIter = evenIter.next;
      }
      isOdd = !isOdd;
      iter = nextIter;
    }
    oddIter.next = evenHead;
    return oddHead;
  }

}

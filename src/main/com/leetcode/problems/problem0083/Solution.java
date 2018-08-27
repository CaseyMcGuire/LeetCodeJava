package main.com.leetcode.problems.problem0083;

import main.com.leetcode.datastructures.ListNode;

public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    while (head != null && hasDuplicate(head)) {
      head = findNextNonDuplicateNode(head);
    }
    // every node value is duplicated
    if (head == null) {
      return null;
    }

    ListNode currentNonDuplicateNode = head;
    while (currentNonDuplicateNode != null) {
      if (hasDuplicate(currentNonDuplicateNode.next)) {
        currentNonDuplicateNode.next = findNextNonDuplicateNode(currentNonDuplicateNode.next);
      }
      currentNonDuplicateNode = currentNonDuplicateNode.next;
    }
    return head;
  }

  private ListNode findNextNonDuplicateNode(ListNode node) {
    int nodeValue = node.val;
    while (node != null && node.val == nodeValue) {
      node = node.next;
    }
    if (node != null && hasDuplicate(node)) {
      return findNextNonDuplicateNode(node);
    }
    else {
      return node;
    }
  }

  private boolean hasDuplicate(ListNode node) {
    if (node == null || node.next == null) {
      return false;
    }
    return node.val == node.next.val;
  }
}

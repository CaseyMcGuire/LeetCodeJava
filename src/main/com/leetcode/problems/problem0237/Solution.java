package main.com.leetcode.problems.problem0237;

import main.com.leetcode.datastructures.ListNode;

public class Solution {
  public void deleteNode(ListNode node) {
    while (!shouldDetachNext(node)) {
      node.val = node.next.val;
      node = node.next;
    }
    node.val = node.next.val;
    node.next = null;
  }

  private boolean shouldDetachNext(ListNode node) {
    return node.next.next == null;
  }
}

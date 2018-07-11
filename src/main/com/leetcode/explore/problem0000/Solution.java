package main.com.leetcode.explore.problem0000;

import main.com.leetcode.datastructures.Node;

public class Solution {

  public Node insert(Node head, int insertVal) {
    if (head == null) {
      Node newHead = new Node(insertVal, null);
      newHead.next = newHead;
      return newHead;
    }
    else if (head == head.next) {
      head.next = new Node(insertVal, head);
      return head;
    }
    Node iter = head;
    while (!shouldInsert(iter, insertVal)) {
      iter = iter.next;
      if (iter == head) {
        break;
      }
    }

    iter.next = new Node(insertVal, iter.next);
    return head;
  }

  private boolean shouldInsert(Node current, int insertVal) {
    if (current.val < insertVal && current.next.val >= insertVal) {
      return true;
    }
    else if (current.val == insertVal && current.next.val > insertVal) {
      return true;
    }
    //largest value in the list
    else if (current.val < insertVal && current.next.val < insertVal && current.val > current.next.val) {
      return true;
    }
    //smallest in the list
    else if (current.val > insertVal && current.next.val > insertVal && current.val > current.next.val) {
      return true;
    }
    return false;
  }
}



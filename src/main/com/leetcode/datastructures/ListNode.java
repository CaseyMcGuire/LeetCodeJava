package main.com.leetcode.datastructures;

import java.util.Objects;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListNode listNode = (ListNode) o;

    return val == listNode.val && Objects.equals(next, listNode.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, next);
  }

  public static ListNode asList(int... vals) {
    ListNode head = new ListNode(vals[0]);
    ListNode currentNode = head;
    for (int i = 1; i < vals.length; i++) {
      ListNode nextNode = new ListNode(vals[i]);
      currentNode.next = nextNode;
      currentNode = nextNode;
    }
    return head;
  }

  @Override
  public String toString() {
    return val + "->" + next;
  }
}

package main.com.leetcode.problems.problem0142;

import main.com.leetcode.datastructures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public ListNode detectCycle(ListNode head) {
    Set<ListNode> nodes = new HashSet<>();
    ListNode iter = head;
    while (iter != null) {
      if (!nodes.add(iter)) {
        return iter;
      }
      iter = iter.next;
    }
    return null;
  }
}

package main.com.leetcode.problems.problem0141;

import main.com.leetcode.datastructures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean hasCycle(ListNode head) {
    Set<ListNode> nodes = new HashSet<>();
    ListNode iter = head;
    while (iter != null) {
      if (!nodes.add(iter)) {
        return true;
      }
      iter = iter.next;
    }
    return false;
  }
}

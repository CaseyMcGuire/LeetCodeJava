package main.com.leetcode.problems.problem0086;

import main.com.leetcode.datastructures.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    List<ListNode> leftOfPartition = new ArrayList<>();
    List<ListNode> rightOfPartition = new ArrayList<>();
    ListNode iter = head;
    while (iter != null) {
      if (iter.val < x) {
        leftOfPartition.add(iter);
      }
      else { //iter.val >= x
        rightOfPartition.add(iter);
      }
      iter = iter.next;
    }
    ListNode newHead = null;
    ListNode current = null;
    List<List<ListNode>> nodes = Arrays.asList(leftOfPartition, rightOfPartition);
    for (List<ListNode> partition : nodes) {
      for (ListNode node : partition) {
        if (current == null) {
          newHead = node;
          current = node;
        }
        else {
          current.next = node;
          current = current.next;
        }
      }
    }
    current.next = null;
    return newHead;
  }
}

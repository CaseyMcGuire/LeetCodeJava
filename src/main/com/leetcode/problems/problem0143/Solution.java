package main.com.leetcode.problems.problem0143;

import main.com.leetcode.datastructures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    List<ListNode> list = new ArrayList<>();
    ListNode iter = head;
    while (iter != null) {
      list.add(iter);
      iter = iter.next;
    }
    iter = head;
    int front = 1;
    int back = list.size() - 1;
    boolean useFront = false;
    while (front <= back) {
      if (useFront) {
        iter.next = list.get(front);
        front++;
      }
      else {
        iter.next = list.get(back);
        back--;
      }
      useFront = !useFront;
      iter = iter.next;
    }
    iter.next = null;
  }
}

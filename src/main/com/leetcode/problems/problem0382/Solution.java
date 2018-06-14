package main.com.leetcode.problems.problem0382;

import main.com.leetcode.datastructures.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
  private final List<Integer> list;
  private final Random random;

  public Solution(ListNode head) {
    list = createList(head);
    random = new Random();
  }

  private List<Integer> createList(ListNode node) {
    List<Integer> list = new ArrayList<>();
    while (node != null) {
      list.add(node.val);
      node = node.next;
    }
    return list;
  }

  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }
}

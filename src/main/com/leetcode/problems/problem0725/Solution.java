package main.com.leetcode.problems.problem0725;

import main.com.leetcode.datastructures.ListNode;

public class Solution {
  public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode[] lists = new ListNode[k];
    int length = getListLength(root);
    int minLengthOfEachList = length / k;
    int extraNodes = length % k;
    ListNode iter = root;
    for (int i = 0; i < k; i++) {
      int extraNode = 0;
      if (extraNodes > 0) {
        extraNode = 1;
        extraNodes--;
      }
      int curLength = minLengthOfEachList + extraNode;
      for (int j = 0; j < curLength; j++) {
        ListNode next = iter.next;
        if (j == 0) {
          lists[i] = iter;
        }
        if (j == curLength - 1) {
          iter.next = null;
        }
        iter = next;
      }

    }
    return lists;
  }

  private int getListLength(ListNode root) {
    int length = 0;
    while (root != null) {
      length++;
      root = root.next;
    }
    return length;
  }

}

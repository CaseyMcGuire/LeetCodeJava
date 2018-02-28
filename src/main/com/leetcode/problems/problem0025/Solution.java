package main.com.leetcode.problems.problem0025;

import main.com.leetcode.datastructures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1 || head == null) {
      return head;
    }
    List<ListNode> subLists = createSubLists(head, k);

    List<LinkedListPair> reversedSubLists = new ArrayList<>();
    for (int i = 0; i < subLists.size(); i++) {
      boolean isLastList = i == subLists.size() - 1;
      ListNode curList = subLists.get(i);
      LinkedListPair pair = new LinkedListPair();
      //we don't want to reverse the last list if its not k elements long
      if (isLastList && calculateListLength(curList) != k) {
        pair.head = curList;
      }
      else {
        pair = reverseList(curList);
      }
      reversedSubLists.add(pair);
    }

    for (int i = 0; i < subLists.size() - 1; i++) {
      reversedSubLists.get(i).tail.next = reversedSubLists.get(i + 1).head;
    }
    return reversedSubLists.get(0).head;
  }

  private List<ListNode> createSubLists(ListNode head, int subListLength) {
    List<ListNode> subLists = new ArrayList<>();
    ListNode nextHead = head;
    while (nextHead != null) {
      ListNode cur = nextHead;
      ListNode subListHead = nextHead;
      for (int i = 0; i < subListLength - 1 && cur != null; i++) {
        cur = cur.next;
      }
      subLists.add(subListHead);
      if (cur != null) {
        nextHead = cur.next;
        cur.next = null;
      }
      else {
        break;
      }

    }
    return subLists;
  }

  private LinkedListPair reverseList(ListNode node) {
    LinkedListPair pair = new LinkedListPair();
    pair.tail = node;
    ListNode prev = node;
    ListNode cur = node.next;
    prev.next = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    pair.head = prev;
    return pair;
  }

  private int calculateListLength(ListNode head) {
    int length = 0;
    while (head != null) {
      length++;
      head = head.next;
    }
    return length;
  }

  class LinkedListPair {
    ListNode head;
    ListNode tail;
  }


  public static void main(String[] args) {
    System.out.println(new Solution().reverseKGroup(ListNode.asList(1,2,3,4), 2));
  }
}

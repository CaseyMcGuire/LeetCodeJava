package main.com.leetcode.problems.problem0138;

import main.com.leetcode.datastructures.RandomListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }
    List<RandomListNode> nodes = new ArrayList<>();
    RandomListNode cur = head;
    while (cur != null) {
      nodes.add(cur);
      cur = cur.next;
    }

    Map<RandomListNode, Integer> nodeToIndex = new HashMap<>();
    for (int i = 0; i < nodes.size(); i++) {
      nodeToIndex.put(nodes.get(i), i);
    }


    RandomListNode[] copiedNodes = new RandomListNode[nodes.size()];
    for (int i = 0; i < nodes.size(); i++) {
      RandomListNode oldNode = nodes.get(i);
      if (copiedNodes[i] == null) {
        copiedNodes[i] = new RandomListNode(oldNode.label);
      }

      RandomListNode copiedNode = copiedNodes[i];

      //hook up the next pointers
      if (i > 0) {
        copiedNodes[i - 1].next = copiedNode;
      }

      //if we have a random pointer, hook it up
      if (oldNode.random != null) {
        int randomIndex = nodeToIndex.get(oldNode.random);
        if (copiedNodes[randomIndex] == null) {
          copiedNodes[randomIndex] = new RandomListNode(nodes.get(randomIndex).label);
        }
        copiedNode.random = copiedNodes[randomIndex];
      }
    }
    return copiedNodes[0];
  }
}

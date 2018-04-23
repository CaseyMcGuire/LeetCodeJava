package main.com.leetcode.problems.problem0208;

import java.util.HashMap;
import java.util.Map;

public class Trie {
  private final Node root;

  public Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node iter = root;
    for (char c : word.toCharArray()) {
      Node next = iter.charToNodes.get(c);
      if (next == null) {
        next = new Node();
        iter.charToNodes.put(c, next);
      }
      iter = next;
    }
    iter.isWord = true;
  }

  public boolean search(String word) {
    return contains(word, true);
  }

  public boolean startsWith(String prefix) {
    return contains(prefix, false);
  }

  private boolean contains(String str, boolean isWord) {
    Node iter = root;
    for (char c : str.toCharArray()) {
      Node next = iter.charToNodes.get(c);
      if (next == null) {
        return false;
      }
      iter = next;
    }
    if (isWord) {
      return iter.isWord;
    }
    else {
      return true;
    }
  }

  private static class Node {
    private final Map<Character, Node> charToNodes;
    private boolean isWord;

    public Node() {
      charToNodes = new HashMap<>();
      isWord = false;
    }
  }
}

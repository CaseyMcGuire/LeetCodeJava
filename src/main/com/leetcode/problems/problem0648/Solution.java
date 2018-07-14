package main.com.leetcode.problems.problem0648;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public String replaceWords(List<String> dict, String sentence) {
    Trie trie = new Trie();
    for (String root : dict) {
      trie.addWord(root);
    }
    String[] splitSentence = sentence.split(" ");
    for (int i = 0; i < splitSentence.length; i++) {
      String root = trie.findRoot(splitSentence[i]);
      if (root != null) {
        splitSentence[i] = root;
      }
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < splitSentence.length; i++) {
      builder.append(splitSentence[i]);
      if (i != splitSentence.length - 1) {
        builder.append(" ");
      }
    }
    return builder.toString();
  }

  private static class Trie {

    private final TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode curNode = root;
      for (char c : word.toCharArray()) {
        TrieNode next = curNode.children.getOrDefault(c, new TrieNode());
        curNode.children.put(c, next);
        curNode = next;
      }
      curNode.isWord = true;
    }

    public String findRoot(String word) {
      TrieNode curNode = root;
      StringBuilder builder = new StringBuilder();
      for (char c : word.toCharArray()) {
        builder.append(c);
        TrieNode next = curNode.children.get(c);
        if (next == null) {
          return null;
        }
        if (next.isWord) {
          return builder.toString();
        }
        curNode = next;
      }
      return null;
    }
  }

  private static class TrieNode {
    Map<Character, TrieNode> children;
    private boolean isWord;

    TrieNode() {
      children = new HashMap<>();
      isWord = false;
    }
  }
}

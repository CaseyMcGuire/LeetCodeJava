package main.com.leetcode.problems.problem0745;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {

  private final Trie prefixTrie;
  private final Trie suffixTrie;

  public WordFilter(String[] words) {
    prefixTrie = new Trie();
    suffixTrie = new Trie();

    for (int i = 0; i < words.length; i++) {
      char[] elems = words[i].toCharArray();
      prefixTrie.insert(words[i], words[i], i);
      suffixTrie.insert(new StringBuilder(words[i]).reverse().toString(), words[i], i);
    }
  }

  public int f(String prefix, String suffix) {
    suffix = new StringBuilder(suffix).reverse().toString();
    TrieNode suffixNode = suffixTrie.getNode(suffix);
    TrieNode prefixNode = prefixTrie.getNode(prefix);
    if (suffixNode == null || prefixNode == null) {
      return -1;
    }
    int maxWeight = -1;
    for (Map.Entry<String, Integer> entry : suffixNode.wordsToWeight.entrySet()) {
      if (prefixNode.wordsToWeight.containsKey(entry.getKey())) {
        maxWeight = Math.max(maxWeight, entry.getValue());
      }
    }
    return maxWeight;
  }

  private static class Trie {
    private TrieNode root;

    Trie() {
      root = new TrieNode();
    }

    void insert(String word, String key, int weight) {
      root.wordsToWeight.put(key, weight);
      TrieNode curNode = root;
      for (char c : word.toCharArray()) {
        TrieNode next = curNode.getOrCreateChild(c);
        next.wordsToWeight.put(key, weight);
        curNode = next;
      }
    }

    TrieNode getNode(String word) {
      TrieNode curNode = root;
      for (char c : word.toCharArray()) {
        TrieNode next = curNode.getChild(c);
        if (next == null) {
          return null;
        }
        curNode = next;
      }
      return curNode;
    }
  }

  private static class TrieNode {
    private final Map<Character, TrieNode> children;
    private final Map<String, Integer> wordsToWeight;

    TrieNode() {
      this.children = new HashMap<>();
      wordsToWeight = new HashMap<>();
    }

    TrieNode getChild(char c) {
      return children.get(c);
    }

    TrieNode getOrCreateChild(char c) {
      TrieNode child = children.getOrDefault(c, new TrieNode());
      children.put(c, child);
      return child;
    }
  }
}

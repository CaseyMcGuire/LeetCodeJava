package main.com.leetcode.problems.problem0211;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WordDictionary {

  private TrieNode root;

  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    root.add(wordToQueue(word));
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    return root.contains(wordToQueue(word));
  }

  private Deque<Character> wordToQueue(String word) {
    Deque<Character> queue = new LinkedList<>();
    for (char c : word.toCharArray()) {
      queue.addLast(c);
    }
    return queue;
  }

  private static class TrieNode {

    Map<Character, TrieNode> nodeMap;
    private boolean isWord;

    public TrieNode() {
      nodeMap = new HashMap<>();
      isWord = false;
    }

    void add(Deque<Character> wordQueue) {
      if (wordQueue.isEmpty()) {
        isWord = true;
        return;
      }
      Character currentCharacter = wordQueue.removeFirst();
      TrieNode node = nodeMap.getOrDefault(currentCharacter, new TrieNode());
      node.add(wordQueue);
      nodeMap.put(currentCharacter, node);
    }

    boolean contains(Deque<Character> wordQueue) {
      if (wordQueue.isEmpty()) {
        return isWord;
      }
      Character currentCharacter = wordQueue.removeFirst();
      boolean containsWord = false;
      if (currentCharacter.equals('.')) {
        for (Map.Entry<Character, TrieNode> entry : nodeMap.entrySet()) {
          containsWord = entry.getValue().contains(wordQueue);
          if (containsWord) {
            break;
          }
        }
      }
      else {
        TrieNode subTrie = nodeMap.get(currentCharacter);
        if (subTrie != null) {
          containsWord = subTrie.contains(wordQueue);
        }
      }
      wordQueue.addFirst(currentCharacter);
      return containsWord;
    }

  }
}

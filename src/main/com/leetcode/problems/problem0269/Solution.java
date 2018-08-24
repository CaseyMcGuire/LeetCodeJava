package main.com.leetcode.problems.problem0269;

import java.util.*;

public class Solution {
  public String alienOrder(String[] words) {
    Map<Character, Set<Character>> charToDescendants = charToDescendants(words);
    return buildDictionary(charToDescendants);
  }

  public String buildDictionary(Map<Character, Set<Character>> charToDescendants) {
    Set<Character> tempMark = new HashSet<>();
    Set<Character> permanentMark = new HashSet<>();
    Deque<Character> sortedOrder = new LinkedList<>();
    for (char c : charToDescendants.keySet()) {
      if (!visit(c, charToDescendants, tempMark, permanentMark, sortedOrder)) {
        return "";
      }
    }

    StringBuilder builder = new StringBuilder();
    while (!sortedOrder.isEmpty()) {
      builder.append(sortedOrder.removeFirst());
    }
    return builder.toString();
  }

  private boolean visit(char current, Map<Character, Set<Character>> charToDescendants, Set<Character> tempMark, Set<Character> permanentMark, Deque<Character> sortedOrder) {
    if (permanentMark.contains(current)) {
      return true;
    }
    else if (tempMark.contains(current)) {
      return false;
    }
    tempMark.add(current);
    for (char descendant : charToDescendants.get(current)) {
      if (!visit(descendant, charToDescendants, tempMark, permanentMark, sortedOrder)) {
        return false;
      }
    }
    permanentMark.add(current);
    sortedOrder.addFirst(current);
    return true;
  }

  private Map<Character, Set<Character>> charToDescendants(String[] words) {
    Map<Character, Set<Character>> charToDescendants = new HashMap<>();

    for (int index = 0; index < getLongestWordLength(words); index++){
      for (int i = 0; i < words.length; i++) {
        if (words[i].length() <= index) {
          continue;
        }
        char currentChar = words[i].charAt(index);
        Set<Character> descendants = charToDescendants.getOrDefault(currentChar, new HashSet<>());
        for (int j = i + 1; j < words.length; j++) {
          if (words[j].length() <= index) {
            continue;
          }
          if (words[i].charAt(index) == words[j].charAt(index)) {
            continue;
          }
          if (prefixMatchesUpToIndex(words[i], words[j], index)) {
            descendants.add(words[j].charAt(index));
          }
          else {
            break;
          }
        }
        charToDescendants.put(currentChar, descendants);
      }
    }
    return charToDescendants;
  }

  private int getLongestWordLength(String[] words) {
    int longest = 0;
    for (String word : words) {
      if (word.length() > longest) {
        longest = word.length();
      }
    }
    return longest;
  }

  private boolean prefixMatchesUpToIndex(String first, String second, int index) {
    if (index <= 0) {
      return true;
    }
    for (int i = 0; i < index; i++) {
      if (first.charAt(i) != second.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  private List<Character> getCharactersAtCurrentIndex(int index, String[] words) {
    List<Character> chars = new ArrayList<>();
    for (String word : words) {
      if (word.length() <= index) {
        continue;
      }
      char c = word.charAt(index);
      if (!chars.isEmpty() && chars.get(chars.size() - 1) == c) {
        continue;
      }
      else {
        chars.add(c);
      }
    }
    return chars;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
  }
}

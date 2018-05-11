package main.com.leetcode.problems.problem0151;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public String reverseWords(String s) {
    Deque<StringBuilder> words = new ArrayDeque<>();
    int currentIndex = getNextWordIndex(s, 0);
    while (currentIndex != -1) {
      StringBuilder word = new StringBuilder();
      for (; currentIndex < s.length() && s.charAt(currentIndex) != ' ' ; currentIndex++) {
        word.append(s.charAt(currentIndex));
      }
      words.push(word);
      currentIndex = getNextWordIndex(s, currentIndex);
    }
    StringBuilder reversedWord = new StringBuilder();
    while (!words.isEmpty()) {
      if (words.size() != 1) {
        reversedWord.append(words.pop().append(' '));
      }
      else {
        reversedWord.append(words.pop());
      }
    }
    return reversedWord.toString();
  }

  private int getNextWordIndex(String word, int startingIndex) {
    for (int i = startingIndex; i < word.length(); i++) {
      if (word.charAt(i) != ' ') {
        return i;
      }
    }
    return -1;
  }


}

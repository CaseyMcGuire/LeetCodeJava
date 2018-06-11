package main.com.leetcode.problems.problem0345;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
  public String reverseVowels(String s) {
    StringBuilder builder = new StringBuilder(s);
    List<Integer> vowelPlaces = new ArrayList<>();
    Deque<Character> vowelStack = new ArrayDeque<>();
    for (int i = 0; i < builder.length(); i++) {
      if (isVowel(builder.charAt(i))) {
        vowelPlaces.add(i);
        vowelStack.push(builder.charAt(i));
      }
    }
    for (int index : vowelPlaces) {
      builder.setCharAt(index, vowelStack.pop());
    }
    return builder.toString();
  }

  private boolean isVowel(char c) {
    c = Character.toLowerCase(c);
    return c == 'o' || c == 'e' || c == 'a' || c == 'i' || c == 'u';
  }
}

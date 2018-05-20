package main.com.leetcode.problems.problem0791;

import java.util.*;

public class Solution {
  public String customSortString(String S, String T) {
    Map<Character, Integer> charToOrder = new HashMap<>();
    char[] sCharArray = S.toCharArray();
    for (int i = 0; i < sCharArray.length; i++) {
      charToOrder.put(sCharArray[i], i);
    }
    List<Character> tChararacters = new ArrayList<>();
    for (char c : T.toCharArray()) {
      tChararacters.add(c);
    }
    Collections.sort(tChararacters, (c1, c2) -> {
      Integer first = charToOrder.getOrDefault(c1, Integer.MAX_VALUE);
      Integer second = charToOrder.getOrDefault(c2, Integer.MAX_VALUE);
      return first - second;
    });
    StringBuilder builder = new StringBuilder();
    for (Character c : tChararacters) {
      builder.append(c);
    }
    return builder.toString();
  }
}

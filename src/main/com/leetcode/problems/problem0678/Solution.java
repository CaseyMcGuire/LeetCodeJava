package main.com.leetcode.problems.problem0678;

import java.util.*;

public class Solution {
  public boolean checkValidString(String s) {
    return checkValidString(convertStringToList(s), 0, new ArrayDeque<>());
  }

  private List<Character> convertStringToList(String s) {
    List<Character> list = new ArrayList<>();
    for (char c : s.toCharArray()) {
      list.add(c);
    }
    return list;
  }

  private boolean checkValidString(List<Character> s, int index, Deque<Character> stack) {
    if (index == s.size()) {
      return stack.isEmpty();
    }
    if (s.get(index) == '(') {
      stack.push('(');
      return checkValidString(s, index + 1, stack);
    }
    else if (s.get(index) == ')') {
      boolean matches = !stack.isEmpty() && stack.pop() == '(';
      if (!matches) {
        return false;
      }
      return checkValidString(s, index + 1, stack);
    }
    // we know it's a '*'
    s.set(index, '(');
    if (checkValidString(s, index, new ArrayDeque<>(stack))) {
      return true;
    }
    s.set(index, ')');
    if (checkValidString(s, index, new ArrayDeque<>(stack))) {
      return true;
    }
    return checkValidString(s, index + 1, stack);
  }
}

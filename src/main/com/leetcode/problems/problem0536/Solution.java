package main.com.leetcode.problems.problem0536;

import main.com.leetcode.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  public TreeNode str2tree(String s) {
    if (s == null || s.isEmpty()) {
      return null;
    }
    return buildTree(0, s.length(), getStartParenIndexToEndParenIndex(s), s);
  }

  private TreeNode buildTree(int start, int end, Map<Integer, Integer> startParenToEndParen, String s) {
    int currentNum = getNextNum(s, start);
    TreeNode root = new TreeNode(currentNum);
    int leftParenStart = start + (currentNum + "").length();
    if (leftParenStart >= end) {
      return root;
    }
    int leftParenEnd = startParenToEndParen.get(leftParenStart);
    root.left = buildTree(leftParenStart + 1, leftParenEnd, startParenToEndParen, s);
    if (leftParenEnd + 1 >= end) {
      return root;
    }
    int rightParenStart = leftParenEnd + 1;
    int rightParenEnd = startParenToEndParen.get(rightParenStart);
    root.right = buildTree(rightParenStart + 1, rightParenEnd, startParenToEndParen, s);
    return root;
  }

  private Map<Integer, Integer> getStartParenIndexToEndParenIndex(String s) {
    Map<Integer, Integer> startParenToEndParen = new HashMap<>();
    Deque<Integer> startIndices = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        startIndices.push(i);
      }
      else if (s.charAt(i) == ')') {
        startParenToEndParen.put(startIndices.pop(), i);
      }
    }
    return startParenToEndParen;
  }

  private int getNextNum(String s, int index) {
    StringBuilder builder = new StringBuilder();
    char c = s.charAt(index);
    while (c == '-' || Character.isDigit(c)) {
      builder.append(c);
      index++;
      if (index == s.length()) {
        break;
      }
      c = s.charAt(index);
    }
    return Integer.parseInt(builder.toString());
  }

}

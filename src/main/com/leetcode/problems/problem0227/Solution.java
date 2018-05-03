package main.com.leetcode.problems.problem0227;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int calculate(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    List<String> tokens = new ArrayList<>();
    StringBuilder curToken = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == ' ') {
        continue;
      }
      else if (c == '+' || c == '-' || c == '/' || c == '*') {
        tokens.add(curToken.toString());
        curToken = new StringBuilder();
        tokens.add(c + "");
      }
      else {
        curToken.append(c);
      }
    }
    if (curToken.length() != 0) {
      tokens.add(curToken.toString());
    }
    if (tokens.size() == 1) {
      return Integer.parseInt(tokens.get(0));
    }
    List<String> laterTokens = new ArrayList<>();
    laterTokens.add(tokens.get(0));
    for (int i = 1; i < tokens.size(); i += 2) {
      String first = laterTokens.get(laterTokens.size() - 1);
      String operand = tokens.get(i);
      String second = tokens.get(i + 1);
      if (operand.equals("*") || operand.equals("/")) {
        final String evaluated;
        Integer firstInt = Integer.parseInt(first);
        Integer secondInt = Integer.parseInt(second);
        if (operand.equals("*")) {
          evaluated = firstInt * secondInt + "";
        }
        else {
          evaluated = firstInt / secondInt + "";
        }
        laterTokens.set(laterTokens.size() - 1, evaluated);
      }
      else {
        laterTokens.add(operand);
        laterTokens.add(second);
      }
    }
    if (laterTokens.size() == 1) {
      return Integer.parseInt(laterTokens.get(0));
    }
    Integer curNum = Integer.parseInt(laterTokens.get(0));
    for (int i = 1; i < laterTokens.size(); i += 2) {
      String operand = laterTokens.get(i);
      String secondNum = laterTokens.get(i + 1);
      if (operand.equals("+")) {
        curNum += Integer.parseInt(secondNum);
      }
      else {
        curNum -= Integer.parseInt(secondNum);
      }
    }
    return curNum;
  }
}

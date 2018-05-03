package main.com.leetcode.problems.problem0150;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int evalRPN(String[] tokens) {
    Deque<String> stack = new ArrayDeque<>();
    for (String token : tokens) {
      if (isOperator(token)) {
        String second = stack.pop();
        String first = stack.pop();
        String evaluated = evaluate(first, second, token);
        stack.push(evaluated);
      }
      else {
        stack.push(token);
      }
    }
    return Integer.parseInt(stack.pop());
  }

  private boolean isOperator(String token) {
    return token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-");
  }

  private String evaluate(String first, String second, String operator) {
    Integer firstInt = Integer.parseInt(first);
    Integer secondInt = Integer.parseInt(second);
    switch (operator) {
      case "+":
        return firstInt + secondInt + "";
      case "-":
        return firstInt - secondInt + "";
      case "*":
        return firstInt * secondInt + "";
      case "/":
        return firstInt / secondInt + "";
      default:
        throw new IllegalArgumentException();
    }
  }
}

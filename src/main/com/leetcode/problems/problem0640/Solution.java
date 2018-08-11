package main.com.leetcode.problems.problem0640;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public String solveEquation(String equation) {
    List<Token> leftTokens = new ArrayList<>();
    TokenPair curPair;
    int index = 0;
    do {
      curPair = getNextToken(index, equation);
      leftTokens.add(curPair.token);
      index = curPair.nextIndex;
    } while (equation.charAt(index) != '=');

    index++;
    List<Token> rightTokens = new ArrayList<>();
    while (index < equation.length()) {
      curPair = getNextToken(index, equation);
      rightTokens.add(curPair.token);
      index = curPair.nextIndex;
    }

    //move x tokens left and num tokens right
    int xTokensSum = 0;
    int numTokensSum = 0;
    for (Token token : leftTokens) {
      if (token.isX) {
        xTokensSum += token.num;
      }
      else {
        numTokensSum -= token.num;
      }
    }

    for (Token token : rightTokens) {
      if (token.isX) {
        xTokensSum -= token.num;
      }
      else {
        numTokensSum += token.num;
      }
    }

    if (xTokensSum == 0 && numTokensSum == 0) {
      return "Infinite solutions";
    }
    else if (xTokensSum == 0) {
      return "No solution";
    }
    else {
      return "x=" + (numTokensSum / xTokensSum);
    }
  }

  private TokenPair getNextToken(int index, String equation) {
    StringBuilder numBuilder = new StringBuilder();
    boolean isX = false;
    boolean startedToken = false;
    while (index < equation.length()) {
      char currentChar = equation.charAt(index);
      boolean reachedEndOfToken = (startedToken && (currentChar == '-' || currentChar == '+' || currentChar == '='));
      if (reachedEndOfToken) {
        break;
      }
      if (currentChar == 'x') {
        isX = true;
      }
      //Integer.parseInt can't parse a '+' in a number
      else if (currentChar != '+') {
        numBuilder.append(currentChar);
      }
      startedToken = true;
      index++;
    }
    return new TokenPair(index, createToken(numBuilder, isX));
  }

  private Token createToken(StringBuilder numBuilder, boolean isX) {
    if (isX && numBuilder.length() == 0) {
      return new Token(1, true);
    }
    else if (isX && numBuilder.length() == 1 && numBuilder.charAt(0) == '-') {
      return new Token(-1, true);
    }
    else {
      return new Token(Integer.parseInt(numBuilder.toString()), isX);
    }
  }

  private static class TokenPair {
    int nextIndex;
    Token token;
    TokenPair(int nextIndex, Token token) {
      this.nextIndex = nextIndex;
      this.token = token;
    }
  }

  private static class Token {
    int num;
    boolean isX;
    Token(int num, boolean isX) {
      this.isX = isX;
      this.num = num;
    }
  }
}

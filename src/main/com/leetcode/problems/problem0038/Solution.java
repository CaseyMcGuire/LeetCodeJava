package main.com.leetcode.problems.problem0038;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public String countAndSay(int n) {
    StringBuilder currentSequence = new StringBuilder().append("1");
    for (int i = 1; i < n; i++) {
      List<Token> tokens = new ArrayList<>();
      Token curToken = new Token(currentSequence.charAt(0), 1);
      for (int j = 1; j < currentSequence.length(); j++) {
        char curChar = currentSequence.charAt(j);
        if (curChar == curToken.value) {
          curToken.numOccurrences++;
        }
        else {
          tokens.add(curToken);
          curToken = new Token(curChar, 1);
        }
      }
      tokens.add(curToken);
      currentSequence = getNextSequenceFromTokens(tokens);
    }
    return currentSequence.toString();
  }

  private StringBuilder getNextSequenceFromTokens(List<Token> tokens) {
    StringBuilder builder = new StringBuilder();
    for (Token token : tokens) {
      builder.append(token.numOccurrences).append(token.value);
    }
    return builder;
  }

  private static class Token {
    char value;
    int numOccurrences;

    Token(char value, int numOccurrences) {
      this.value = value;
      this.numOccurrences = numOccurrences;
    }
  }
}

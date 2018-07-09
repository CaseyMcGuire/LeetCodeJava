package main.com.leetcode.problems.problem0071;

import java.util.*;

public class Solution {
  public String simplifyPath(String path) {
    if (path == null) {
      return null;
    }
    Deque<String> fileDeque = new LinkedList<>();
    for (String token : getTokens(path)) {
      if (token.equals("..")) {
        if (!fileDeque.isEmpty()) {
          fileDeque.removeLast();
        }
      }
      else if (!token.equals(".")) {
        fileDeque.addLast(token);
      }
    }

    StringBuilder simplifiedPath = new StringBuilder();
    while (!fileDeque.isEmpty()) {
      simplifiedPath.append("/").append(fileDeque.removeFirst());
    }
    if (simplifiedPath.length() == 0) {
      simplifiedPath.append("/");
    }
    return simplifiedPath.toString();
  }

  private List<String> getTokens(String path) {
    Token currentToken = getNextToken(path, 0);
    List<String> tokens = new ArrayList<>();
    while (currentToken != null) {
      tokens.add(currentToken.token);
      currentToken = getNextToken(path, currentToken.nextStartingIndex);
    }
    return tokens;
  }

  private Token getNextToken(String path, int startingIndex) {
    // find first non-slash character
    int i = startingIndex;
    while (i < path.length() && path.charAt(i) == '/') {
      i++;
    }

    StringBuilder nextFile = new StringBuilder();
    for (; i < path.length() && path.charAt(i) != '/'; i++) {
      nextFile.append(path.charAt(i));
    }
    if (nextFile.length() == 0) {
      return null;
    }
    return new Token(nextFile.toString(), i);
  }

  private static class Token {
    String token;
    int nextStartingIndex;
    Token(String token, int nextStartingIndex) {
      this.token = token;
      this.nextStartingIndex = nextStartingIndex;
    }
  }
}

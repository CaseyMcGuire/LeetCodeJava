package main.com.leetcode.problems.problem0301;

import java.util.*;

public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    int maximumNumberOfDeletions = getMaximumNumberInvalidParentheses(s);
    if (maximumNumberOfDeletions == 0) {
      return Collections.singletonList(s);
    }
     return new ArrayList<>(removeInvalidParentheses(s, maximumNumberOfDeletions));
  }

  private Set<String> removeInvalidParentheses(String s, int maximumNumberOfDeletions) {
    Set<String> validParens = new HashSet<>();
    removeInvalidParentheses(s, 0, maximumNumberOfDeletions, 0, new StringBuilder(), validParens);
    return validParens;
  }

  private void removeInvalidParentheses(String s, int index, int numDeletionsRemaining, int numUnmatchedLeftParens, StringBuilder currentString, Set<String> validParens) {
    if (numDeletionsRemaining < 0 || numUnmatchedLeftParens < 0) {
      return;
    }
    if (index == s.length()) {
      if (numDeletionsRemaining == 0 && numUnmatchedLeftParens == 0) {
        validParens.add(currentString.toString());
      }
      return;
    }
    boolean needsToDelete = s.charAt(index) == ')' && numUnmatchedLeftParens == 0;
    boolean isParen = s.charAt(index) == ')' || s.charAt(index) == '(';
    char curChar = s.charAt(index);
    if (!isParen) {
      currentString.append(curChar);
      removeInvalidParentheses(s, index + 1, numDeletionsRemaining, numUnmatchedLeftParens, currentString, validParens);
      currentString.deleteCharAt(currentString.length() - 1);
    }
    else if (needsToDelete) {
      removeInvalidParentheses(s, index + 1, numDeletionsRemaining - 1, numUnmatchedLeftParens, currentString, validParens);
    }
    else if (curChar == ')') {
      // delete it
      removeInvalidParentheses(s, index + 1, numDeletionsRemaining - 1, numUnmatchedLeftParens, currentString, validParens);

      // add it
      currentString.append(curChar);
      removeInvalidParentheses(s, index + 1, numDeletionsRemaining, numUnmatchedLeftParens - 1, currentString, validParens);
      currentString.deleteCharAt(currentString.length() - 1);
    }
    else { // curChar == '('
      // delete it
      removeInvalidParentheses(s, index + 1, numDeletionsRemaining - 1, numUnmatchedLeftParens, currentString, validParens);

      //add it
      currentString.append(curChar);
      removeInvalidParentheses(s, index + 1, numDeletionsRemaining, numUnmatchedLeftParens + 1, currentString, validParens);
      currentString.deleteCharAt(currentString.length() - 1);
    }
  }

  private int getMaximumNumberInvalidParentheses(String s) {
    int numDeletions = 0;
    Deque<Character> parenStack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == ')' || c == '(') {
        if (c == '(') {
          parenStack.push(c);
        } else { // c == ')'
          if (parenStack.isEmpty()) {
            numDeletions++;
          } else {
            parenStack.pop();
          }
        }
      }
    }
    numDeletions += parenStack.size();
    return numDeletions;
  }
}

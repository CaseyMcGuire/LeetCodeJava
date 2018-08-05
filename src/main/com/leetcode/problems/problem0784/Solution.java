package main.com.leetcode.problems.problem0784;

import java.util.*;

public class Solution {
  public List<String> letterCasePermutation(String s) {
    Set<String> permutations = new HashSet<>();
    letterCasePermutation(s, 0, new LinkedList<>(), permutations);
    return new ArrayList<>(permutations);
  }

  private void letterCasePermutation(String s, int index, Deque<Character> currentPermutation, Set<String> permutations) {
    if (index == s.length()) {
      permutations.add(convertDequeToString(currentPermutation));
      return;
    }
    char curChar = s.charAt(index);
    LetterCase currentCharCase = getLetterCase(curChar);
    if (currentCharCase == LetterCase.NEITHER) {
      currentPermutation.addLast(curChar);
      letterCasePermutation(s, index + 1, currentPermutation, permutations);
      currentPermutation.removeLast();
    }
    else {
      final char other;
      if (currentCharCase == LetterCase.UPPER_CASE) {
        other = Character.toLowerCase(curChar);
      }
      else {
        other = Character.toUpperCase(curChar);
      }
      currentPermutation.addLast(curChar);
      letterCasePermutation(s, index + 1, currentPermutation, permutations);
      currentPermutation.removeLast();
      currentPermutation.addLast(other);
      letterCasePermutation(s, index + 1, currentPermutation, permutations);
      currentPermutation.removeLast();
    }
  }

  private LetterCase getLetterCase(char c) {
    if (!Character.isAlphabetic(c)) {
      return LetterCase.NEITHER;
    }
    else if (Character.isLowerCase(c)) {
      return LetterCase.LOWER_CASE;
    }
    else {
      return LetterCase.UPPER_CASE;
    }
  }

  private String convertDequeToString(Deque<Character> deque) {
    StringBuilder builder = new StringBuilder();
    for (char c : deque) {
      builder.append(c);
    }
    return builder.toString();
  }

  enum LetterCase {
    UPPER_CASE,
    LOWER_CASE,
    NEITHER
  }
}

package main.com.leetcode.problems.problem0796;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public boolean rotateString(String A, String B) {
    if (A.length() != B.length() || !haveSameLetters(A, B)) {
      return false;
    }
    if (A.length() == 0) {
      return true;
    }
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == B.charAt(0)) {
        if (isShifted(A, i, B)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isShifted(String shifted, int shiftStartIndex, String other) {

    for (int i = 0, shiftIndex = shiftStartIndex; i < other.length(); i++) {
      if (shifted.charAt(shiftIndex) != other.charAt(i)) {
        return false;
      }
      if (shiftIndex == shifted.length() - 1) {
        shiftIndex = 0;
      }
      else {
        shiftIndex++;
      }
    }
    return true;
  }

  private boolean haveSameLetters(String a, String b) {
    Map<Character, Integer> aCharToFrequency = new HashMap<>();
    Map<Character, Integer> bCharToFrequency = new HashMap<>();
    for (int i = 0; i < a.length(); i++) {
      aCharToFrequency.merge(a.charAt(i), 1, (current, iterate) -> current + iterate);
      bCharToFrequency.merge(b.charAt(i), 1, (current, iterate) -> current + iterate);
    }
    return aCharToFrequency.equals(bCharToFrequency);
  }
}

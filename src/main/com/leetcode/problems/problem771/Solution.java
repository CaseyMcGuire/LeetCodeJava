package main.com.leetcode.problems.problem771;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int numJewelsInStones(String J, String S) {
    Set<Character> stonesThatAreJewels = new HashSet<>();
    for (char c : J.toCharArray()) {
      stonesThatAreJewels.add(c);
    }
    int numStonesThatAreJewels = 0;
    for (char c : S.toCharArray()) {
      if (stonesThatAreJewels.contains(c)) {
        numStonesThatAreJewels++;
      }
    }
    return numStonesThatAreJewels;
  }
}

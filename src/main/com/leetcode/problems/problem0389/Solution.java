package main.com.leetcode.problems.problem0389;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public char findTheDifference(String s, String t) {
    Map<Character, Integer> sFrequencyMap = getFrequencyMap(s);
    Map<Character, Integer> tFrequencyMap = getFrequencyMap(t);
    for (Map.Entry<Character, Integer> entry : tFrequencyMap.entrySet()) {
      Integer sFrequency = sFrequencyMap.get(entry.getKey());
      if (sFrequency == null || sFrequency.intValue() != entry.getValue()) {
        return entry.getKey();
      }
    }
    throw new IllegalArgumentException();
  }

  private Map<Character, Integer> getFrequencyMap(String string) {
    Map<Character, Integer> charToFrequency = new HashMap<>();
    for (char c : string.toCharArray()) {
      charToFrequency.merge(c, 1, (cur, iter) -> cur + iter);
    }
    return charToFrequency;
  }
}

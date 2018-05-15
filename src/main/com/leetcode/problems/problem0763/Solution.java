package main.com.leetcode.problems.problem0763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public List<Integer> partitionLabels(String s) {

    Map<Character, Integer> charToLastIndex = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      charToLastIndex.put(s.charAt(i), i);
    }

    List<Integer> partitionLengths = new ArrayList<>();
    Integer currentLength = 0;
    Integer currentEndIndex = null;
    for (int i = 0; i < s.length(); i++) {
      int endIndex = charToLastIndex.get(s.charAt(i));
      if (currentEndIndex == null || endIndex > currentEndIndex) {
        currentEndIndex = endIndex;
      }
      currentLength++;
      if (i == currentEndIndex) {
        partitionLengths.add(currentLength);
        currentLength = 0;
        currentEndIndex = null;
      }
    }
    return partitionLengths;
  }
}

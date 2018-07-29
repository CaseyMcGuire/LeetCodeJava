package main.com.leetcode.problems.problem0670;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
  public int maximumSwap(int num) {
    StringBuilder numBuilder = new StringBuilder(num + "");
    OrderedFrequencyMap frequencyMap = getNumToFrequencyMap(numBuilder);
    for (int i = 0; i < numBuilder.length(); i++) {
      int currentNum = Character.getNumericValue(numBuilder.charAt(i));
      frequencyMap.decrement(currentNum, i);
      Integer largestIndex = frequencyMap.getLargestNumWithLargestIndex(currentNum);
      if (largestIndex != null) {
        char temp = numBuilder.charAt(i);
        char largerNumber = numBuilder.charAt(largestIndex);
        numBuilder.setCharAt(i, largerNumber);
        numBuilder.setCharAt(largestIndex, temp);
        break;
      }
    }
    return Integer.parseInt(numBuilder.toString());
  }

  private OrderedFrequencyMap getNumToFrequencyMap(StringBuilder num) {
    OrderedFrequencyMap frequencyMap = new OrderedFrequencyMap();
    for (int i = 0; i < num.length(); i++) {
      frequencyMap.increment(Character.getNumericValue(num.charAt(i)), i);
    }
    return frequencyMap;
  }

  private static class OrderedFrequencyMap {
    TreeMap<Integer, TreeSet<Integer>> numToIndices;

    OrderedFrequencyMap() {
      this.numToIndices = new TreeMap<>();
    }

    void increment(int num, int index) {
      TreeSet<Integer> indices = numToIndices.getOrDefault(num, new TreeSet<>());
      indices.add(index);
      numToIndices.put(num, indices);
    }

    void decrement(int num, int index) {
      TreeSet<Integer> indices = numToIndices.get(num);
      int frequency = indices.size();
      if (frequency == 1) {
        numToIndices.remove(num);
      }
      else {
        indices.remove(index);
        numToIndices.put(num, indices);
      }
    }

    Integer getLargestNumWithLargestIndex(int num) {
      Map.Entry<Integer, TreeSet<Integer>> largestNumEntry = numToIndices.tailMap(num, false).lastEntry();
      if (largestNumEntry == null) {
        return null;
      }
      return largestNumEntry.getValue().last();
    }
  }
}

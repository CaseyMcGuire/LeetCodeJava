package main.com.leetcode.problems.problem0169;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> numToFrequency = new HashMap<>();
    for (int num : nums) {
      numToFrequency.merge(num, 1, Integer::sum);
    }

    List<NumberFrequency> numberFrequencies =
        numToFrequency.entrySet()
                      .stream()
                      .map(entry -> new NumberFrequency(entry.getKey(), entry.getValue()))
                      .collect(Collectors.toList());

    Collections.sort(numberFrequencies);
    return numberFrequencies.get(0).number;
  }

  private static class NumberFrequency implements Comparable<NumberFrequency> {

    private int number;
    private int frequency;

    public NumberFrequency(int number, int frequency) {
      this.number = number;
      this.frequency = frequency;
    }

    @Override
    public int compareTo(NumberFrequency o) {
      return Integer.compare(o.frequency, frequency);
    }
  }
}

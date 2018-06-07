package main.com.leetcode.problems.problem0739;

import java.util.*;

public class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    TreeMap<Integer, List<Integer>> temperatureToIndex = new TreeMap<>();
    int[] daysToWait = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      NavigableMap<Integer, List<Integer>> lowerTemperatures = temperatureToIndex.headMap(temperatures[i], false);
      for (Map.Entry<Integer, List<Integer>> entry : lowerTemperatures.entrySet()) {
        for (int index : entry.getValue()) {
          daysToWait[index] = i - index;
        }
      }
      for (int temperature : new ArrayList<>(lowerTemperatures.keySet())) {
        temperatureToIndex.remove(temperature);
      }
      List<Integer> indices = temperatureToIndex.getOrDefault(temperatures[i], new ArrayList<>());
      indices.add(i);
      temperatureToIndex.put(temperatures[i], indices);
    }
    for (Map.Entry<Integer, List<Integer>> entry : temperatureToIndex.entrySet()) {
      for (int index : entry.getValue()) {
        daysToWait[index] = 0;
      }
    }
    return daysToWait;
  }
}

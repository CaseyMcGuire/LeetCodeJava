package main.com.leetcode.problems.problem0347;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  //O(n*lg(k))
  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> numToFrequency = new HashMap<>();
    for (int num : nums) {
      numToFrequency.merge(num, 1, (iter, current) -> iter + current);
    }
    TreeMap<Integer, List<Integer>> kMostFrequentToElements = new TreeMap<>();
    int numElements = 0;
    for (Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
      int num = entry.getKey();
      int frequency = entry.getValue();
      if (numElements < k) {
        kMostFrequentToElements.merge(frequency, listOf(num), this::mergeInto);
        numElements++;
      }
      else {
        Map.Entry<Integer, List<Integer>> leastFrequent = kMostFrequentToElements.firstEntry();
        int currentLeastFrequency = leastFrequent.getKey();
        //we found an element that's more frequent one in the map.
        if (currentLeastFrequency < frequency) {
          List<Integer> leastFrequentElements = leastFrequent.getValue();
          if (leastFrequentElements.size() > 1) {
            leastFrequentElements.remove(leastFrequentElements.size() - 1);
          }
          else {
            kMostFrequentToElements.remove(currentLeastFrequency);
          }
          kMostFrequentToElements.merge(frequency, listOf(num), this::mergeInto);
        }
      }
    }
    return kMostFrequentToElements.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
  }

  private List<Integer> listOf(int num) {
    List<Integer> list = new ArrayList<>();
    list.add(num);
    return list;
  }

  private List<Integer> mergeInto(List<Integer> mergeInto, List<Integer> mergeFrom) {
    mergeInto.addAll(mergeFrom);
    return mergeInto;
  }
}

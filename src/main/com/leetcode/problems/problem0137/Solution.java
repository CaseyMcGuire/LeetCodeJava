package main.com.leetcode.problems.problem0137;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int singleNumber(int[] nums) {
    Map<Integer, Integer> numFrequency = new HashMap<>();
    for (int num : nums) {
      int curFrequency = numFrequency.getOrDefault(num, 0);
      if (curFrequency == 2) {
        numFrequency.remove(num);
      }
      else {
        numFrequency.put(num, curFrequency + 1);
      }
    }
    for (int i : numFrequency.keySet()) {
      return i;
    }
    return -1;
  }
}

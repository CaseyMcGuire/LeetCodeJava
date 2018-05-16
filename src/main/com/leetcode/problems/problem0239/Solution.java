package main.com.leetcode.problems.problem0239;

import java.util.TreeMap;

public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k == 0) {
      return new int[]{};
    }
    int[] largestPerWindow = new int[nums.length - k + 1];
    TreeMap<Integer, Integer> numToFrequencyInWindow = new TreeMap<>();
    for (int i = 0; i < k; i++) {
      numToFrequencyInWindow.merge(nums[i], 1, (cur, iter) -> cur + iter);
    }

    for (int i = k - 1, j = 0; i < nums.length; i++, j++) {
      if (i != k - 1) {
        int prevNum = nums[j - 1];
        int prevFrequency = numToFrequencyInWindow.get(prevNum);
        if (prevFrequency == 1) {
          numToFrequencyInWindow.remove(prevNum);
        }
        else {
          numToFrequencyInWindow.put(prevNum, prevFrequency - 1);
        }
        numToFrequencyInWindow.merge(nums[i], 1, (cur, iter) -> cur + iter);
      }
      int largestElement = numToFrequencyInWindow.lastKey();
      largestPerWindow[j] = largestElement;
    }

    return largestPerWindow;
  }
}

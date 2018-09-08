package main.com.leetcode.problems.problem0031;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {
  public void nextPermutation(int[] nums) {
    TreeMap<Integer, Integer> numToIndex = new TreeMap<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      Map.Entry<Integer, Integer> largerEntry = numToIndex.higherEntry(nums[i]);
      if (largerEntry != null) {
        int temp = nums[i];
        nums[i] = largerEntry.getKey();
        nums[largerEntry.getValue()] = temp;
        rearrangeDescending(nums, i + 1);
        return;
      }
      numToIndex.put(nums[i], i);
    }
    rearrangeDescending(nums, 0);
  }

  private void rearrangeDescending(int[] nums, int startingIndex) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = startingIndex; i < nums.length; i++) {
      pq.add(nums[i]);
    }
    for (int i = startingIndex; i < nums.length; i++) {
      nums[i] = pq.poll();
    }
  }
}

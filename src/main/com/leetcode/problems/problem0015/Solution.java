package main.com.leetcode.problems.problem0015;

import java.util.*;

public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> uniqueTriples = new HashSet<>();
    Map<Integer, Integer> numToFrequency = getNumToFrequency(nums);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        break;
      }
      for (int j = i + 1; j < nums.length; j++) {
        int sum = nums[i] + nums[j];
        int remainder = -sum;
        Integer frequency = numToFrequency.get(remainder);
        if (frequency != null) {
          int numRequired = getFrequencyRequired(nums[i], nums[j], remainder);
          if (frequency >= numRequired) {
            List<Integer> triplet = Arrays.asList(nums[i], nums[j], remainder);
            Collections.sort(triplet);
            uniqueTriples.add(triplet);
          }
        }
      }
    }
    return new ArrayList<>(uniqueTriples);
  }

  private Map<Integer, Integer> getNumToFrequency(int[] nums) {
    Map<Integer, Integer> numToFrequency = new HashMap<>();
    for (int num : nums) {
      int curFrequency = numToFrequency.getOrDefault(num, 0);
      numToFrequency.put(num, curFrequency + 1);
    }
    return numToFrequency;
  }

  private int getFrequencyRequired(int first, int second, int third) {
    int frequencyRequired = 1;
    if (first == second) {
      frequencyRequired++;
    }
    else if (first == third) {
      frequencyRequired++;
    }
    if (second == third) {
      frequencyRequired++;
    }
    return frequencyRequired;
  }


  public static void main(String[] args) {
    System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }
}

package main.com.leetcode.problems.problem0015;

import java.util.*;

public class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    FrequencyMap frequencyMap = new FrequencyMap();
    Set<List<Integer>> triplets = new HashSet<>();
    for (int num : nums) {
      frequencyMap.incrementNum(num);
    }
    for (int i = 0; i < nums.length; i++) {
      int firstNum = nums[i];
      frequencyMap.decrementNum(firstNum);
      for (int j = i + 1; j < nums.length; j++) {
        int secondNum = nums[j];
        frequencyMap.decrementNum(secondNum);
        int remainder = 0 - (firstNum + secondNum);
        Integer frequency = frequencyMap.getFrequency(remainder);
        if (frequency != null) {
          triplets.add(createSortedTriplet(firstNum, secondNum, remainder));
        }
        frequencyMap.incrementNum(secondNum);
      }
      frequencyMap.incrementNum(firstNum);
    }
    return new ArrayList<>(triplets);
  }

  private List<Integer> createSortedTriplet(int first, int second, int third) {
    List<Integer> sortedList = new ArrayList<>();
    sortedList.add(first);
    sortedList.add(second);
    sortedList.add(third);
    Collections.sort(sortedList);
    return sortedList;
  }

  private static class FrequencyMap {
    private final Map<Integer, Integer> numToFrequency;
    FrequencyMap() {
      numToFrequency = new HashMap<>();
    }

    void incrementNum(int num) {
      numToFrequency.merge(num, 1, (cur, iter) -> cur + iter);
    }

    void decrementNum(int num) {
      Integer frequency = numToFrequency.get(num);
      if (frequency == 1) {
        numToFrequency.remove(num);
      }
      else {
        numToFrequency.put(num, frequency - 1);
      }
    }

    Integer getFrequency(int num) {
      return numToFrequency.get(num);
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));
  }
}

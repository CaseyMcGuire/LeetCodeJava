package main.com.leetcode.problems.problem0016;

import java.util.TreeMap;

public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    TreeMap<Integer, Integer> numToFrequency = new TreeMap<>();
    for (int num : nums) {
      numToFrequency.merge(num, 1, (cur, iter) -> cur + iter);
    }

    Integer closestSum = null;
    for (int i = 0; i < nums.length; i++) {
      int firstNum = nums[i];
      decrementEntry(numToFrequency, firstNum);
      for (int j = i + 1; j < nums.length; j++) {
        int secondNum = nums[j];
        decrementEntry(numToFrequency, secondNum);
        int remainder = target - (firstNum + secondNum);
        Integer closest = getClosestNumber(numToFrequency, remainder);
        if (closest != null) {
          int sum = firstNum + secondNum + closest;
          if (closestSum == null) {
            closestSum = sum;
          }
          closestSum = getCloserSum(closestSum, sum, target);
        }
        numToFrequency.merge(secondNum, 1, (cur, iter) -> cur + iter);
      }
      numToFrequency.merge(firstNum, 1, (cur, iter) -> cur + iter);
    }
    return closestSum;
  }

  private int getCloserSum(int firstSum, int secondSum, int target) {
    int firstDifference = Math.abs(firstSum - target);
    int secondDifference = Math.abs(secondSum - target);
    if (firstDifference < secondDifference) {
      return firstSum;
    }
    else {
      return secondSum;
    }
  }

  private Integer getClosestNumber(TreeMap<Integer, Integer> frequencyMap, int num) {
    Integer frequency = frequencyMap.get(num);
    if (frequency != null) {
      return num;
    }
    Integer higher = frequencyMap.higherKey(num);
    Integer lower = frequencyMap.lowerKey(num);
    if (higher == null && lower == null) {
      return null;
    }
    else if (higher == null) {
      return lower;
    }
    else if (lower == null) {
      return higher;
    }
    int higherDifference = Math.abs(higher - num);
    int lowerDifference = Math.abs(lower - num);
    if (higherDifference < lowerDifference) {
      return higher;
    }
    else {
      return lower;
    }
  }

  private void decrementEntry(TreeMap<Integer, Integer> frequencyMap, int num) {
    int frequency = frequencyMap.get(num);
    if (frequency == 1) {
      frequencyMap.remove(num);
    }
    else {
      frequencyMap.put(num, frequency - 1);
    }
  }
}

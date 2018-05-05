package main.com.leetcode.problems.problem0697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int findShortestSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Map<Integer, Integer> numToFrequency = new HashMap<>();
    Map<Integer, EndMostIndices> numToEndMostIndices = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      numToFrequency.merge(nums[i], 1, (cur, iter) -> cur + iter);
      EndMostIndices endMostIndices = numToEndMostIndices.getOrDefault(nums[i], new EndMostIndices(i, i));
      endMostIndices.rightMostIndex = i;
      numToEndMostIndices.put(nums[i], endMostIndices);
    }

    int largestDegreeSoFar = -1;
    List<EndMostIndices> endMostIndicesOfLargestDegreeNum = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
      int num = entry.getKey();
      int degree = entry.getValue();
      if (degree > largestDegreeSoFar) {
        largestDegreeSoFar = degree;
        endMostIndicesOfLargestDegreeNum = new ArrayList<>();
        endMostIndicesOfLargestDegreeNum.add(numToEndMostIndices.get(num));
      }
      else if (degree == largestDegreeSoFar) {
        endMostIndicesOfLargestDegreeNum.add(numToEndMostIndices.get(num));
      }
    }

    int currentMax = Integer.MAX_VALUE;
    for (EndMostIndices endMostIndices : endMostIndicesOfLargestDegreeNum) {
      int currentValue = endMostIndices.rightMostIndex - endMostIndices.leftMostIndex + 1;
      if (currentValue < currentMax) {
        currentMax = currentValue;
      }
    }
    return currentMax;
  }

  private static class EndMostIndices {
    private int leftMostIndex;
    private int rightMostIndex;

    EndMostIndices(int leftMostIndex, int rightMostIndex) {
      this.leftMostIndex = leftMostIndex;
      this.rightMostIndex = rightMostIndex;
    }
  }
}

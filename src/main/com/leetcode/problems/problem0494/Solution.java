package main.com.leetcode.problems.problem0494;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int findTargetSumWays(int[] nums, int S) {
    return findTargetSumWays(nums, S, 0, new Table());
  }

  private int findTargetSumWays(int[] nums, int S, int index, Table sumAndIndexToNumWays) {
    if (index == nums.length) {
      if (S == 0) {
        return 1;
      }
      else {
        return 0;
      }
    }
    Integer cachedNumWays = sumAndIndexToNumWays.get(S, index);
    if (cachedNumWays != null) {
      return cachedNumWays;
    }
    int numWays = findTargetSumWays(nums, S - nums[index], index + 1, sumAndIndexToNumWays) +
                  findTargetSumWays(nums, S + nums[index], index + 1, sumAndIndexToNumWays);
    sumAndIndexToNumWays.put(S, index, numWays);
    return numWays;
  }

  private static class Table {
    Map<Integer, Map<Integer, Integer>> table;

    Table() {
      table = new HashMap<>();
    }

    void put(int first, int second, int value) {
      Map<Integer, Integer> innerMap = table.getOrDefault(first, new HashMap<>());
      innerMap.put(second, value);
      table.put(first, innerMap);
    }

    Integer get(int first, int second) {
      Map<Integer, Integer> innerMap = table.get(first);
      if (innerMap == null) {
        return null;
      }
      return innerMap.get(second);
    }
  }
}

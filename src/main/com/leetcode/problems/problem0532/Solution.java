package main.com.leetcode.problems.problem0532;

import java.util.*;

public class Solution {
  public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k < 0) {
      return 0;
    }
    Map<Integer, Integer> numToFrequency = new HashMap<>();
    for (int num : nums) {
      numToFrequency.merge(num, 1, (cur, iter) -> cur + iter);
    }
    Set<KDiffPair> uniquePairs = new HashSet<>();
    for (Map.Entry<Integer, Integer> entry : numToFrequency.entrySet()) {
      int curNum = entry.getKey();
      int sum = curNum + k;
      Integer frequency = numToFrequency.get(sum);
      if (frequency == null) {
        continue;
      }

      if (sum == curNum && frequency > 1 || sum != curNum) {
        uniquePairs.add(new KDiffPair(curNum, sum));
      }
    }

    return uniquePairs.size();
  }

  private static class KDiffPair {
    private final Map<Integer, Integer> pair;

    KDiffPair(int first, int second) {
      pair = new HashMap<>();
      pair.merge(first, 1, (cur, iter) -> cur + iter);
      pair.merge(second, 1, (cur, iter) -> cur + iter);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      KDiffPair kDiffPair = (KDiffPair) o;
      return Objects.equals(pair, kDiffPair.pair);
    }

    @Override
    public int hashCode() {
      return Objects.hash(pair);
    }
  }
}

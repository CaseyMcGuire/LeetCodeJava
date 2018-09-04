package main.com.leetcode.problems.problem0528;

import java.util.Random;
import java.util.TreeMap;

public class Solution {

  private final TreeMap<Integer, Integer> runningWeightToIndex;
  private final Random random;
  private final int totalWeight;

  public Solution(int[] w) {
    runningWeightToIndex = new TreeMap<>();
    int runningWeight = 0;
    for (int i = 0; i < w.length; i++) {
      runningWeight += w[i];
      runningWeightToIndex.put(runningWeight, i);
    }
    random = new Random();
    totalWeight = runningWeight;
  }

  public int pickIndex() {
    int randomNum = random.nextInt(totalWeight);
    if (runningWeightToIndex.get(randomNum) != null) {
      return runningWeightToIndex.get(randomNum);
    }
    return runningWeightToIndex.higherEntry(randomNum).getValue();
  }
}

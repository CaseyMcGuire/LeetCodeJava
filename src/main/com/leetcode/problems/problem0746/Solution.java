package main.com.leetcode.problems.problem0746;

public class Solution {

  //The minimum cost for the Nth step is the cost of the cost of the Nth step plus the minimum of the cost of the (N+1)th
  //step and the (N+2)th step.
  public int minCostClimbingStairs(int[] cost) {
    if (cost.length == 1) {
      return cost[0];
    }
    int[] cache = calculateCache(cost);
    return Math.min(cache[0], cache[1]);
  }

  private int[] calculateCache(int[] costs) {
    int[] cache = new int[costs.length];
    cache[costs.length - 1] = costs[costs.length - 1];
    cache[costs.length - 2] = Math.min(costs[costs.length - 2], costs[costs.length - 2] + costs[costs.length - 1]);
    for (int i = costs.length - 3; i >= 0; i--) {
      cache[i] = costs[i] + Math.min(cache[i + 1], cache[i + 2]);
    }
    return cache;
  }
}

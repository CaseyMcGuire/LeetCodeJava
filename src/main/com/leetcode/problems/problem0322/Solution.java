package main.com.leetcode.problems.problem0322;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int coinChange(int[] coins, int amount) {
    return coinChange(coins, amount, new HashMap<>());
  }

  private int coinChange(int[] coins, int amount, Map<Integer, Integer> amountToFewestCoins) {
    if (amount < 0) {
      return -1;
    }
    else if (amount == 0) {
      return 0;
    }
    Integer fewest = amountToFewestCoins.get(amount);
    if (fewest != null) {
      return fewest;
    }
    Integer curFewest = null;
    for (int coin : coins) {
      int numCoins = coinChange(coins, amount - coin, amountToFewestCoins);
      if (numCoins == -1) {
        continue;
      }
      numCoins++;
      if (curFewest == null || curFewest > numCoins) {
        curFewest = numCoins;
      }
    }
    curFewest = curFewest != null ? curFewest : -1;
    amountToFewestCoins.put(amount, curFewest);
    return curFewest;
  }
}

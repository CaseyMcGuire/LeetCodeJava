package main.com.leetcode.problems.problem0121;

import java.util.TreeMap;

public class Solution {

  public int maxProfit(int[] prices) {
    if (prices.length == 0 || prices.length == 1) {
      return 0;
    }

    TreeMap<Integer, Integer> numsToFrequency = new TreeMap<>();
    for (int price : prices) {
      Integer frequency = numsToFrequency.getOrDefault(price, 0) + 1;
      numsToFrequency.put(price, frequency);
    }
    Integer curHighestProfit = null;
    for (int i = 0; i < prices.length - 1; i++) {
      int price = prices[i];
      Integer numOfPrice = numsToFrequency.get(price);
      if (numOfPrice.intValue() == 1) {
        numsToFrequency.remove(price);
      }
      else {
        numsToFrequency.put(price, numOfPrice - 1);
      }
      Integer highestPrice = numsToFrequency.lastKey();
      int profit = highestPrice.intValue() - price;
      if (curHighestProfit == null || curHighestProfit.intValue() < profit) {
        curHighestProfit = profit;
      }
    }
    return curHighestProfit >= 0 ? curHighestProfit : 0;
  }
}

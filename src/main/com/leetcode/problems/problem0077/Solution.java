package main.com.leetcode.problems.problem0077;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    Deque<Integer> currentCombination = new ArrayDeque<>();
    List<List<Integer>> allCombinations = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      combine(i, allCombinations, currentCombination, k, n);
    }
    return allCombinations;
  }

  private void combine(int curNum, List<List<Integer>> allCombinations, Deque<Integer> currentCombination, int k, int n) {
    currentCombination.push(curNum);
    if (currentCombination.size() == k) {
      allCombinations.add(new ArrayList<>(currentCombination));
      currentCombination.pop();
      return;
    }
    for (int i = curNum + 1; i <= n; i++) {
      combine(i, allCombinations, currentCombination, k, n);
    }
    currentCombination.pop();
  }


}

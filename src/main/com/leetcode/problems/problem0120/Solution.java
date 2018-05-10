package main.com.leetcode.problems.problem0120;

import java.util.List;

public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.isEmpty()) {
      return 0;
    }
    if (triangle.size() == 1) {
      return triangle.get(0).get(0);
    }

    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        int left = triangle.get(i + 1).get(j);
        int right = triangle.get(i + 1).get(j + 1);
        int current = Math.min(left, right) + triangle.get(i).get(j);
        triangle.get(i).set(j, current);
      }
    }

    return triangle.get(0).get(0);
  }
}

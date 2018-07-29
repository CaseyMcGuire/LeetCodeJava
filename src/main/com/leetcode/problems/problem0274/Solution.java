package main.com.leetcode.problems.problem0274;

import java.util.Arrays;

public class Solution {
  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }
    Arrays.sort(citations);
    for (int i = 0; i < citations.length; i++) {
      int h = citations.length - i;
      if (citations[i] >= h && (i == 0 || citations[i - 1] <= h)) {
        return h;
      }
    }
    return 0;
  }
}

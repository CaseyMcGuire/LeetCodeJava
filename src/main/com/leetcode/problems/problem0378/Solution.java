package main.com.leetcode.problems.problem0378;

import java.util.PriorityQueue;

public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        pq.add(matrix[i][j]);
      }
    }
    int iter = 0;
    while (iter < k - 1) {
      pq.poll();
      iter++;
    }
    return pq.poll();
  }
}

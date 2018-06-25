package main.com.leetcode.problems.problem0661;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int[][] imageSmoother(int[][] M) {
    if (M.length == 0 || M[0].length == 0) {
      return new int[][]{};
    }
    int[][] smoothedImage = new int[M.length][M[0].length];
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[i].length; j++) {
        smoothedImage[i][j] = average(getNeighbors(M, i, j));
      }
    }
    return smoothedImage;
  }

  private List<Integer> getNeighbors(int[][] M, int indexI, int indexJ) {
    List<Integer> nums = new ArrayList<>();
    for (int i = indexI - 1; i < indexI + 2; i++) {
      for (int j = indexJ - 1; j < indexJ + 2; j++) {
        if (i < 0 || i == M.length || j < 0 || j == M[i].length) {
          continue;
        }
        nums.add(M[i][j]);
      }
    }
    return nums;
  }

  private int average(List<Integer> nums) {
    double average = 0;
    for (int num : nums) {
      average += (double) num;
    }
    return (int) (average / nums.size());
  }
}

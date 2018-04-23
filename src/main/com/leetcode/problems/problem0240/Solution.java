package main.com.leetcode.problems.problem0240;

import java.util.Arrays;

public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length == 0) {
      return false;
    }
    if (matrix[0].length == 0) {
      return false;
    }
    for (int[] row : matrix) {
      if (target >= row[0] && target <= row[row.length - 1]) {
        int index = Arrays.binarySearch(row, target);
        if (index >= 0) {
          return true;
        }
      }
    }
    return false;
  }
}

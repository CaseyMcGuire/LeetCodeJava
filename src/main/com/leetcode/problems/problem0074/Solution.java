package main.com.leetcode.problems.problem0074;


import java.util.Arrays;

public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int index = findRow(matrix, target);
    return Arrays.binarySearch(matrix[index], target) >= 0;
  }

  private int findRow(int[][] matrix, int target) {
    int high = matrix.length - 1;
    int low = 0;
    while (low < high) {
      int mid = (high + low) / 2;
      int[] curRow = matrix[mid];
      if (curRow[0] <= target && curRow[curRow.length - 1] >= target) {
        return mid;
      }
      else if (matrix[mid][0] < target) {
        low = mid + 1;
      }
      else if (matrix[mid][0] > target) {
        high = mid - 1;
      }
    }
    return low;
  }
}

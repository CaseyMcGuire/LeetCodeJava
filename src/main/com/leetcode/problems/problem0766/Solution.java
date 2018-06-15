package main.com.leetcode.problems.problem0766;

public class Solution {
  public boolean isToeplitzMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return true;
    }
    int i = 0;
    int j = matrix[0].length;
    while (true) {
      if (!hasSameDiagonal(i, j, matrix)) {
        return false;
      }
      else if (j > 0) {
        j--;
      }
      else if (i < matrix.length) {
        i++;
      }
      else {
        break;
      }
    }
    return true;
  }

  private boolean hasSameDiagonal(int i, int j, int[][] matrix) {
    Integer num = null;
    for (; i < matrix.length && j < matrix[i].length; i++, j++) {
      if (num == null) {
        num = matrix[i][j];
      }
      else if (num != matrix[i][j]) {
        return false;
      }
    }
    return true;
  }
}

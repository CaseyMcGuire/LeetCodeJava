package main.com.leetcode.problems.problem0048;

public class Solution {
  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    int currentSubmatrix = 0;
    for (int i = matrix.length - 1; i >= 1; i -= 2) {
      int start = currentSubmatrix;
      int end = matrix.length - currentSubmatrix - 1;
      for (int j = 0; j < i; j++) {
        int topLeft = matrix[start][start + j];
        int topRight = matrix[start + j][end];
        int bottomRight = matrix[end][end - j];
        int bottomLeft = matrix[end - j][start];
        matrix[start][start + j] = bottomLeft;
        matrix[start + j][end] = topLeft;
        matrix[end][end - j] = topRight;
        matrix[end - j][start] = bottomRight;
      }
      currentSubmatrix++;
    }
  }
}

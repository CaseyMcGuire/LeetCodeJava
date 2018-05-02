package main.com.leetcode.problems.problem0073;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public void setZeroes(int[][] matrix) {
    Set<Integer> rows = new HashSet<>();
    Set<Integer> columns = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          columns.add(j);
        }
      }
    }

    for (Integer rowToZeroOut : rows) {
      int[] row = matrix[rowToZeroOut];
      for (int i = 0; i < row.length; i++) {
        row[i] = 0;
      }
    }

    for (Integer columnToZeroOut : columns) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][columnToZeroOut] = 0;
      }
    }
  }
}

package main.com.leetcode.problems.problem0311;


import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int[][] multiply(int[][] A, int[][] B) {
    int numRows = A.length;
    int numColumns = B[0].length;
    int[][] result = new int[numRows][numColumns];
    Set<Integer> aRowsWithAllZeroes = getRowsWithAllZeroes(A);
    Set<Integer> bColumnsWithAllZeroes = getColumnsWithAllZeroes(B);
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        int value;
        if (aRowsWithAllZeroes.contains(i) || bColumnsWithAllZeroes.contains(j)) {
          value = 0;
        }
        else {
          value = calculateSingleCell(i, j, A, B);
        }
        result[i][j] = value;
      }
    }
    return result;
  }

  private int calculateSingleCell(int row, int column, int[][] first, int[][] second) {
    int length = first[row].length;
    int sum = 0;
    for (int i = 0; i < length; i++) {
      sum += (first[row][i] * second[i][column]);
    }
    return sum;
  }


  private Set<Integer> getRowsWithAllZeroes(int[][] matrix) {
    return getRowOrColumnWithAllZeroes(matrix, true);
  }

  private Set<Integer> getColumnsWithAllZeroes(int[][] matrix) {
    return getRowOrColumnWithAllZeroes(matrix, false);
  }

  private Set<Integer> getRowOrColumnWithAllZeroes(int[][] matrix, boolean useRows) {
    Set<Integer> rowsWithAllZeroes = new HashSet<>();
    Set<Integer> columnsWithAllZeroes = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      rowsWithAllZeroes.add(i);
    }
    for (int i = 0; i < matrix[0].length; i++) {
      columnsWithAllZeroes.add(i);
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] != 0) {
          rowsWithAllZeroes.remove(i);
          columnsWithAllZeroes.remove(j);
        }
      }
    }
    if (useRows) {
      return rowsWithAllZeroes;
    }
    else {
      return columnsWithAllZeroes;
    }
  }


}

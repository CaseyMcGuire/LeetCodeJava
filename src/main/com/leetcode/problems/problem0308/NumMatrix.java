package main.com.leetcode.problems.problem0308;

public class NumMatrix {
  private final int[][] matrix;
  private final int[][] rowSumMatrix;

  public NumMatrix(int[][] matrix) {
    this.matrix = matrix;
    this.rowSumMatrix = createRowSumMatrix();
  }

  private int[][] createRowSumMatrix() {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new int[][]{{}};
    }
    int[][] rowSumMatrix = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < rowSumMatrix.length; i++) {
      for (int j = 0; j < rowSumMatrix[i].length; j++) {
        if (j == 0) {
          rowSumMatrix[i][j] = matrix[i][j];
        }
        else {
          rowSumMatrix[i][j] = rowSumMatrix[i][j - 1] + matrix[i][j];
        }
      }
    }
    return rowSumMatrix;
  }

  private int getRowSumValue(int row, int col) {
    if (col < 0) {
      return 0;
    }
    return rowSumMatrix[row][col];
  }

  public void update(int row, int col, int val) {
    this.matrix[row][col] = val;
    for (int curColumn = col; curColumn < rowSumMatrix[row].length; curColumn++) {
      if (curColumn == 0) {
        rowSumMatrix[row][curColumn] = val;
      }
      else {
        rowSumMatrix[row][curColumn] = rowSumMatrix[row][curColumn - 1] + matrix[row][curColumn];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int curRow = row1; curRow <= row2; curRow++) {
      int rowSum = (getRowSumValue(curRow, col2) - getRowSumValue(curRow, col1 - 1));
      sum += rowSum;
    }
    return sum;
  }
}

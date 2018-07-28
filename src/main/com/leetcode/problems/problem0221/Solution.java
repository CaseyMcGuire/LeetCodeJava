package main.com.leetcode.problems.problem0221;


public class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int largestSquareSoFar = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        int largestPossibleSquare = getLargestPossibleSquare(i, j, matrix);
        if (largestSquareSoFar >= largestPossibleSquare || matrix[i][j] == '0') {
          continue;
        }
        int largestSquare = calculateLargestSquare(i, j, matrix);
        if (largestSquare > largestSquareSoFar) {
          largestSquareSoFar = largestSquare;
        }
      }
    }
    return largestSquareSoFar;
  }

  private int getLargestPossibleSquare(int i, int j, char[][] matrix) {
    int shortestSideLength = getShorterSideLength(i, j, matrix);
    return shortestSideLength * shortestSideLength;
  }

  private int getShorterSideLength(int i, int j, char[][] matrix) {
    int rowLength = matrix.length - i;
    int columnLength = matrix[i].length - j;
    if (rowLength < columnLength) {
      return rowLength;
    }
    else {
      return columnLength;
    }
  }

  private int calculateLargestSquare(int i, int j, char[][] matrix) {
    int largestSquare = 1;
    int shortestSideLength = getShorterSideLength(i, j, matrix);
    for (int currentSquareSize = 1; currentSquareSize < shortestSideLength; currentSquareSize++) {
      if (matrix[i + currentSquareSize][j + currentSquareSize] == '0') {
        return largestSquare;
      }
      for (int k = i; k < i + currentSquareSize; k++) {
        if (matrix[k][j + currentSquareSize] == '0') {
          return largestSquare;
        }
      }
      for (int k = j; k < j + currentSquareSize; k++) {
        if (matrix[i + currentSquareSize][k] == '0') {
          return largestSquare;
        }
      }
      largestSquare = (currentSquareSize + 1) * (currentSquareSize + 1);
    }
    return largestSquare;
  }
}

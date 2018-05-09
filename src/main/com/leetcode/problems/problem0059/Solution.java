package main.com.leetcode.problems.problem0059;

public class Solution {
  public int[][] generateMatrix(int n) {
    if (n <= 0) {
      return new int[0][0];
    }
    int max = n * n;
    Direction curDirection = Direction.RIGHT;
    int curNum = 1;
    int row = 0;
    int column = 0;
    int[][] matrix = new int[n][n];
    while (curNum <= max) {
      matrix[row][column] = curNum;
      curNum++;
      curDirection = getNextDirection(matrix, row, column, curDirection);
      row = getNextRow(row, curDirection);
      column = getNextColumn(column, curDirection);
    }
    return matrix;
  }

  private Direction getNextDirection(int[][] matrix, int row, int column, Direction curDirection) {
    int nextRow = getNextRow(row, curDirection);
    int nextColumn = getNextColumn(column, curDirection);
    boolean needToChangeDirection = nextRow < 0 || nextRow >= matrix.length || nextColumn < 0 || nextColumn >= matrix[0].length || matrix[nextRow][nextColumn] != 0;
    if (needToChangeDirection) {
      return getNextDirection(curDirection);
    }
    else {
      return curDirection;
    }
  }

  private Direction getNextDirection(Direction curDirection) {
    switch (curDirection) {
      case LEFT:
        return Direction.UP;
      case RIGHT:
        return Direction.DOWN;
      case DOWN:
        return Direction.LEFT;
      case UP:
        return Direction.RIGHT;
    }
    throw new IllegalArgumentException("Unknown direction: " + curDirection);
  }

  private int getNextRow(int curRow, Direction direction) {
    switch (direction) {
      case LEFT:
      case RIGHT:
        return curRow;
      case UP:
        return curRow - 1;
      case DOWN:
        return curRow + 1;
    }
    throw new IllegalArgumentException("Unknown direction: " + direction);
  }

  private int getNextColumn(int curColumn, Direction direction) {
    switch (direction) {
      case UP:
      case DOWN:
        return curColumn;
      case RIGHT:
        return curColumn + 1;
      case LEFT:
        return curColumn - 1;
    }
    throw new IllegalArgumentException("Unknown direction: " + direction);
  }

  private enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;
  }
}

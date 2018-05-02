package main.com.leetcode.problems.problem0054;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return Collections.emptyList();
    }
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    List<Integer> spiralOrder = new ArrayList<>();
    int row = 0;
    int column = 0;
    int numRows = matrix.length;
    int numColumns = matrix[0].length;
    Direction curDirection = Direction.RIGHT;
    while (spiralOrder.size() < numRows * numColumns) {
      spiralOrder.add(matrix[row][column]);
      visited[row][column] = true;
      int nextRow = getNextRow(row, curDirection);
      int nextColumn = getNextColumn(column, curDirection);
      boolean needToChangeDirection = nextRow < 0 || nextRow >= numRows || nextColumn < 0 || nextColumn >= numColumns || visited[nextRow][nextColumn];
      if (needToChangeDirection) {
        curDirection = getNextDirection(curDirection);
        row = getNextRow(row, curDirection);
        column = getNextColumn(column, curDirection);
      }
      else {
        row = nextRow;
        column = nextColumn;
      }
    }
    return spiralOrder;
  }

  private int getNextRow(int row, Direction direction) {
    switch (direction) {
      case RIGHT:
      case LEFT:
        return row;
      case UP:
        return row - 1;
      case DOWN:
        return row + 1;
    }
    return -1;
  }

  private int getNextColumn(int column, Direction direction) {
    switch (direction) {
      case UP:
      case DOWN:
        return column;
      case RIGHT:
        return column + 1;
      case LEFT:
        return column - 1;
    }
    return -1;
  }

  private Direction getNextDirection(Direction direction) {
    switch (direction) {
      case UP:
        return Direction.RIGHT;
      case RIGHT:
        return Direction.DOWN;
      case DOWN:
        return Direction.LEFT;
      case LEFT:
        return Direction.UP;
    }
    return null;
  }

  private enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT
  }
}

package main.com.leetcode.problems.problem0051;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> validSolutions = new ArrayList<>();
    List<StringBuilder> board = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      board.add(new StringBuilder());
      for (int j = 0; j < n; j++) {
        board.get(i).append('.');
      }
    }

    solveNQueens(n, 0, board, validSolutions, new HashMap<>(), new HashSet<>());
    return validSolutions;
  }

  private void solveNQueens(int n, int row, List<StringBuilder> board, List<List<String>> validSolutions, Map<Point, Integer> forbiddenPointsToFrequency, Set<Integer> forbiddenColumns) {
    if (row == n) {
      validSolutions.add(board.stream().map(StringBuilder::toString).collect(Collectors.toList()));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (forbiddenColumns.contains(i) || forbiddenPointsToFrequency.containsKey(new Point(row, i))) {
        continue;
      }
      List<Point> newForbidden = getForbiddenPoints(row, i, n);

      forbiddenColumns.add(i);
      board.get(row).setCharAt(i, 'Q');
      for (Point point : newForbidden) {
        forbiddenPointsToFrequency.merge(point, 1, (cur, iter) -> cur + iter);
      }

      solveNQueens(n, row + 1, board, validSolutions, forbiddenPointsToFrequency, forbiddenColumns);

      forbiddenColumns.remove(i);
      board.get(row).setCharAt(i, '.');
      for (Point point : newForbidden) {
        Integer frequency = forbiddenPointsToFrequency.get(point);
        if (frequency == 1) {
          forbiddenPointsToFrequency.remove(point);
        }
        else {
          forbiddenPointsToFrequency.put(point, frequency - 1);
        }
      }
    }
  }

  private List<Point> getForbiddenPoints(int i, int j, int n) {
    List<Point> forbiddenPoints = new ArrayList<>();
    for (int k = 1; k < n; k++) {
      int forwardRow = i + k;
      int forwardColumn = j + k;
      int backwardRow = i - k;
      int backwardColumn = j - k;

      if (isInBounds(forwardRow, n)) {
        if (isInBounds(forwardColumn, n)) {
          forbiddenPoints.add(new Point(forwardRow, forwardColumn));
        }
        if (isInBounds(backwardColumn, n)) {
          forbiddenPoints.add(new Point(forwardRow, backwardColumn));
        }
      }

      if (isInBounds(backwardRow, n)) {
        if (isInBounds(forwardColumn, n)) {
          forbiddenPoints.add(new Point(backwardRow, forwardColumn));
        }
        if (isInBounds(backwardColumn, n)) {
          forbiddenPoints.add(new Point(backwardRow, backwardColumn));
        }
      }

    }
    return forbiddenPoints;
  }


  private boolean isInBounds(int i, int n) {
    return i >= 0 && i < n;
  }

  private static class Point {
    private int i;
    private int j;

    Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public int hashCode() {
      return Objects.hash(i, j);
    }

    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }

      if (!(o instanceof Point)) {
        return false;
      }
      Point other = (Point) o;
      return i == other.i && j == other.j;
    }
  }
}

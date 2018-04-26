package main.com.leetcode.problems.problem0200;

import java.util.*;

public class Solution {
  public int numIslands(char[][] grid) {
    Set<Coordinate> visitedLand = new HashSet<>();
    int numIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        boolean isLand = grid[i][j] == '1';

        if (isLand) {
          Coordinate currentCoordinate = new Coordinate(i, j);
          if (!visitedLand.contains(currentCoordinate)) {
            visitRestOfIsland(currentCoordinate, grid, visitedLand);
            numIslands++;
          }
        }
      }
    }
    return numIslands;
  }

  private void visitRestOfIsland(Coordinate start, char[][] grid, Set<Coordinate> visitedLand) {
    Deque<Coordinate> stack = new ArrayDeque<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      Coordinate current = stack.pop();
      visitedLand.add(current);
      for (Coordinate neighbor : current.getNeighbors()) {
        if (isLandCoordinate(neighbor, grid) && !visitedLand.contains(neighbor)) {
          stack.push(neighbor);
        }
      }
    }
  }

  private boolean isLandCoordinate(Coordinate coordinate, char[][] grid) {
    if (coordinate.i < 0 || coordinate.i >= grid.length) {
      return false;
    }
    if (coordinate.j < 0 || coordinate.j >= grid[0].length) {
      return false;
    }
    return grid[coordinate.i][coordinate.j] == '1';
  }

  private static class Coordinate {
    int i;
    int j;

    Coordinate(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public List<Coordinate> getNeighbors() {
      return Arrays.asList(
          new Coordinate(i + 1, j),
          new Coordinate( i - 1, j),
          new Coordinate( i, j + 1),
          new Coordinate( i, j - 1)
      );
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Coordinate that = (Coordinate) o;
      return i == that.i &&
          j == that.j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }
}

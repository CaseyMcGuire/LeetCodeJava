package main.com.leetcode.problems.problem0463;

import java.util.*;

public class Solution {
  public int islandPerimeter(int[][] grid) {
    Coordinate initialCoordinate = findInitialCoordinate(grid);
    if (initialCoordinate == null) {
      return 0;
    }
    int perimeter = 0;
    Deque<Coordinate> pendingCoordinate = new ArrayDeque<>();
    Set<Coordinate> consideredCoordinates = new HashSet<>();
    pendingCoordinate.push(initialCoordinate);
    consideredCoordinates.add(initialCoordinate);
    while (!pendingCoordinate.isEmpty()) {
      Coordinate currentCoordinate = pendingCoordinate.pop();
      List<Coordinate> validNeighbors = currentCoordinate.getNeighbors(grid);
      int bordersByWater = 4 - validNeighbors.size();
      perimeter += bordersByWater;
      for (Coordinate neighbor : validNeighbors) {
        if (!consideredCoordinates.contains(neighbor)) {
          consideredCoordinates.add(neighbor);
          pendingCoordinate.push(neighbor);
        }
      }
    }
    return perimeter;
  }

  private Coordinate findInitialCoordinate(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          return new Coordinate(i, j);
        }
      }
    }
    return null;
  }

  private boolean isValid(Coordinate coordinate, int[][] grid) {
    return coordinate.i < grid.length && coordinate.i >= 0 && coordinate.j < grid[0].length && coordinate.j >= 0 && grid[coordinate.i][coordinate.j] == 1;
  }

  private static class Coordinate {
    int i;
    int j;
    Coordinate(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public List<Coordinate> getNeighbors(int grid[][]) {
      List<Coordinate> neighbors = new ArrayList<>();
      if (i > 0 && grid[i - 1][j] == 1) {
        neighbors.add(new Coordinate(i - 1, j));
      }
      if (i < grid.length - 1 && grid[i + 1][j] == 1) {
        neighbors.add(new Coordinate(i + 1, j));
      }
      if (j > 0 && grid[i][j - 1] == 1) {
        neighbors.add(new Coordinate(i, j - 1));
      }
      if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
        neighbors.add(new Coordinate(i, j + 1));
      }
      return neighbors;
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

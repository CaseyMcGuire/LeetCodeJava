package main.com.leetcode.problems.problem0694;


import java.util.*;

public class Solution {
  public int numDistinctIslands(int[][] grid) {
    Set<Point> visited = new HashSet<>();
    List<Island> islands = new ArrayList<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (visited.contains(new Point(i, j)) || grid[i][j] == 0) {
          continue;
        }
        Island island = findIsland(i, j, grid, visited);
        boolean foundTranslation = false;
        for (Island existingIsland : islands) {
          if (existingIsland.isTranslation(island)) {
            foundTranslation = true;
            break;
          }
        }
        if (!foundTranslation) {
          islands.add(island);
        }
      }
    }
    return islands.size();
  }

  private Island findIsland(int i, int j, int[][] grid, Set<Point> visited) {
    Island curIsland = new Island(i, j, new HashSet<>());
    findIsland(i, j, grid, curIsland, visited);
    return curIsland;
  }

  private void findIsland(int i, int j, int[][] grid, Island curIsland, Set<Point> visited) {
    if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0) {
      return;
    }
    Point point = new Point(i, j);
    if (!visited.add(point)) {
      return;
    }
    curIsland.points.add(point);
    findIsland(i - 1, j, grid, curIsland, visited);
    findIsland(i + 1, j, grid, curIsland, visited);
    findIsland(i, j - 1, grid, curIsland, visited);
    findIsland(i, j + 1, grid, curIsland, visited);
  }

  private static class Island {
    private int leftIndex;
    private int topIndex;
    private Set<Point> points;

    Island(int leftIndex, int topIndex, Set<Point> points) {
      this.leftIndex = leftIndex;
      this.topIndex = topIndex;
      this.points = points;
    }

    public boolean isTranslation(Island other) {
      if (this.points.size() != other.points.size()) {
        return false;
      }
      int topOffset = other.topIndex - this.topIndex;
      int leftOffset = other.leftIndex - this.leftIndex;
      for (Point point : points) {
        Point adjustedPoint = new Point(point.i + leftOffset, point.j + topOffset);
        if (!other.points.contains(adjustedPoint)) {
          return false;
        }
      }
      return true;
    }

  }

  private static class Point {
    int i;
    int j;

    Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return i == point.i &&
          j == point.j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }
}

package main.com.leetcode.problems.problem0542;

import java.util.*;

public class Solution {
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new int[][]{};
    }
    Set<Coordinate> visited = new HashSet<>();
    Set<Coordinate> pendingForCurrentLevel = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] != 0) {
          Coordinate coordinate = new Coordinate(i, j, matrix);
          if (coordinate.hasNeighborOfType(0)) {
            pendingForCurrentLevel.add(coordinate);
          }
        }
      }
    }

    int[][] updatedMatrix = new int[matrix.length][matrix[0].length];
    int currentDepth = 1;
    while (!pendingForCurrentLevel.isEmpty()) {
      Set<Coordinate> pendingForNextLevel = new HashSet<>();

      for (Coordinate coordinate : pendingForCurrentLevel) {
        if (visited.contains(coordinate)) {
          continue;
        }
        visited.add(coordinate);
        updatedMatrix[coordinate.i][coordinate.j] = currentDepth;
        for (Coordinate neighbor : coordinate.getNeighborsOfType(1)) {
          pendingForNextLevel.add(neighbor);
        }
      }
      pendingForCurrentLevel = pendingForNextLevel;
      currentDepth++;

    }
    return updatedMatrix;
  }

  private static class Coordinate {
    int i;
    int j;
    int[][] matrix;

    Coordinate(int i, int j, int[][] matrix) {
      this.i = i;
      this.j = j;
      this.matrix = matrix;
    }

    public List<Coordinate> getNeighborsOfType(int type) {
      List<Coordinate> neighbors = new ArrayList<>();
      if (i > 0 && matrix[i - 1][j] == type) {
        neighbors.add(new Coordinate(i - 1, j, matrix));
      }
      if (i < matrix.length - 1 && matrix[i + 1][j] == type) {
        neighbors.add(new Coordinate(i + 1, j, matrix));
      }
      if (j > 0 && matrix[i][j - 1] == type) {
        neighbors.add(new Coordinate(i, j - 1, matrix));
      }
      if (j < matrix[i].length - 1 && matrix[i][j + 1] == type) {
        neighbors.add(new Coordinate(i, j + 1, matrix));
      }
      return neighbors;
    }

    public boolean hasNeighborOfType(int type) {
      return getNeighborsOfType(type).size() > 0;
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

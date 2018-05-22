package main.com.leetcode.problems.problem0361;

import java.util.*;

public class Solution {

  private Map<Coordinate, Integer> coordinateToNumKilledInRow;
  private Map<Coordinate, Integer> coordinateToNumKilledInColumn;

  public int maxKilledEnemies(char[][] grid) {

    coordinateToNumKilledInColumn = new HashMap<>();
    coordinateToNumKilledInRow = new HashMap<>();
    int maxSoFar = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 'W' || grid[i][j] == 'E') {
          continue;
        }
        int numKilledInRow = getNumKilledInRow(i, j, grid);
        int numKilledInColumn = getNumKilledInColumn(i, j, grid);
        int totalKilled = numKilledInColumn + numKilledInRow;
        if (totalKilled > maxSoFar) {
          maxSoFar = totalKilled;
        }
      }
    }
    return maxSoFar;
  }

  private int getNumKilledInRow(int i, int j, char[][] grid) {
    Integer numKilledInRow = coordinateToNumKilledInRow.get(new Coordinate(i, j));
    if (numKilledInRow != null) {
      return numKilledInRow;
    }
    numKilledInRow = 0;
    List<Coordinate> openCoordinatesAffected = new ArrayList<>();
    //first go left
    for (int k = j - 1; k >= 0; k--) {
      if (grid[i][k] == 'W') {
        break;
      }
      else if (grid[i][k] == '0') {
        openCoordinatesAffected.add(new Coordinate(i, k));
      }
      else { //grid[i][k] == 'E'
        numKilledInRow++;
      }
    }

    //then go right
    for (int k = j + 1; k < grid[i].length; k++) {
      if (grid[i][k] == 'W') {
        break;
      }
      else if (grid[i][k] == '0') {
        openCoordinatesAffected.add(new Coordinate(i, k));
      }
      else { //grid[i][k] == 'E'
        numKilledInRow++;
      }
    }

    for (Coordinate coordinate : openCoordinatesAffected) {
      coordinateToNumKilledInRow.put(coordinate, numKilledInRow);
    }
    coordinateToNumKilledInRow.put(new Coordinate(i, j), numKilledInRow);
    return numKilledInRow;
  }

  private int getNumKilledInColumn(int i, int j, char[][] grid) {
    Integer numKilledInColumn = coordinateToNumKilledInColumn.get(new Coordinate(i, j));
    if (numKilledInColumn != null) {
      return numKilledInColumn;
    }
    numKilledInColumn = 0;

    List<Coordinate> openCoordinatesAffected = new ArrayList<>();
    for (int k = i - 1; k >= 0; k--) {
      if (grid[k][j] == 'W') {
        break;
      }
      else if (grid[k][j] == '0') {
        openCoordinatesAffected.add(new Coordinate(k, j));
      }
      else {
        numKilledInColumn++;
      }
    }

    for (int k = i + 1; k < grid.length; k++) {
      if (grid[k][j] == 'W') {
        break;
      }
      else if (grid[k][j] == '0') {
        openCoordinatesAffected.add(new Coordinate(k, j));
      }
      else {
        numKilledInColumn++;
      }
    }

    for (Coordinate coordinate : openCoordinatesAffected) {
      coordinateToNumKilledInColumn.put(coordinate, numKilledInColumn);
    }
    coordinateToNumKilledInColumn.put(new Coordinate(i, j), numKilledInColumn);
    return numKilledInColumn;
  }

  private static class Coordinate {
    private int i;
    private int j;
    Coordinate(int i, int j) {
      this.i = i;
      this.j = j;
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

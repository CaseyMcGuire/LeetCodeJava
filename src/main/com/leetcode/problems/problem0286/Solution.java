package main.com.leetcode.problems.problem0286;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public void wallsAndGates(int[][] rooms) {
    List<Coordinate> gates = getGates(rooms);

    List<Coordinate> currentLevel = new ArrayList<>();
    for (Coordinate gate : gates) {
      currentLevel.addAll(gate.getNeighbors());
    }

    List<Coordinate> nextLevel = new ArrayList<>();
    int level = 1;
    while (!currentLevel.isEmpty()) {
      for (Coordinate coordinate : currentLevel) {
        if (!isInBounds(coordinate, rooms) || rooms[coordinate.i][coordinate.j] != Integer.MAX_VALUE) {
          continue;
        }
        rooms[coordinate.i][coordinate.j] = level;
        nextLevel.addAll(coordinate.getNeighbors());
      }
      currentLevel = nextLevel;
      nextLevel = new ArrayList<>();
      level++;
    }
  }

  private boolean isInBounds(Coordinate coordinate, int[][] rooms) {
    return coordinate.i >= 0 && coordinate.i < rooms.length && coordinate.j >= 0 && coordinate.j < rooms[coordinate.i].length;
  }

  private List<Coordinate> getGates(int[][] rooms) {
    List<Coordinate> gates = new ArrayList<>();
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[i].length; j++) {
        if (rooms[i][j] == 0) {
          gates.add(new Coordinate(i, j));
        }
      }
    }
    return gates;
  }

  private static class Coordinate {
    private final int i;
    private final int j;

    Coordinate(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public List<Coordinate> getNeighbors() {
      return Arrays.asList(
          new Coordinate(i + 1, j),
          new Coordinate(i - 1, j),
          new Coordinate(i, j + 1),
          new Coordinate(i, j - 1)
      );
    }
  }
}

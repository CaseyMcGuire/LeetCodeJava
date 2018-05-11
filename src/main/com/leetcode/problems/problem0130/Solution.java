package main.com.leetcode.problems.problem0130;

import java.util.*;

public class Solution {

  private Set<Pair> visitedOPairs;

  public void solve(char[][] board) {
    visitedOPairs = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'O' && !visitedOPairs.contains(new Pair(i, j))) {
          searchForBorder(board, i, j);
        }
      }
    }
  }

  private void searchForBorder(char[][] board, int i, int j) {
    Set<Pair> visited = new HashSet<>();
    Deque<Pair> unvisitedOhNeighbors = new ArrayDeque<>();
    Pair start = new Pair(i, j);
    visited.add(start);
    unvisitedOhNeighbors.push(start);
    boolean reachedBorder = false;
    while (!unvisitedOhNeighbors.isEmpty()) {
      Pair current = unvisitedOhNeighbors.pop();
      reachedBorder = reachedBorder || isOnBorder(board, current);
      List<Pair> neighbors = current.getNeighbors();

      for (Pair neighbor : neighbors) {
        boolean isValid = neighbor.i >= 0 &&
            neighbor.i < board.length &&
            neighbor.j >= 0 &&
            neighbor.j < board[neighbor.i].length &&
            board[neighbor.i][neighbor.j] == 'O' &&
            !visited.contains(neighbor);
        if (isValid) {
          unvisitedOhNeighbors.push(neighbor);
          visited.add(neighbor);
        }
      }
    }

    if (!reachedBorder) {
      for (Pair pair : visited) {
        board[pair.i][pair.j] = 'X';
      }
    }
    visitedOPairs.addAll(visited);
  }



  private boolean isOnBorder(char[][] board, Pair current) {
    return current.i == 0 || current.j == 0 || current.i == board.length - 1 || current.j == board[current.i].length - 1;
  }

  private static class Pair {
    int i;
    int j;

    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public List<Pair> getNeighbors() {
      return Arrays.asList(
          new Pair(i + 1, j),
          new Pair(i - 1, j),
          new Pair(i, j + 1),
          new Pair(i, j - 1)
      );
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Pair pair = (Pair) o;
      return i == pair.i &&
          j == pair.j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }

}

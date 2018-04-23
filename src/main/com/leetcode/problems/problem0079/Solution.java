package main.com.leetcode.problems.problem0079;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public boolean exist(char[][] board, String word) {
    Set<Index> startingIndices = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          startingIndices.add(new Index(i, j));
        }
      }
    }
    Set<Index> traversedIndices = new HashSet<>();
    for (Index index : startingIndices) {
      traversedIndices.add(index);
      boolean exists = exist(board, index, word, 0, traversedIndices);
      traversedIndices.remove(index);
      if (exists) {
        return true;
      }
    }
    return false;
  }

  private boolean exist(char[][] board, Index curIndex, String word, int index, Set<Index> traversedIndices) {

    if (word.charAt(index) != board[curIndex.i][curIndex.j]) {
      return false;
    }
    if (index == word.length() - 1) {
      return true;
    }
    List<Index> unvisitedNeighbors = curIndex.getNeighbors()
                                             .stream()
                                             .filter(i -> !traversedIndices.contains(i) && isWithinBoard(i, board))
                                             .collect(Collectors.toList());
    for (Index unvisitedNeighbor : unvisitedNeighbors) {
      traversedIndices.add(unvisitedNeighbor);
      boolean exists = exist(board, unvisitedNeighbor, word, index + 1, traversedIndices);
      traversedIndices.remove(unvisitedNeighbor);
      if (exists) {
        return true;
      }
    }
    return false;
  }

  private boolean isWithinBoard(Index index, char[][] board) {
    if (index.i < 0 || index.i >= board.length) {
      return false;
    }
    if (index.j < 0 || index.j >= board[0].length) {
      return false;
    }
    return true;
  }




  private static class Index {
    int i;
    int j;

    Index(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public List<Index> getNeighbors() {
      return Arrays.asList(new Index(i + 1, j),
                           new Index(i - 1, j),
                           new Index(i, j - 1),
                           new Index(i, j + 1));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Index index = (Index) o;
      return i == index.i &&
          j == index.j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }


}

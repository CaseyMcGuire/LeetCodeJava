package main.com.leetcode.problems.problem0212;

import java.util.*;

public class Solution {
  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      root.insert(word);
    }
    Set<String> foundWords = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        foundWords.addAll(findWords(board, i, j, root));
      }
    }
    return new ArrayList<>(foundWords);
  }

  private Set<String> findWords(char[][] board, int i, int j, TrieNode root) {
    Set<String> foundWords = new HashSet<>();
    findWords(board, new Coordinate(i,j), root, foundWords, new HashSet<>());
    return foundWords;
  }

  private void findWords(char[][] board, Coordinate currentCoordinate, TrieNode node, Set<String> foundWords, Set<Coordinate> visitedCoordinates) {
    visitedCoordinates.add(currentCoordinate);
    TrieNode next = node.get(board[currentCoordinate.i][currentCoordinate.j]);
    if (next != null) {
      if (next.word != null) {
        foundWords.add(next.word);
      }
      for (Coordinate neighbor : currentCoordinate.getValidNeighbors(board.length, board[0].length)) {
        if (!visitedCoordinates.contains(neighbor)) {
          findWords(board, neighbor, next, foundWords, visitedCoordinates);
        }
      }
    }
    visitedCoordinates.remove(currentCoordinate);
  }

  private static class Coordinate {
    private int i;
    private int j;

    Coordinate(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public List<Coordinate> getValidNeighbors(int maxI, int maxJ) {
      List<Coordinate> coordinates = new ArrayList<>();
      for (int i = -1; i < 2; i += 2) {
        int newI = i + this.i;
        if (newI >= 0 && newI < maxI) {
          coordinates.add(new Coordinate(newI, j));
        }
      }
      for (int j = -1; j < 2; j += 2) {
        int newJ = j + this.j;
        if (newJ >= 0 && newJ < maxJ) {
          coordinates.add(new Coordinate(i, newJ));
        }
      }
      return coordinates;
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

  private static class TrieNode {
    private Map<Character, TrieNode> nodes;
    private String word;

    TrieNode() {
      this.word = null;
      nodes = new HashMap<>();
    }

    void insert(String word) {
      TrieNode currentNode = this;
      for (char c : word.toCharArray()) {
        TrieNode next = currentNode.nodes.getOrDefault(c, new TrieNode());
        currentNode.nodes.put(c, next);
        currentNode = next;
      }
      currentNode.word = word;
    }

    TrieNode get(char c) {
      return nodes.get(c);
    }
  }
}

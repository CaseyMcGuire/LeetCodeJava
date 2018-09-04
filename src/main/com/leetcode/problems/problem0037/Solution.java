package main.com.leetcode.problems.problem0037;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public void solveSudoku(char[][] board) {
    Map<Integer, Set<Integer>> columnToNums = getIndexToNums();
    Map<Integer, Set<Integer>> rowToNums = getIndexToNums();
    Map<Integer, Set<Integer>> squareToNums = getIndexToNums();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        int num = Character.getNumericValue(board[i][j]);
        columnToNums.get(j).remove(num);
        rowToNums.get(i).remove(num);
        squareToNums.get(getSquareIndex(i, j)).remove(num);
      }
    }
    solve(board, 0, 0, columnToNums, rowToNums, squareToNums);
  }

  private boolean solve(char[][] board,
                        int i,
                        int j,
                        Map<Integer, Set<Integer>> columnToNums,
                        Map<Integer, Set<Integer>> rowToNums,
                        Map<Integer, Set<Integer>> squareToNums) {
    if (i == board.length - 1 && j == board[i].length) {
      return true;
    }
    else if (j == board[i].length) {
      return solve(board, i + 1, 0, columnToNums, rowToNums, squareToNums);
    }
    else if (board[i][j] != '.') {
      return solve(board, i, j + 1, columnToNums, rowToNums, squareToNums);
    }
    Set<Integer> potentialNums = getPotentialNums(i, j, columnToNums, rowToNums, squareToNums);
    char temp = board[i][j];
    for (int potentialNum : potentialNums) {
      board[i][j] = Character.forDigit(potentialNum, 10);
      columnToNums.get(j).remove(potentialNum);
      rowToNums.get(i).remove(potentialNum);
      squareToNums.get(getSquareIndex(i, j)).remove(potentialNum);
      boolean solved = solve(board, i, j + 1, columnToNums, rowToNums, squareToNums);
      if (solved) {
        return true;
      }
      columnToNums.get(j).add(potentialNum);
      rowToNums.get(i).add(potentialNum);
      squareToNums.get(getSquareIndex(i, j)).add(potentialNum);
    }
    board[i][j] = temp;
    return false;
  }

  private Set<Integer> getPotentialNums(int i,
                                        int j,
                                        Map<Integer, Set<Integer>> columnToNums,
                                        Map<Integer, Set<Integer>> rowToNums,
                                        Map<Integer, Set<Integer>> squareToNums) {
    Set<Integer> potentialNums = new HashSet<>(columnToNums.get(j));
    potentialNums = getIntersection(potentialNums, rowToNums.get(i));
    potentialNums = getIntersection(potentialNums, squareToNums.get(getSquareIndex(i, j)));
    return potentialNums;
  }

  private Set<Integer> getIntersection(Set<Integer> first, Set<Integer> second) {
    Set<Integer> intersection = new HashSet<>();
    for (int num : first) {
      if (second.contains(num)) {
        intersection.add(num);
      }
    }
    return intersection;
  }

  private int getSquareIndex(int i, int j) {
    i = normalizeNum(i);
    j = normalizeNum(j);
    if (i == 0) {
      return j;
    }
    else if (i == 1) {
      return j + 3;
    }
    else {
      return j + 6;
    }
  }

  private int normalizeNum(int num) {
    if (num < 3) {
      return 0;
    }
    else if (num < 6) {
      return 1;
    }
    else {
      return 2;
    }
  }

  private Map<Integer, Set<Integer>> getIndexToNums() {
    Map<Integer, Set<Integer>> indexToNums = new HashMap<>();
    for (int i = 0; i < 9; i++) {
      Set<Integer> nums = new HashSet<>();
      for (int j = 1; j <= 9; j++) {
        nums.add(j);
      }
      indexToNums.put(i, nums);
    }
    return indexToNums;
  }
}

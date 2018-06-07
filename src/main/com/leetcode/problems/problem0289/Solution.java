package main.com.leetcode.problems.problem0289;

public class Solution {
  public void gameOfLife(int[][] board) {
    if (board.length == 0 || board[0].length == 0) {
      return;
    }
    int[][] newBoard = new int[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        newBoard[i][j] = getNextStateForCell(i, j, board);
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = newBoard[i][j];
      }
    }
  }

  private int getNextStateForCell(int i, int j, int[][] board) {
    int numNeighbors = 0;
    boolean isCurrentlyAlive = board[i][j] == 1;
    for (int k = -1; k < 2; k++) {
      for (int h = -1; h < 2; h++) {
        if (k == 0 && h == 0) {
          continue;
        }
        int neighborI = i + k;
        int neighborJ = j + h;
        if (neighborI < 0 || neighborJ < 0 || neighborI >= board.length || neighborJ >= board[i].length) {
          continue;
        }
        if (board[neighborI][neighborJ] == 1) {
          numNeighbors++;
        }
        if (numNeighbors > 3) {
          return 0;
        }
      }
    }
    if (isCurrentlyAlive && numNeighbors == 2 || numNeighbors == 3) {
        return 1;
    }
    else {
      return 0;
    }
  }
}

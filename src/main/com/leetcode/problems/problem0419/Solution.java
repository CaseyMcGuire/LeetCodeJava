package main.com.leetcode.problems.problem0419;

public class Solution {
  public int countBattleships(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return 0;
    }
    boolean[][] visited = new boolean[board.length][board[0].length];
    int numBattleships = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (visited[i][j]) {
          continue;
        }
        visited[i][j] = true;
        if (board[i][j] == 'X') {
          numBattleships++;
          markBattleshipLocation(board, i, j, visited);
        }
      }
    }
    return numBattleships;
  }

  private void markBattleshipLocation(char[][] board, int i, int j, boolean[][] visited) {
    if (board[i][j] != 'X') {
      return;
    }
    Direction shipDirection = getBattleshipDirection(board, i, j);
    if (shipDirection == Direction.ONE_CELL) {
      return;
    }
    int curJ = j;
    int curI = i;
    while (curJ >= 0 && curI >= 0 && board[curI][curJ] == 'X') {
      visited[curI][curJ] = true;
      if (shipDirection == Direction.UP_DOWN) {
        curI--;
      }
      else {
        curJ--;
      }
    }

    curI = i;
    curJ = j;
    while (curJ < board[i].length && curI < board.length && board[curI][curJ] == 'X') {
      visited[curI][curJ] = true;
      if (shipDirection == Direction.UP_DOWN) {
        curI++;
      }
      else {
        curJ++;
      }
    }
  }

  private Direction getBattleshipDirection(char[][] board, int i, int j) {
    if ((i > 0 && board[i - 1][j] == 'X') || (i < board.length - 1 && board[i + 1][j] == 'X')) {
      return Direction.UP_DOWN;
    }
    else if ((j > 0 && board[i][j - 1] == 'X') || (j < board[i].length - 1 && board[i][j + 1] == 'X')) {
      return Direction.LEFT_RIGHT;
    }
    else {
      return Direction.ONE_CELL;
    }
  }

  enum Direction {
    UP_DOWN,
    LEFT_RIGHT,
    ONE_CELL
  }
}

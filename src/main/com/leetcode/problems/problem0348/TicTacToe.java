package main.com.leetcode.problems.problem0348;

public class TicTacToe {
  private final int[][] board;
  private final int boardSize;
  public TicTacToe(int n) {
    board = new int[n][n];
    boardSize = n;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {
    board[row][col] = player;
    if (boardSize == 1) {
      return player;
    }
    int rowWinner = checkRow(row);
    if (rowWinner != 0) {
      return rowWinner;
    }
    int columnWinner = checkColumn(col);
    if (columnWinner != 0) {
      return columnWinner;
    }
    int diagonalWinner = checkDiagonal();
    if (diagonalWinner != 0) {
      return diagonalWinner;
    }
    return 0;
  }

  public int checkRow(int row) {
    for (int i = 1; i < board[row].length; i++) {
      if (board[row][i] == 0 || board[row][i] != board[row][i - 1]) {
        return 0;
      }
    }
    return board[row][0];
  }

  private int checkColumn(int column) {
    for (int i = 1; i < board.length; i++) {
      if (board[i][column] == 0 || board[i][column] != board[i - 1][column]) {
        return 0;
      }
    }
    return board[0][column];
  }

  private int checkDiagonal() {

    boolean foundDiagonal = true;
    for (int i = 1, j = 1; i < board.length && j < board[i].length; i++, j++) {
      if (board[i][j] == 0 || board[i][j] != board[i - 1][j - 1]) {
        foundDiagonal = false;
      }
    }
    if (foundDiagonal) {
      return board[0][0];
    }

    for (int i = board.length - 1, j = 0; i > 0 && j < board[i].length - 1; i--, j++) {
      if (board[i][j] == 0 || board[i][j] != board[i - 1][j + 1]) {
        return 0;
      }
    }
    return board[board.length - 1][0];
  }
}

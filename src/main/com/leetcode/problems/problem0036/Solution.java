package main.com.leetcode.problems.problem0036;

import java.util.*;

public class Solution {
  public boolean isValidSudoku(char[][] board) {
    List<Set<Character>> rows = new ArrayList<>();
    List<Set<Character>> columns = new ArrayList<>();
    Map<Integer, Map<Integer, Set<Character>>> subBoxes = new HashMap<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        rows.add(new HashSet<>());
        columns.add(new HashSet<>());
        if (!subBoxes.containsKey(i)) {
          subBoxes.put(i, new HashMap<>());
        }
        Map<Integer, Set<Character>> subBox = subBoxes.get(i);
        if (!subBox.containsKey(j)) {
          subBox.put(j, new HashSet<>());
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        Set<Character> row = rows.get(i);
        Set<Character> column = columns.get(j);
        Set<Character> subBox = subBoxes.get(getSubBoxIndex(i)).get(getSubBoxIndex(j));
        if (!row.add(board[i][j]) || !column.add(board[i][j]) || !subBox.add(board[i][j])) {
          return false;
        }
      }
    }

    return true;
  }

  private int getSubBoxIndex(int index) {
    if (index < 3) {
      return 0;
    }
    else if (index < 6) {
      return 1;
    }
    else {
      return 2;
    }
  }
}

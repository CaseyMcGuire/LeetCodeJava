package main.com.leetcode.problems.problem0118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<List<Integer>> generate(int numRows) {
    if (numRows == 0) {
      return Collections.emptyList();
    }
    else if (numRows == 1) {
      return Collections.singletonList(Collections.singletonList(1));
    }
    List<List<Integer>> pascalRows = new ArrayList<>();
    pascalRows.add(Collections.singletonList(1));
    for (int i = 1; i < numRows; i++) {
      List<Integer> previousRow = pascalRows.get(i - 1);
      int currentRowSize = previousRow.size() + 1;
      List<Integer> currentRow = new ArrayList<>();
      for (int j = 0; j < currentRowSize; j++) {
        if (j == 0) {
          currentRow.add(previousRow.get(j));
        }
        else if (j == currentRowSize - 1) {
          currentRow.add(previousRow.get(j - 1));
        }
        else {
          currentRow.add(previousRow.get(j) + previousRow.get(j - 1));
        }
      }
      pascalRows.add(currentRow);
    }
    return pascalRows;
  }
}

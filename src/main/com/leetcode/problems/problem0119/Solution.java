package main.com.leetcode.problems.problem0119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<Integer> getRow(int rowIndex) {
    if (rowIndex == 0) {
      return Arrays.asList(1);
    }

    List<Integer> previousRow = Arrays.asList(1);
    for (int i = 1; i <= rowIndex; i++) {
      List<Integer> currentRow = new ArrayList<>();
      for (int j = 0; j < previousRow.size() + 1; j++) {
        if (j == 0) {
          currentRow.add(previousRow.get(0));
        }
        else if (j == previousRow.size()) {
          currentRow.add(previousRow.get(previousRow.size() - 1));
        }
        else {
          currentRow.add(previousRow.get(j) + previousRow.get(j - 1));
        }
      }
      previousRow = currentRow;
    }
    return previousRow;
  }
}

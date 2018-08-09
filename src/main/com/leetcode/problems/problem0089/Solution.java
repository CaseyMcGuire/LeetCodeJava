package main.com.leetcode.problems.problem0089;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<Integer> grayCode(int n) {
    if (n == 0) {
      return Collections.singletonList(0);
    }
    if (n == 1) {
      List<Integer> grayCode = new ArrayList<>();
      grayCode.add(0);
      grayCode.add(1);
      return grayCode;
    }
    List<Integer> subgrayCodes = grayCode(n - 1);
    int size = subgrayCodes.size() - 1;
    for (int i = size; i >= 0; i--) {
      subgrayCodes.add(subgrayCodes.get(i) | (1 << (n - 1)));
    }
    return subgrayCodes;
  }
}

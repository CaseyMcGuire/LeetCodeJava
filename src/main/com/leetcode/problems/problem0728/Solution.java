package main.com.leetcode.problems.problem0728;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public List<Integer> selfDividingNumbers(int left, int right) {
    return IntStream.rangeClosed(left, right)
                    .filter(this::isSelfDividing)
                    .boxed()
                    .collect(Collectors.toList());
  }

  private boolean isSelfDividing(int num) {
    if (num < 10 && num > 0) {
      return true;
    }
    for (char c : (num + "").toCharArray()) {
      if (c == '0') {
        return false;
      }
      if (num % Character.getNumericValue(c) != 0) {
        return false;
      }
    }
    return true;
  }
}

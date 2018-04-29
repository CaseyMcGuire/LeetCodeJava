package main.com.leetcode.problems.problem0412;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> fizzBuzz(int n) {
    List<String> nums = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      boolean divisibleByThree = i % 3 == 0;
      boolean divisibleByFive = i % 5 == 0;
      final String num;
      if (divisibleByFive && divisibleByThree) {
        num = "FizzBuzz";
      }
      else if (divisibleByThree) {
        num = "Fizz";
      }
      else if (divisibleByFive) {
        num = "Buzz";
      }
      else {
        num = i + "";
      }
      nums.add(num);
    }
    return nums;
  }
}

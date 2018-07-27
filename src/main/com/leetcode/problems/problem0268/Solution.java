package main.com.leetcode.problems.problem0268;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int missingNumber(int[] nums) {
    Set<Integer> remainingNums = new HashSet<>();
    for (int i = 0; i <= nums.length; i++) {
      remainingNums.add(i);
    }
    for (int num : nums) {
      remainingNums.remove(num);
    }
    return new ArrayList<>(remainingNums).get(0);
  }
}

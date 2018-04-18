package main.com.leetcode.problems.problem0448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    Set<Integer> unseenNumbers = new HashSet<>();
    for (int i = 1; i <= nums.length; i++) {
      unseenNumbers.add(i);
    }
    for (int num : nums) {
      unseenNumbers.remove(num);
    }
    return new ArrayList<>(unseenNumbers);
  }
}

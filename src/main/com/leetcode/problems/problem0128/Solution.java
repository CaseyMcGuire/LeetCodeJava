package main.com.leetcode.problems.problem0128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Set<Integer> uniqueNumbers = new HashSet<>();
    for (int num : nums) {
      uniqueNumbers.add(num);
    }
    int longestConsecutiveSequenceSoFar = 1;
    for (int num : new HashSet<>(uniqueNumbers)) {
      int currentLongestConsecutiveSequenceLength = getLongestConsecutiveSequenceLength(num, uniqueNumbers);
      if (currentLongestConsecutiveSequenceLength > longestConsecutiveSequenceSoFar) {
        longestConsecutiveSequenceSoFar = currentLongestConsecutiveSequenceLength;
      }
    }
    return longestConsecutiveSequenceSoFar;
  }

  private int getLongestConsecutiveSequenceLength(int num, Set<Integer> numbers) {
    if (!numbers.remove(num)) {
      return 0;
    }
    return 1 + getLongestConsecutiveSequenceLength(num - 1, numbers, Direction.NEGATIVE) + getLongestConsecutiveSequenceLength(num + 1, numbers, Direction.POSITIVE);
  }

  private int getLongestConsecutiveSequenceLength(int num, Set<Integer> numbers, Direction direction) {
    if (!numbers.remove(num)) {
      return 0;
    }
    if (direction == Direction.POSITIVE) {
      return 1 + getLongestConsecutiveSequenceLength(num + 1, numbers, direction);
    }
    else {
      return 1 + getLongestConsecutiveSequenceLength(num - 1, numbers, direction);
    }
  }

  private enum Direction {
    NEGATIVE,
    POSITIVE
  }
}

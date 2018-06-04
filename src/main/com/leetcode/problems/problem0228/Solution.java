package main.com.leetcode.problems.problem0228;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  public List<String> summaryRanges(int[] nums) {
    if (nums.length == 0) {
      return Collections.emptyList();
    }
    List<Range> ranges = new ArrayList<>();
    Range currentRange = null;
    for (int num : nums) {
      if (currentRange == null) {
        currentRange = new Range(num);
      }
      else if (currentRange.canExtendRange(num)) {
        currentRange.extendRange(num);
      }
      else { //!currentRange.canExtendRange(num)
        ranges.add(currentRange);
        currentRange = new Range(num);
      }
    }
    ranges.add(currentRange);
    return ranges.stream().map(Range::toString).collect(Collectors.toList());
  }

  private static class Range {
    int start;
    Integer end;
    Range(int start) {
      this.start = start;
      this.end = null;
    }

    boolean canExtendRange(int num) {
      return (getEndRange() + 1) == num;
    }

    private int getEndRange() {
      if (end == null) {
        return start;
      }
      return end;
    }

    void extendRange(int num) {
      if (!canExtendRange(num)) {
        throw new IllegalArgumentException("Argument is out of range. end: " + getEndRange() + " num: " + num);
      }
      this.end = num;
    }

    public String toString() {
      if (end == null) {
        return start + "";
      }
      return start + "->" + end;
    }
  }
}

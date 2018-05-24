package main.com.leetcode.problems.problem0252;

import main.com.leetcode.datastructures.Interval;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public boolean canAttendMeetings(Interval[] intervals) {
    List<Interval> intervalList = Arrays.asList(intervals);
    Collections.sort(intervalList, Comparator.comparingInt(o -> o.start));
    for (int i = 1; i < intervalList.size(); i++) {
      if (overlaps(intervalList.get(i - 1), intervalList.get(i))) {
        return false;
      }
    }
    return true;
  }

  private boolean overlaps(Interval first, Interval second) {
    return first.end > second.start;
  }
}

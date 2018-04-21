package main.com.leetcode.problems.problem0056;

import main.com.leetcode.datastructures.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public List<Interval> merge(List<Interval> intervals) {
    Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
    List<Interval> mergedIntervals = new ArrayList<>();
    for (Interval interval : intervals) {
      if (mergedIntervals.isEmpty()) {
        mergedIntervals.add(interval);
      }
      else {
        Interval lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
        if (interval.start > lastInterval.end) {
          mergedIntervals.add(interval);
        }
        else if (interval.end > lastInterval.end) {
          lastInterval.end = interval.end;
        }
      }
    }
    return mergedIntervals;
  }
}

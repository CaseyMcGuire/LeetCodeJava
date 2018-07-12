package main.com.leetcode.problems.problem0057;

import main.com.leetcode.datastructures.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    int startPosition = getStartPosition(intervals, newInterval);

    List<Interval> newIntervals = new ArrayList<>();
    for (int i = 0; i < startPosition; i++) {
      newIntervals.add(intervals.get(i));
    }

    int i = startPosition;
    Interval mergedInterval = newInterval;
    for (; i < intervals.size(); i++) {
      Interval mergeAttempt = mergeOverlappingIntervals(mergedInterval, intervals.get(i));
      if (mergeAttempt != null) {
        mergedInterval = mergeAttempt;
      }
      else {
        break;
      }
    }
    newIntervals.add(mergedInterval);
    for (; i < intervals.size(); i++) {
      newIntervals.add(intervals.get(i));
    }
    return newIntervals;
  }

  private Interval mergeOverlappingIntervals(Interval first, Interval second) {
    if (first.end < second.start || second.end < first.start) {
      return null;
    }
    int smallerStart = first.start < second.start ? first.start : second.start;
    int largerEnd = first.end > second.end ? first.end : second.end;
    return new Interval(smallerStart, largerEnd);
  }

  private int getStartPosition(List<Interval> intervals, Interval newInterval) {
    for (int i = 0; i < intervals.size(); i++) {
      if (newInterval.start < intervals.get(i).start || isContainedIn(intervals.get(i), newInterval.start)) {
        return i;
      }
    }
    return intervals.size();
  }


  private boolean isContainedIn(Interval interval, int num) {
    return num >= interval.start && num <= interval.end;
  }
}

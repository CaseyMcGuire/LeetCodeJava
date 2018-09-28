package main.com.leetcode.problems.problem0253;

import main.com.leetcode.datastructures.Interval;

import java.util.*;

class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    if (intervals.length == 1) {
      return 1;
    }
    PriorityQueue<Interval> pq = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
    for (Interval interval : intervals) {
      pq.add(interval);
    }
    TreeMap<Integer, Integer> endTimeToFrequency = new TreeMap<>();
    int numCurrentlyNeeded = 0;
    int maxSoFar = 0;
    while (!pq.isEmpty()) {
      Interval currentInterval = pq.poll();
      List<Interval> intervalsStartingAtCurrentTime = new ArrayList<>();
      intervalsStartingAtCurrentTime.add(currentInterval);
      while (!pq.isEmpty() && pq.peek().start == currentInterval.start) {
        intervalsStartingAtCurrentTime.add(pq.poll());
      }

      numCurrentlyNeeded += intervalsStartingAtCurrentTime.size();

      for (Interval interval : intervalsStartingAtCurrentTime) {
        endTimeToFrequency.merge(interval.end, 1, (cur, iter) -> cur + iter);
      }

      for (Map.Entry<Integer, Integer> entry : new HashSet<>(endTimeToFrequency.headMap(currentInterval.start, true).entrySet())) {
        int frequency = entry.getValue();
        int endTime = entry.getKey();
        numCurrentlyNeeded -= frequency;
        endTimeToFrequency.remove(endTime);
      }

      if (numCurrentlyNeeded > maxSoFar) {
        maxSoFar = numCurrentlyNeeded;
      }
    }
    return maxSoFar;
  }
}

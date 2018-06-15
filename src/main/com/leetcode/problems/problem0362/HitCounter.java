package main.com.leetcode.problems.problem0362;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class HitCounter {

  private static final int FIVE_MINUTES_IN_SECOND = 5 * 60;
  private final TreeSet<Integer> hitTimes;
  private final TreeMap<Integer, Integer> hitTimesToCompoundedDuplicateHits;

  public HitCounter() {
    hitTimes = new TreeSet<>();
    hitTimesToCompoundedDuplicateHits = new TreeMap<>();
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    boolean alreadySeen = !hitTimes.add(timestamp);
    if (alreadySeen) {
      Map.Entry<Integer, Integer> lastEntry = hitTimesToCompoundedDuplicateHits.lastEntry();
      if (lastEntry == null) {
        hitTimesToCompoundedDuplicateHits.put(timestamp, 1);
      }
      else {
        int compoundHits = lastEntry.getValue();
        hitTimesToCompoundedDuplicateHits.merge(timestamp, compoundHits + 1, (cur, iter) -> cur + 1);
      }
    }
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    int fiveMinutesAgoInSeconds = timestamp - FIVE_MINUTES_IN_SECOND;
    int hitsSinceFiveMinutesAgo = hitTimes.tailSet(fiveMinutesAgoInSeconds, false).size();
    int totalCompoundHits = getTotalCompoundHitsFromTime(timestamp);
    return hitsSinceFiveMinutesAgo + totalCompoundHits;
  }

  private int getTotalCompoundHitsFromTime(int timestamp) {
    if (hitTimesToCompoundedDuplicateHits.isEmpty()) {
      return 0;
    }
    int totalCompoundHits = hitTimesToCompoundedDuplicateHits.lastEntry().getValue();
    Map.Entry<Integer, Integer> lastEntryFromFiveMinutesAgo = hitTimesToCompoundedDuplicateHits.floorEntry(timestamp - FIVE_MINUTES_IN_SECOND);
    if (lastEntryFromFiveMinutesAgo == null) {
      return totalCompoundHits;
    }
    else {
      return totalCompoundHits - lastEntryFromFiveMinutesAgo.getValue();
    }
  }
}

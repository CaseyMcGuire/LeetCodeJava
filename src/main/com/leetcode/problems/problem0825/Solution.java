package main.com.leetcode.problems.problem0825;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Solution {
  public int numFriendRequests(int[] ages) {
    TreeMap<Integer, Integer> ageToFrequency = new TreeMap<>();
    for (int age : ages) {
      ageToFrequency.merge(age, 1, (cur, iter) -> cur + iter);
    }
    int totalFriendRequests = 0;
    for (int age : ages) {
      int friendRequests = getFriendRequestsForAge(age, ageToFrequency);
      totalFriendRequests += friendRequests;
    }
    return totalFriendRequests;
  }

  private int getFriendRequestsForAge(int age, TreeMap<Integer, Integer> ageToFrequency) {
    int halfAgePlusSeven = (int) ((0.5 * (double) age) + 7.0);
    NavigableMap<Integer, Integer> lessThanHalfAgePlusSeven = ageToFrequency.headMap(halfAgePlusSeven, true);
    NavigableMap<Integer, Integer> greaterThan = ageToFrequency.tailMap(age, false);
    NavigableMap<Integer, Integer> greaterThan100;
    if (age < 100) {
      greaterThan100 = ageToFrequency.tailMap(100, true);
    }
    else {
      greaterThan100 = new TreeMap<>();
    }
    int friendRequests = 0;
    for (Map.Entry<Integer, Integer> entry : ageToFrequency.entrySet()) {
      int otherAge = entry.getKey();
      if (lessThanHalfAgePlusSeven.containsKey(otherAge) ||
          greaterThan.containsKey(otherAge) ||
          greaterThan100.containsKey(otherAge)) {
        continue;
      }
      int frequency = entry.getValue();
      if (age == otherAge) {
        frequency--;
      }
      if (frequency > 0) {
        friendRequests += frequency;
      }
    }
    return friendRequests;
  }
}

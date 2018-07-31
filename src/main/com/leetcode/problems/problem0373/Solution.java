package main.com.leetcode.problems.problem0373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    for (int i = 0; i < k && i < nums1.length; i++) {
      for (int j = 0; j < k && j < nums2.length; j++) {
        pq.add(new Pair(nums1[i], nums2[j]));
      }
    }
    List<int[]> smallestPairs = new ArrayList<>();
    while (smallestPairs.size() < k && !pq.isEmpty()) {
      smallestPairs.add(pq.poll().toArray());
    }
    return smallestPairs;
  }

  private static class Pair implements Comparable<Pair> {
    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    int getSum() {
      return first + second;
    }

    @Override
    public int compareTo(Pair o) {
      return getSum() - o.getSum();
    }

    int[] toArray() {
      return new int[]{first, second};
    }
  }
}

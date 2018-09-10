package main.com.leetcode.problems.Problem0767;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public String reorganizeString(String S) {
    PriorityQueue<CharToFrequency> characterPriority = getCharPriority(S);
    StringBuilder builder = new StringBuilder();
    CharToFrequency previous = null;
    while (!characterPriority.isEmpty()) {
      CharToFrequency cur = characterPriority.poll();
      builder.append(cur.character);
      cur.frequency--;

      if (previous != null) {
        characterPriority.add(previous);
      }

      if (cur.frequency > 0) {
        previous = cur;
      }
      else {
        previous = null;
      }
    }

    if (previous != null) {
      return "";
    }

    return builder.toString();
  }

  private PriorityQueue<CharToFrequency> getCharPriority(String s) {
    Map<Character, Integer> characterToFrequency = new HashMap<>();
    for (char c : s.toCharArray()) {
      characterToFrequency.merge(c, 1, (cur, iter) -> cur + iter);
    }

    PriorityQueue<CharToFrequency> pq = new PriorityQueue<>();
    for (Map.Entry<Character, Integer> entry : characterToFrequency.entrySet()) {
      pq.add(new CharToFrequency(entry.getKey(), entry.getValue()));
    }
    return pq;
  }

  private static class CharToFrequency implements Comparable<CharToFrequency> {
    private final char character;
    private int frequency;

    CharToFrequency(char c, int frequency) {
      this.character = c;
      this.frequency = frequency;
    }

    @Override
    public int compareTo(CharToFrequency o) {
      return o.frequency - frequency;
    }
  }
}

package main.com.leetcode.problems.problem0692;

import java.util.*;

public class Solution {

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> wordsToFrequency = new HashMap<>();
    for (String word : words) {
      Integer frequency = wordsToFrequency.getOrDefault(word, 0);
      wordsToFrequency.put(word, frequency + 1);
    }

    PriorityQueue<WordFrequency> orderedWordFrequencies = new PriorityQueue<>((o1, o2) -> {
      if (o1.frequency != o2.frequency) {
        return o2.frequency - o1.frequency;
      }
      return o1.word.compareTo(o2.word);
    });

    for (Map.Entry<String, Integer> entry : wordsToFrequency.entrySet()) {
      orderedWordFrequencies.add(new WordFrequency(entry.getKey(), entry.getValue()));
    }

    List<String> kMostFrequentWords = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      kMostFrequentWords.add(orderedWordFrequencies.poll().word);
    }
    return kMostFrequentWords;
  }

  class WordFrequency {
    String word;
    int frequency;

    public WordFrequency(String word, int frequency) {
      this.word = word;
      this.frequency = frequency;
    }
  }
}



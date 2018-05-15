package main.com.leetcode.problems.problem0819;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
    Map<String, Integer> wordToFrequency = getWordFrequency(paragraph);
    Set<String> bannedWords = new HashSet<>();
    for (String bannedWord : banned) {
      bannedWords.add(bannedWord);
    }
    Map.Entry<String, Integer> mostFrequentNonBannedWord = null;
    for (Map.Entry<String, Integer> entry : wordToFrequency.entrySet()) {
      if (bannedWords.contains(entry.getKey())) {
        continue;
      }
      if (mostFrequentNonBannedWord == null || mostFrequentNonBannedWord.getValue() < entry.getValue()) {
        mostFrequentNonBannedWord = entry;
      }
    }
    return mostFrequentNonBannedWord.getKey();
  }

  private Map<String, Integer> getWordFrequency(String paragraph) {
    Map<String, Integer> wordToFrequency = new HashMap<>();

    StringBuilder curWord = new StringBuilder();
    for (char c : paragraph.toCharArray()) {
      if (!Character.isAlphabetic(c)) {
        if (curWord.length() > 0) {
          wordToFrequency.merge(curWord.toString(), 1, (cur, iter) -> cur + iter);
          curWord = new StringBuilder();
        }
      }
      else {
        curWord.append(Character.toLowerCase(c));
      }
    }
    if (curWord.length() > 0) {
      wordToFrequency.merge(curWord.toString(), 1, (cur, iter) -> cur + iter);
    }
    return wordToFrequency;
  }

}

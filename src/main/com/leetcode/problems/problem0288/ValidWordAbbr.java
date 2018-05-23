package main.com.leetcode.problems.problem0288;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {

  private final Map<String, Set<String>> abbreviationToWords;

  public ValidWordAbbr(String[] dictionary) {
    abbreviationToWords = new HashMap<>();
    for (String word : dictionary) {
      String abbreviation = getAbbreviation(word);
      Set<String> wordsWithAbbreviation = abbreviationToWords.getOrDefault(abbreviation, new HashSet<>());
      wordsWithAbbreviation.add(word);
      abbreviationToWords.put(abbreviation, wordsWithAbbreviation);
    }
  }

  public boolean isUnique(String word) {
    String abbreviation = getAbbreviation(word);
    Set<String> wordsWithAbbreviation = abbreviationToWords.get(abbreviation);
    if (wordsWithAbbreviation == null) {
      return true;
    }
    return wordsWithAbbreviation.size() == 1 && wordsWithAbbreviation.contains(word) || wordsWithAbbreviation.isEmpty();
  }

  private String getAbbreviation(String word) {
    if (word.length() <= 2) {
      return word;
    }
    return String.valueOf(word.charAt(0)) + (word.length() - 2) + word.charAt(word.length() - 1);
  }
}

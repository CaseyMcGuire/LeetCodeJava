package main.com.leetcode.problems.problem0249;

import java.util.*;

public class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    Map<Sequence, List<String>> sequenceToStrings = new HashMap<>();
    for (String word : strings) {
      Sequence sequence = convertToSequence(word);
      List<String> wordsOfSequence = sequenceToStrings.getOrDefault(sequence, new ArrayList<>());
      wordsOfSequence.add(word);
      sequenceToStrings.put(sequence, wordsOfSequence);
    }
    List<List<String>> shiftedWords = new ArrayList<>();
    for (Map.Entry<Sequence, List<String>> entry : sequenceToStrings.entrySet()) {
      shiftedWords.add(entry.getValue());
    }
    return shiftedWords;
  }

  private Sequence convertToSequence(String word) {
    if (word.length() == 1) {
      return new Sequence(Collections.emptyList());
    }
    List<Integer> differences = new ArrayList<>();
    for (int i = 1; i < word.length(); i++) {
      differences.add(getDifference(word.charAt(i - 1), word.charAt(i)));
    }
    return new Sequence(differences);
  }

  private int getDifference(char first, char second) {
    int firstNum = first - 97;
    int secondNum = second - 97;
    if (secondNum >= firstNum) {
      return secondNum - firstNum;
    }
    int distanceToZ = ('z' - 97) - firstNum;
    return secondNum + distanceToZ + 1;
  }

  private static class Sequence {
    List<Integer> differences;
    Sequence(List<Integer> differences) {
      this.differences = differences;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Sequence sequence = (Sequence) o;
      return Objects.equals(differences, sequence.differences);
    }

    @Override
    public int hashCode() {

      return Objects.hash(differences);
    }
  }
}

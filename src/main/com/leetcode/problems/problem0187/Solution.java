package main.com.leetcode.problems.problem0187;

import java.util.*;

public class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    if (s == null || s.length() <= 10) {
      return Collections.emptyList();
    }
    LinkedList<Character> currentDnaSequence = new LinkedList<>();
    Set<List<Character>> dnaSequences = new HashSet<>();
    Set<List<Character>> repeatedSequences = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      currentDnaSequence.add(s.charAt(i));
    }
    dnaSequences.add(new ArrayList<>(currentDnaSequence));
    for (int i = 10; i < s.length(); i++) {
      currentDnaSequence.remove(0);
      currentDnaSequence.add(s.charAt(i));
      List<Character> curDnaSequenceCopy = new ArrayList<>(currentDnaSequence);
      if (!dnaSequences.add(curDnaSequenceCopy)) {
        repeatedSequences.add(curDnaSequenceCopy);
      }
    }
    List<String> repeatedSequenceList = new ArrayList<>();
    for (List<Character> curSequence : repeatedSequences) {
      repeatedSequenceList.add(charListToString(curSequence));
    }
    return repeatedSequenceList;
  }

  private String charListToString(List<Character> characters) {
    StringBuilder builder = new StringBuilder();
    for (Character c : characters) {
      builder.append(c);
    }
    return builder.toString();
  }
}

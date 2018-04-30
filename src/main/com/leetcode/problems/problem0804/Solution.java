package main.com.leetcode.problems.problem0804;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int uniqueMorseRepresentations(String[] words) {
    Set<String> morseRepresentations = new HashSet<>();
    for (String word : words) {
      morseRepresentations.add(getStringRepresentation(word));
    }
    return morseRepresentations.size();
  }

  private String getStringRepresentation(String word) {
    StringBuilder morseRepresentation = new StringBuilder();
    for (char c : word.toCharArray()) {
      morseRepresentation.append(getMorseRepresentation(c));
    }
    return morseRepresentation.toString();
  }

  private String getMorseRepresentation(char c) {
    String[] morseRepresentations = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    int index = c - 'a';
    return morseRepresentations[index];
  }
}

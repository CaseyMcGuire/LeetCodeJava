package main.com.leetcode.problems.problem0017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<String> letterCombinations(String digits) {
    List<List<Character>> lettersForEachDigit = new ArrayList<>();
    for (char digit : digits.toCharArray()) {
      lettersForEachDigit.add(getLettersForDigit(digit));
    }
    List<String> letterCombination = new ArrayList<>();
    getLetterCombinations(lettersForEachDigit, letterCombination, new ArrayList<>());
    return letterCombination;
  }

  private void getLetterCombinations(List<List<Character>> lettersForEachDigit, List<String> letterCombination, List<Character> curCombination) {
    if (lettersForEachDigit.isEmpty()) {
      if (!curCombination.isEmpty()) {
        letterCombination.add(convertToString(curCombination));
      }
      return;
    }
    List<Character> lettersForDigit = lettersForEachDigit.get(0);
    for (Character c : lettersForDigit) {
      curCombination.add(c);
      List<List<Character>> remainingLettersForEachDigit = lettersForEachDigit.subList(1, lettersForEachDigit.size());
      getLetterCombinations(remainingLettersForEachDigit, letterCombination, curCombination);
      curCombination.remove(curCombination.size() - 1);
    }
  }

  private String convertToString(List<Character> letters) {
    StringBuilder builder = new StringBuilder();
    for (Character character : letters) {
      builder.append(character);
    }
    return builder.toString();
  }

  private List<Character> getLettersForDigit(char digit) {
    switch (digit) {
      case '0':
      case '1':
        return Collections.emptyList();
      case '2':
        return Arrays.asList('a', 'b', 'c');
      case '3':
        return Arrays.asList('d', 'e', 'f');
      case '4':
        return Arrays.asList('g', 'h', 'i');
      case '5':
        return Arrays.asList('j', 'k', 'l');
      case '6':
        return Arrays.asList('m', 'n', 'o');
      case '7':
        return Arrays.asList('p', 'q', 'r', 's');
      case '8':
        return Arrays.asList('t', 'u', 'v');
      case '9':
        return Arrays.asList('w', 'x', 'y', 'z');
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().letterCombinations("23"));
  }
}

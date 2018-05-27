package main.com.leetcode.problems.problem0267;

import java.util.*;

public class Solution {
  public List<String> generatePalindromes(String s) {
    Map<Character, Integer> charToFrequency = getFrequencyMap(s);
    List<Character> oddCharacters = findOddCharacters(charToFrequency);
    if (oddCharacters.size() > 1) {
      return Collections.emptyList();
    }
    Deque<Character> currentPalindrome = new LinkedList<>();
    if (oddCharacters.size() == 1) {
      Character oddCharacter = oddCharacters.get(0);
      currentPalindrome.addFirst(oddCharacter);
      int numOccurrences = charToFrequency.get(oddCharacter);
      if (numOccurrences > 1) {
        charToFrequency.put(oddCharacter, numOccurrences - 1);
      }
      else {
        charToFrequency.remove(oddCharacter);
      }
    }

    Set<String> uniquePalindromes = new HashSet<>();
    findPalindromes(charToFrequency, currentPalindrome, uniquePalindromes, s.length());
    return new ArrayList<>(uniquePalindromes);
  }

  private void findPalindromes(Map<Character, Integer> charToFrequency, Deque<Character> currentPalindrome, Set<String> uniquePalindromes, int length) {
    if (currentPalindrome.size() == length) {
      uniquePalindromes.add(convertDequeToString(currentPalindrome));
    }
    for (Map.Entry<Character, Integer> entry : charToFrequency.entrySet()) {
      Character character = entry.getKey();
      int numOccurrences = entry.getValue();
      if (numOccurrences == 0) {
        continue;
      }
      currentPalindrome.addFirst(character);
      currentPalindrome.addLast(character);
      entry.setValue(numOccurrences - 2);
      findPalindromes(charToFrequency, currentPalindrome, uniquePalindromes, length);
      currentPalindrome.removeFirst();
      currentPalindrome.removeLast();
      entry.setValue(numOccurrences);
    }
  }

  private String convertDequeToString(Deque<Character> deque) {
    StringBuilder builder = new StringBuilder();
    for (Character c : deque) {
      builder.append(c);
    }
    return builder.toString();
  }

  private List<Character> findOddCharacters(Map<Character, Integer> charToFrequency) {
    List<Character> oddCharacters = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : charToFrequency.entrySet()) {
      int numOccurrences = entry.getValue();
      if (numOccurrences % 2 == 1) {
        oddCharacters.add(entry.getKey());
      }
    }
    return oddCharacters;
  }

  private Map<Character, Integer> getFrequencyMap(String s) {
    Map<Character, Integer> charToFrequency = new HashMap<>();
    for (char c : s.toCharArray()) {
      charToFrequency.merge(c, 1, (current, iterate) -> current + iterate);
    }
    return charToFrequency;
  }
}

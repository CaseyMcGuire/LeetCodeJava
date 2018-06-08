package main.com.leetcode.problems.problem0318;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public int maxProduct(String[] words) {
    List<Word> wordList = new ArrayList<>();
    for (String word : words) {
      wordList.add(new Word(word));
    }
    int maxSoFar = 0;
    for (int i = 0; i < wordList.size() - 1; i++) {
      Word currentWord = wordList.get(i);
      for (int j = i + 1; j < wordList.size(); j++) {
        Word otherWord = wordList.get(j);
        if (!currentWord.sharesCharacters(otherWord)) {
          int product = currentWord.length * otherWord.length;
          if (product > maxSoFar) {
            maxSoFar = product;
          }
        }
      }
    }
    return maxSoFar;
  }

  private static class Word {
    int length;
    Set<Character> characters;

    Word(String word) {
      this.length = word.length();
      characters = new HashSet<>();
      for (char c : word.toCharArray()) {
        characters.add(c);
      }
    }

    public boolean sharesCharacters(Word other) {
      for (char character : characters) {
        if (other.characters.contains(character)) {
          return true;
        }
      }
      return false;
    }
  }
}

package main.com.leetcode.problems.problem0127;

import java.util.*;

public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> words = new HashSet<>(wordList);
    words.add(beginWord);
    if (!words.contains(endWord) || beginWord.equals(endWord) || wordList.isEmpty()) {
      return 0;
    }
    Map<String, Set<String>> transformationsForEachWord = getTransformationsForEachWord(words, wordList.get(0).length());
    Set<String> visitedWords = new HashSet<>();
    Deque<String> wordQueue = new LinkedList<>();
    Map<String, Integer> wordToPathLength = new HashMap<>();
    wordToPathLength.put(beginWord, 1);
    wordQueue.addLast(beginWord);
    while (!wordQueue.isEmpty()) {
      String currentWord = wordQueue.removeFirst();
      Integer currentLength = wordToPathLength.get(currentWord);
      Set<String> transformations = transformationsForEachWord.get(currentWord);
      if (transformations.contains(endWord)) {
        return currentLength + 1;
      }
      for (String transformation : transformations) {
        if (!visitedWords.contains(transformation)) {
          wordQueue.addLast(transformation);
          visitedWords.add(transformation);
          wordToPathLength.put(transformation, currentLength + 1);
        }
      }

    }

    return 0;
  }

  private Map<String, Set<String>> getTransformationsForEachWord(Set<String> words, int length) {
    Map<String, Set<String>> transformationsForEachWord = new HashMap<>();
    List<Set<Character>> characterForEachIndex = getCharactersForEachIndex(words, length);
    for (String word : words) {
      StringBuilder wordBuilder = new StringBuilder(word);
      for (int i = 0; i < word.length(); i++) {
        Set<Character> possibleCharacters = characterForEachIndex.get(i);
        for (Character possibleCharacter : possibleCharacters) {
          wordBuilder.setCharAt(i, possibleCharacter);
          String possibleWord = wordBuilder.toString();
          if (words.contains(possibleWord)) {
            Set<String> transformations = transformationsForEachWord.getOrDefault(word, new HashSet<>());
            transformations.add(possibleWord);
            transformationsForEachWord.put(word, transformations);
          }
          wordBuilder.setCharAt(i, word.charAt(i));
        }
      }
    }
    return transformationsForEachWord;
  }

  private List<Set<Character>> getCharactersForEachIndex(Set<String> wordList, int length) {
    List<Set<Character>> charactersForEachIndex = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      Set<Character> currentCharacters = new HashSet<>();
      for (String word : wordList) {
        currentCharacters.add(word.charAt(i));
      }
      charactersForEachIndex.add(currentCharacters);
    }
    return charactersForEachIndex;
  }
}

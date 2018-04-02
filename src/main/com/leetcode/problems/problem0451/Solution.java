package main.com.leetcode.problems.problem0451;


import java.util.*;

public class Solution {
  public String frequencySort(String s) {
    Map<Character, Integer> characterToFrequency = getCharacterToFrequencyMap(s);
    TreeMap<Integer, List<Character>> frequencyToCharacters = getFrequencyToCharacterMap(characterToFrequency);
    StringBuilder builder = new StringBuilder();
    for (Map.Entry<Integer, List<Character>> frequencyToCharacter : frequencyToCharacters.descendingMap().entrySet()) {
      for (Character c : frequencyToCharacter.getValue()) {
        for (int i = 0; i < frequencyToCharacter.getKey(); i++) {
          builder.append(c);
        }
      }
    }
    return builder.toString();
  }



  private TreeMap<Integer, List<Character>> getFrequencyToCharacterMap(Map<Character, Integer> charactersToFrequency) {
    TreeMap<Integer, List<Character>> frequencyToCharacters = new TreeMap<>();
    for (Map.Entry<Character, Integer> characterToFrequency : charactersToFrequency.entrySet()) {
      Character character = characterToFrequency.getKey();
      Integer frequency = characterToFrequency.getValue();
      List<Character> charactersWithSameFrequency = frequencyToCharacters.getOrDefault(frequency, new ArrayList<>());
      charactersWithSameFrequency.add(character);
      frequencyToCharacters.put(frequency, charactersWithSameFrequency);
    }
    return frequencyToCharacters;
  }

  private Map<Character, Integer> getCharacterToFrequencyMap(String s) {
    Map<Character, Integer> characterToFrequency = new HashMap<>();
    for (char c : s.toCharArray()) {
      characterToFrequency.merge(c, 1, (iter, current) -> iter + current);
    }
    return characterToFrequency;
  }
}

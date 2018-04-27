package main.com.leetcode.problems.problem0438;

import java.util.*;

public class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    if (p.length() > s.length()) {
      return Collections.emptyList();
    }
    Anagram anagram = new Anagram(p);
    Anagram curAnagram = new Anagram(s.substring(0, p.length()));
    List<Integer> startingAnagramIndices = new ArrayList<>();

    if (anagram.equals(curAnagram)) {
      startingAnagramIndices.add(0);
    }
    for (int i = 0, j = p.length(); j < s.length(); i++, j++) {
      curAnagram.swap(s.charAt(j), s.charAt(i));
      if (anagram.equals(curAnagram)) {
        startingAnagramIndices.add(i + 1);
      }
    }
    return startingAnagramIndices;
  }

  private static class Anagram {
    private final Map<Character, Integer> charToNumOccurrences;

    public Anagram(String word) {
      charToNumOccurrences = new HashMap<>();
      for (char c : word.toCharArray()) {
        charToNumOccurrences.merge(c, 1, (cur, next) -> cur + next);
      }
    }

    public void swap(char add, char remove) {
      charToNumOccurrences.merge(add, 1, (cur, next) -> cur + next);
      int numOccurrences = charToNumOccurrences.get(remove);
      if (numOccurrences == 1) {
        charToNumOccurrences.remove(remove);
      }
      else {
        charToNumOccurrences.put(remove, numOccurrences - 1);
      }
    }


    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Anagram anagram = (Anagram) o;
      return Objects.equals(charToNumOccurrences, anagram.charToNumOccurrences);
    }

    @Override
    public int hashCode() {
      return Objects.hash(charToNumOccurrences);
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
  }
}

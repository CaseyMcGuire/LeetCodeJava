package main.com.leetcode.problems.problem0299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public String getHint(String secret, String guess) {
    Map<Character, Integer> charToFrequency = new HashMap<>();
    int numCows = 0;
    int numBulls = 0;
    List<Character> guessWithMatchesRemoved = new ArrayList<>();
    for (int i = 0; i < guess.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        numBulls++;
      }
      else {
        guessWithMatchesRemoved.add(guess.charAt(i));
        charToFrequency.merge(secret.charAt(i), 1, (cur, iter) -> cur + iter);
      }
    }
    for (char c : guessWithMatchesRemoved) {
      Integer numOfChar = charToFrequency.get(c);
      if (numOfChar != null) {
        numCows++;
        if (numOfChar != 1) {
          charToFrequency.put(c, numOfChar - 1);
        }
        else {
          charToFrequency.remove(c);
        }
      }
    }
    return "" + numBulls + 'A' + numCows + 'B';
  }
}

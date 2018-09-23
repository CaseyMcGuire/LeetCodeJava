package main.com.leetcode.problems.problem0072;

public class Solution {
  public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) {
      return 0;
    }
    return minDistance(word1, 0, word2, 0, new Integer[word1.length()][word2.length()]);
  }

  private int minDistance(String word1, int i, String word2, int j, Integer[][] minCost) {
    if (i == word1.length()) {
      return word2.length() - j;
    }
    else if (j == word2.length()) {
      return word1.length() - i;
    }

    if (minCost[i][j] != null) {
      return minCost[i][j];
    }

    int match = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
    int replaceCost = minDistance(word1, i + 1, word2, j + 1, minCost) + match;
    int deleteCost = minDistance(word1, i + 1, word2, j, minCost) + 1;
    int insertCost = minDistance(word1, i, word2, j + 1, minCost) + 1;
    minCost[i][j] = Math.min(replaceCost, Math.min(deleteCost, insertCost));
    return minCost[i][j];
  }
}

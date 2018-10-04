package main.com.leetcode.problems.problem0044;

public class Solution {
  public boolean isMatch(String s, String p) {
    return isMatch(s, 0, p, 0, new Boolean[s.length() + 1][p.length() + 1]);
  }

  private boolean isMatch(String s, int i, String p, int j, Boolean[][] visited) {
    if (visited[i][j] != null) {
      return visited[i][j];
    }
    boolean isMatch = true;
    if (s.length() == i) {
      for (; j < p.length(); j++) {
        if (p.charAt(j) != '*') {
          isMatch = false;
          break;
        }
      }
    }
    else if (j == p.length()) {
      isMatch = false;
    }
    else if (p.charAt(j) == '?') {
      isMatch = isMatch(s, i + 1, p, j + 1, visited);
    }
    else if (p.charAt(j) == '*') {
      isMatch = isMatch(s, i + 1, p, j, visited) ||
                isMatch(s, i, p, j + 1, visited);
    }
    else if (p.charAt(j) != s.charAt(i)) {
      isMatch =  false;
    }
    else {
      isMatch = isMatch(s, i + 1, p, j + 1, visited);
    }
    visited[i][j] = isMatch;
    return visited[i][j];
  }
}

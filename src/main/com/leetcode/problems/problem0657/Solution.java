package main.com.leetcode.problems.problem0657;

public class Solution {
  public boolean judgeCircle(String moves) {
    int xCoordinate = 0;
    int yCoordinate = 0;
    for (char c : moves.toCharArray()) {
      switch (c) {
        case 'U':
          xCoordinate--;
          break;
        case 'D':
          xCoordinate++;
          break;
        case 'L':
          yCoordinate--;
          break;
        case 'R':
          yCoordinate++;
          break;
      }
    }
    return xCoordinate == 0 && yCoordinate == 0;
  }
}

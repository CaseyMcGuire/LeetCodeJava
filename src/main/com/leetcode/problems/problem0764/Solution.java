package main.com.leetcode.problems.problem0764;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
  public int orderOfLargestPlusSign(int N, int[][] mines) {
    Set<Point> mineSet = new HashSet<>();
    for (int[] mine : mines) {
      mineSet.add(new Point(mine[0], mine[1]));
    }
    int largestPlusSignSoFar = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (mineSet.contains(new Point(i, j))) {
          continue;
        }
        int longestPossiblePlusSign = getLargestPossiblePlusSign(i, j, N);
        if (longestPossiblePlusSign <= largestPlusSignSoFar) {
          continue;
        }
        int plusSizeSignSize = getLargestPlusSign(i, j, N, mineSet);
        if (plusSizeSignSize > largestPlusSignSoFar) {
          largestPlusSignSoFar = plusSizeSignSize;
        }
      }
    }
    return largestPlusSignSoFar;
  }

  private int getLargestPlusSign(int i, int j, int N, Set<Point> mines) {
    int largestPossiblePlusSign = getLargestPossiblePlusSign(i, j, N);
    for (int size = 0; size < largestPossiblePlusSign; size++) {
      if (mines.contains(new Point(i + size, j)) ||
          mines.contains(new Point(i - size, j)) ||
          mines.contains(new Point(i, j + size)) ||
          mines.contains(new Point(i, j - size))) {
        return size;
      }
    }
    return largestPossiblePlusSign;
  }

  private int getLargestPossiblePlusSign(int i, int j, int N) {
    int leftRightMin = Math.min(j + 1, N - j);
    int topBottomMin = Math.min(i + 1, N - i);
    return Math.max(1, Math.min(leftRightMin, topBottomMin));
  }

  private static class Point {
    int i;
    int j;

    Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return i == point.i &&
          j == point.j;
    }

    @Override
    public int hashCode() {
      return Objects.hash(i, j);
    }
  }
}

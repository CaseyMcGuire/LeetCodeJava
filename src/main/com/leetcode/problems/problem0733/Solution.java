package main.com.leetcode.problems.problem0733;

import java.util.*;

public class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
      return new int[][]{};
    }
    int[][] newImage = new int[image.length][image[0].length];
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < image[i].length; j++) {
        newImage[i][j] = image[i][j];
      }
    }
    int startingPixelColor = image[sr][sc];
    Point startingPoint = new Point(sr, sc);
    Deque<Point> stack = new ArrayDeque<>();
    Set<Point> visited = new HashSet<>();
    stack.push(startingPoint);
    while (!stack.isEmpty()) {
      Point curPoint = stack.pop();
      if (!isInBounds(curPoint, image) || visited.contains(curPoint)) {
        continue;
      }
      visited.add(curPoint);
      if (image[curPoint.i][curPoint.j] == startingPixelColor) {
        newImage[curPoint.i][curPoint.j] = newColor;
        curPoint.getNeighbors().forEach(stack::push);
      }
    }

    return newImage;
  }

  private boolean isInBounds(Point point, int[][] image) {
    return point.i >= 0 && point.i < image.length && point.j >= 0 && point.j < image[point.i].length;
  }

  private static class Point {
    private final int i;
    private final int j;

    Point(int i, int j) {
      this.i = i;
      this.j = j;
    }

    public List<Point> getNeighbors() {
      return Arrays.asList(
          new Point(i + 1, j),
          new Point(i - 1, j),
          new Point(i, j + 1),
          new Point(i, j - 1));
    }

    public int hashCode() {
      return Objects.hash(i, j);
    }

    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof Point)) {
        return false;
      }
      Point other = (Point) o;
      return other.i == i && other.j == j;
    }
  }
}

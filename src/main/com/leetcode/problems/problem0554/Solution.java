package main.com.leetcode.problems.problem0554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int leastBricks(List<List<Integer>> wall) {
    if (wall.isEmpty() || wall.get(0).isEmpty()) {
      return 0;
    }
    Map<Integer, Integer> brickWidthToPathLength = new HashMap<>();
    for (int i = 0; i < wall.size(); i++) {
      for (Map.Entry<Integer, Integer> entry : brickWidthToPathLength.entrySet()) {
        brickWidthToPathLength.put(entry.getKey(), entry.getValue() + 1);
      }

      int wallWidth = getWallWidth(wall);
      for (int j = 0, sum = wall.get(i).get(j); sum < wallWidth; j++, sum += wall.get(i).get(j)) {
        Integer pathLength = brickWidthToPathLength.get(sum);
        if (pathLength != null) {
          brickWidthToPathLength.put(sum, pathLength - 1);
        }
        else {
          brickWidthToPathLength.put(sum, i);
        }
      }
    }

    Integer min = null;
    for (Map.Entry<Integer, Integer> entry : brickWidthToPathLength.entrySet()) {
      if (min == null || entry.getValue() < min) {
        min = entry.getValue();
      }
    }
    return min == null ? wall.size() : min;
  }

  private int getWallWidth(List<List<Integer>> wall) {
    List<Integer> bricks = wall.get(0);
    int width = 0;
    for (int brickWidth : bricks) {
      width += brickWidth;
    }
    return width;
  }
}

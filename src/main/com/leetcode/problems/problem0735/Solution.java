package main.com.leetcode.problems.problem0735;

import java.util.*;

public class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> rightMovingAsteroids = new LinkedList<>();
    List<Integer> remainingAsteroids = new ArrayList<>();
    for (int i = 0; i < asteroids.length; i++) {
      if (asteroids[i] < 0) {
        Integer left = asteroids[i];
        while (!rightMovingAsteroids.isEmpty()) {
          int right = rightMovingAsteroids.removeLast();
          Integer resultOfCollision = calculateResultOfCollision(left, right);
          if (resultOfCollision == null) {
            left = null;
            break;
          }
          else if (resultOfCollision < 0) {
            left = resultOfCollision;
          }
          else {
            rightMovingAsteroids.addLast(resultOfCollision);
            left = null;
            break;
          }
        }
        if (left != null) {
          remainingAsteroids.add(left);
        }
      }
      else {
        rightMovingAsteroids.addLast(asteroids[i]);
      }
    }

    while (!rightMovingAsteroids.isEmpty()) {
      remainingAsteroids.add(rightMovingAsteroids.removeFirst());
    }
    int[] asteroidsLeft = new int[remainingAsteroids.size()];
    for (int i = 0; i < remainingAsteroids.size(); i++) {
      asteroidsLeft[i] = remainingAsteroids.get(i);
    }
    return asteroidsLeft;
  }

  private Integer calculateResultOfCollision(int left, int right) {
    int leftAbs = Math.abs(left);
    int rightAbs = Math.abs(right);
    if (leftAbs == rightAbs) {
      return null;
    }
    return leftAbs > rightAbs ? left : right;
  }
}

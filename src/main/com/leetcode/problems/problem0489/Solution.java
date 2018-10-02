package main.com.leetcode.problems.problem0489;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
  public void cleanRoom(Robot robot) {
    cleanRoom(robot, Direction.UP, new Point(0, 0), new HashSet<>());
  }

  private void cleanRoom(Robot robot, Direction direction, Point currentPoint, Set<Point> visited) {

    visited.add(currentPoint);
    robot.clean();
    Direction nextDirection = direction;
    for (int i = 0; i < 4; i++) {
      robot.turnRight();
      nextDirection = nextDirection.getRightDirection();
      Point nextPoint = getPointInDirection(currentPoint, nextDirection);
      if (visited.contains(nextPoint)) {
        continue;
      }
      if (robot.move()) {
        cleanRoom(robot, nextDirection, nextPoint, visited);
        robot.turnRight();
        robot.turnRight();
      }
    }
    robot.turnRight();
    robot.turnRight();
    robot.move();
  }

  private Point getPointInDirection(Point point, Direction direction) {
    int i = point.i;
    int j = point.j;
    switch (direction) {
      case RIGHT: return new Point(i, j + 1);
      case LEFT: return new Point(i, j - 1);
      case UP: return new Point(i - 1, j);
      case DOWN: return new Point(i + 1, j);
      default: return null;
    }
  }

  private static class Point {
    private final int i;
    private final int j;

    Point(int i, int j) {
      this.i = i;
      this.j = j;
    }


    public int hashCode() { return Objects.hash(i, j); }

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

  private enum Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    private Direction getRightDirection() {
      switch (this) {
        case UP: return RIGHT;
        case RIGHT: return DOWN;
        case DOWN: return LEFT;
        case LEFT: return UP;
        default: return null;
      }

    }
  }
}



interface Robot {
  // Returns true if the cell in front is open and robot moves into the cell.
  // Returns false if the cell in front is blocked and robot stays in the current cell.
  boolean move();

  // Robot will stay in the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}

package main.com.leetcode.problems.problem0498;

public class Solution {
  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new int[]{};
    }
    int[] nums = new int[matrix.length * matrix[0].length];
    int i = 0;
    int j = 0;
    Direction currentDirection = Direction.LEFT_TO_RIGHT;
    for (int index = 0; index < nums.length; index++) {
      nums[index] = matrix[i][j];
      DirectionState nextState = getNextState(i, j, matrix, currentDirection);
      i = nextState.i;
      j = nextState.j;
      currentDirection = nextState.direction;
    }
    return nums;
  }

  private DirectionState getNextState(int i, int j, int[][] matrix, Direction direction) {
    int newI;
    int newJ;
    if (direction == Direction.LEFT_TO_RIGHT) {
      newI = i - 1;
      newJ = j + 1;
    }
    else { // direction == Direction.RIGHT_TO_LEFT
      newI = i + 1;
      newJ = j - 1;
    }
    boolean isWithinBounds = isWithinBounds(newI, newJ, matrix);
    if (!isWithinBounds) {
      if (direction == Direction.LEFT_TO_RIGHT) {
        // try to go right first
        if (isWithinBounds(i,j + 1, matrix)) {
          return new DirectionState(direction.getOppositeDirection(), i, j + 1);
        }
        else {
          return new DirectionState(direction.getOppositeDirection(), i + 1, j);
        }
      }
      else {
        // try to go down first
        if (isWithinBounds(i + 1, j, matrix)) {
          return new DirectionState(direction.getOppositeDirection(), i + 1, j);
        }
        else {
          return new DirectionState(direction.getOppositeDirection(), i, j + 1);
        }
      }
    }
    else {
      return new DirectionState(direction, newI, newJ);
    }
  }

  private boolean isWithinBounds(int i, int j, int[][] matrix) {
    return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
  }

  private static class DirectionState {
    private Direction direction;
    private int i;
    private int j;
    DirectionState(Direction direction, int i, int j) {
      this.direction = direction;
      this.i = i;
      this.j = j;
    }
  }

  private enum Direction {
    LEFT_TO_RIGHT,
    RIGHT_TO_LEFT;

    private Direction getOppositeDirection() {
      if (this == LEFT_TO_RIGHT) {
        return RIGHT_TO_LEFT;
      }
      else {
        return LEFT_TO_RIGHT;
      }
    }
  }
}

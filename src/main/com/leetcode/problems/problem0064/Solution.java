package main.com.leetcode.problems.problem0064;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int minPathSum(int[][] grid) {
    int[][] minSum = new int[grid.length][grid[0].length];
    for (int i = 0; i < minSum.length; i++) {
      for (int j = 0; j < minSum[i].length; j++) {
        minSum[i][j] = Integer.MAX_VALUE;
      }
    }

    Deque<Node> nodeStack = new ArrayDeque<>();
    nodeStack.push(new Node(0, 0, grid[0][0]));
    while (!nodeStack.isEmpty()) {
      Node currentNode = nodeStack.pop();
      if (currentNode.costSoFar < minSum[currentNode.i][currentNode.j]) {
        minSum[currentNode.i][currentNode.j] = currentNode.costSoFar;
      }
      else {
        continue;
      }
      Node right = currentNode.getRightNeighbor(grid);
      Node down = currentNode.getDownNeighbor(grid);
      if (right != null) {
        nodeStack.push(right);
      }
      if (down != null) {
        nodeStack.push(down);
      }
    }
    return minSum[grid.length - 1][grid[0].length - 1];
  }



  private static class Node {
    private int i;
    private int j;
    private int costSoFar;

    public Node(int i, int j, int costSoFar) {
      this.i = i;
      this.j = j;
      this.costSoFar = costSoFar;
    }

    public Node getRightNeighbor(int[][] grid) {
      return getNeighborNode(i, j + 1, grid);
    }

    private Node getDownNeighbor(int[][] grid) {
      return getNeighborNode(i + 1, j, grid);
    }

    private Node getNeighborNode(int i, int j, int[][] grid) {
      int height = grid.length;
      int width = grid[0].length;
      if (i >= height || j >= width) {
        return null;
      }
      return new Node(i, j, costSoFar + grid[i][j]);
    }

  }
}

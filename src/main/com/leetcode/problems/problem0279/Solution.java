package main.com.leetcode.problems.problem0279;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Solution {
  public int numSquares(int n) {
    return numSquares(n, calculateTreeSet(n), 0);
  }

  private int numSquares(int n, NavigableSet<Integer> possibleSquares, int depth) {
    if (n == 0) {
      return depth;
    }
    if (n < 0) {
      return -1;
    }
    Map<Integer, Integer> numToMinDepth = new HashMap<>();
    numToMinDepth.put(1, 1);
    numToMinDepth.put(0, 0);
    for (int i = 1; i <= n; i++) {
      int minDepth = calculateMinDepthForNum(i, possibleSquares, numToMinDepth);
      numToMinDepth.put(i, minDepth);
    }
    return numToMinDepth.get(n);
  }

  private int calculateMinDepthForNum(int num, NavigableSet<Integer> possibleSquares, Map<Integer, Integer> numToMinDepth) {
    int curMin = Integer.MAX_VALUE;
    for (Integer square : possibleSquares.headSet(num, true).descendingSet()) {
      int prevNum = num - square;
      int prevDepth = numToMinDepth.get(prevNum);
      int currentDepth = prevDepth + 1;
      if (curMin > currentDepth) {
        curMin = currentDepth;
      }
    }
    return curMin;
  }

  private TreeSet<Integer> calculateTreeSet(int num) {
    TreeSet<Integer> squares = new TreeSet<>();
    int curSquare = 0;
    for (int i = 1; curSquare <= num; i++) {
      curSquare = (int)Math.pow(i, 2);
      squares.add(curSquare);
    }
    return squares;
  }

  public static void main(String[] args) {
    System.out.print(new Solution().numSquares(4));
  }
}

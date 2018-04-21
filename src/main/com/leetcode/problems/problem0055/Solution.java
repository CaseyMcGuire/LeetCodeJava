package main.com.leetcode.problems.problem0055;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public boolean canJump(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    Deque<Integer> indices = new ArrayDeque<>();
    indices.push(0);
    while (!indices.isEmpty()) {
      Integer curIndex = indices.pop();
      visited[curIndex] = true;


      if (curIndex + nums[curIndex] >= nums.length - 1) {
        return true;
      }
      for (int i = curIndex + 1; i <= curIndex + nums[curIndex]; i++) {
        if (!visited[i]) {
          indices.push(i);
        }
      }
    }
    return false;
  }
}

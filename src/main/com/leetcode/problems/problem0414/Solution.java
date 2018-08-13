package main.com.leetcode.problems.problem0414;

import java.util.*;

public class Solution {
  public int thirdMax(int[] nums) {

    PriorityQueue<Integer> threeLargest = new PriorityQueue<>();
    for (int num : nums) {
      if (threeLargest.contains(num)) {
        continue;
      }
      if (threeLargest.size() < 3) {
        threeLargest.add(num);
      }
      else {
        int smallest = threeLargest.poll();
        if (smallest < num) {
          threeLargest.add(num);
        }
        else {
          threeLargest.add(smallest);
        }
      }
    }


    if (threeLargest.size() < 3) {
      List<Integer> lst = new ArrayList<>(threeLargest);
      Collections.sort(lst);
      return lst.get(lst.size() - 1);
    }
    else {
      return threeLargest.poll();
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().thirdMax(new int[]{3,2,1}));
  }
}

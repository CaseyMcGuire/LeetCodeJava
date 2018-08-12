package main.com.leetcode.problems.problem0682;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int calPoints(String[] ops) {
    List<Integer> points = new ArrayList<>();
    for (String op : ops) {
      if (op.equals("+")) {
        int size = points.size();
        int last = points.get(size - 1);
        int secondTolast = points.get(size - 2);
        int num = last + secondTolast;
        points.add(num);
      }
      else if (op.equals("D")) {
        int last = points.get(points.size() - 1);
        points.add(2 * last);
      }
      else if (op.equals("C")) {
        points.remove(points.size() - 1);
      }
      else {
        points.add(Integer.parseInt(op));
      }
    }

    int sum = 0;
    for (Integer point : points) {
      sum += point;
    }
    return sum;
  }
}

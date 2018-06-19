package main.com.leetcode.problems.problem0050;

public class Solution {
  public double myPow(double x, int n) {

    if (n == 0 || x == 1.0) {
      return 1.0;
    }
    boolean extraDueToOverflow = false;
    if (n < 0) {
      x = 1.0 / x;
      if (n == (Integer.MIN_VALUE)) {
        n = Integer.MAX_VALUE;
        extraDueToOverflow = true;
      }
      else {
        n = Math.abs(n);
      }
    }

    final double pow;
    if (n % 2 == 0) {
      pow = myPow(x*x, n / 2);
    }
    else {
      pow = x * myPow( x * x, n / 2);
    }
    if (extraDueToOverflow) {
      return pow * x;
    }
    else {
      return pow;
    }
  }
}

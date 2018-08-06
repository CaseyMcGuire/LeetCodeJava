package main.com.leetcode.problems.problem0278;

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int low = 1;
    int high = n;
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (isBadVersion(mid)) {
        if (!isBadVersion(mid - 1)) {
          return mid;
        }
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return low;
  }
}

abstract class VersionControl {
  boolean isBadVersion(int version) {
    return true;
  }
}
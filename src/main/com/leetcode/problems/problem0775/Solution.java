package main.com.leetcode.problems.problem0775;

import java.util.TreeSet;

public class Solution {

  public boolean isIdealPermutation(int[] A) {
    for (int i = A.length - 1; i >= 0; i--) {
      if (Math.abs(A[i] - i) > 1) {
        return false;
      }
    }
    return true;
  }

  // this is the solution I would've come up with in an interview...
  // O(n lg n)
  /*public boolean isIdealPermutation(int[] A) {
    if (A == null || A.length == 0 || A.length == 1) {
      return true;
    }
    TreeSet<Integer> nums = new TreeSet<>();
    nums.add(A[A.length - 1]);
    int numGlobalInversions = 0;
    int numLocalInversions = 0;
    for (int i = A.length - 2; i >= 0; i--) {
      numGlobalInversions += nums.tailSet(A[i], false).size();
      numLocalInversions += A[i + 1] < A[i] ? 1 : 0;
      nums.add(A[i]);
    }

    return numGlobalInversions == numLocalInversions;
  }*/
}

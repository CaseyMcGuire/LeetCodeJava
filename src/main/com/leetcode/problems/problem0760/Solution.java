package main.com.leetcode.problems.problem0760;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public int[] anagramMappings(int[] A, int[] B) {
    Map<Integer, List<Integer>> bNumToIndices = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      List<Integer> indices = bNumToIndices.getOrDefault(B[i], new ArrayList<>());
      indices.add(i);
      bNumToIndices.put(B[i], indices);
    }

    int[] P = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      List<Integer> indices = bNumToIndices.get(A[i]);
      P[i] = indices.get(indices.size() - 1);
      indices.remove(indices.size() - 1);
    }
    return P;
  }
}

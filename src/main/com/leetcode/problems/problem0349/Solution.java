package main.com.leetcode.problems.problem0349;

import java.util.*;

public class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> uniqueNums1 = getUniqueNums(nums1);
    Set<Integer> uniqueNums2 = getUniqueNums(nums2);
    List<Integer> nums = new ArrayList<>();
    for (int num : uniqueNums1) {
      if (uniqueNums2.contains(num)) {
        nums.add(num);
      }
    }

    int[] intersection = new int[nums.size()];
    for (int i = 0; i < nums.size(); i++) {
      intersection[i] = nums.get(i);
    }
    return intersection;
  }

  private Set<Integer> getUniqueNums(int[] nums) {
    Set<Integer> uniqueNums = new HashSet<>();
    for (int i : nums) {
      uniqueNums.add(i);
    }
    return uniqueNums;
  }
}

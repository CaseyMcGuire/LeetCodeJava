package main.com.leetcode.problems.problem0300;

public class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] lengthOfLISAtGivenIndex = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      lengthOfLISAtGivenIndex[i] = lengthOfLIS(nums, lengthOfLISAtGivenIndex, nums[i], i + 1) + 1;
    }
    Integer longestSoFar = null;
    for (int i = 0; i < lengthOfLISAtGivenIndex.length; i++) {
      if (longestSoFar == null || longestSoFar < lengthOfLISAtGivenIndex[i]) {
        longestSoFar = lengthOfLISAtGivenIndex[i];
      }
    }
    return longestSoFar;
  }

  private int lengthOfLIS(int[] nums, int[] cache, int previous, int index) {
    if (index == nums.length) {
      return 0;
    }
    int curNum = nums[index];
    int lisIncludingCurrent = 0;
    if (curNum > previous) {
      lisIncludingCurrent = cache[index];
    }
    int lisNotIncludingCurrent = lengthOfLIS(nums, cache, previous, index + 1);
    return lisIncludingCurrent > lisNotIncludingCurrent ? lisIncludingCurrent : lisNotIncludingCurrent;
  }

}

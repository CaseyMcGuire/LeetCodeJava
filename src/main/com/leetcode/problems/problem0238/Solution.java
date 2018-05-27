package main.com.leetcode.problems.problem0238;

public class Solution {
  public int[] productExceptSelf(int[] nums) {
    if (nums.length == 0) {
      return new int[]{};
    }
    else if (nums.length == 1) {
      return new int[]{1};
    }
    int[] vals = new int[nums.length];
    int[] productsExceptSelf = new int[nums.length];
    vals[vals.length - 1] = nums[nums.length - 1];
    for (int i = nums.length - 2; i >= 0; i--) {
      vals[i] = vals[i + 1] * nums[i];
    }

    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        productsExceptSelf[i] = vals[i + 1];
        vals[i] = nums[i];
      }
      else if (i == nums.length - 1) {
        productsExceptSelf[i] = vals[i - 1];
      }
      else {
        productsExceptSelf[i] = vals[i - 1] * vals[i + 1];
        vals[i] = nums[i] * vals[i - 1];
      }
    }
    return productsExceptSelf;
  }
}

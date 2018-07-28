package main.com.leetcode.problems.problem0080;

public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    boolean seenCurrentElementTwice = false;
    int currentElement = nums[0];
    int currentLength = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == currentElement && !seenCurrentElementTwice) {
        nums[currentLength] = nums[i];
        currentLength++;
        seenCurrentElementTwice = true;
      }
      else if (nums[i] != currentElement) {
        nums[currentLength] = nums[i];
        currentElement = nums[i];
        currentLength++;
        seenCurrentElementTwice = false;
      }
    }
    return currentLength;
  }
}

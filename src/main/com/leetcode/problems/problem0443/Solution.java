package main.com.leetcode.problems.problem0443;

public class Solution {
  public int compress(char[] chars) {
    int currentLength = 0;
    for (int i = 0; i < chars.length; i++) {
      char currentChar = chars[i];
      int numOccurrences = 1;
      int j = i + 1;
      while (j < chars.length && chars[j] == currentChar) {
        numOccurrences++;
        j++;
      }
      chars[currentLength] = currentChar;
      if (numOccurrences != 1) {
        char[] nums = (numOccurrences + "").toCharArray();
        for (int k = 0; k < nums.length; k++) {
          chars[currentLength + 1 + k] = nums[k];
        }
        currentLength = currentLength + 1 + nums.length;
      }
      else {
        currentLength++;
      }
      i = j - 1;
    }
    return currentLength;
  }
}

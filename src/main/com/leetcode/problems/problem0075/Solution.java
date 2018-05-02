package main.com.leetcode.problems.problem0075;

public class Solution {

  public void sortColors(int[] nums) {
    int[] colorFrequency = new int[3];
    for (int num : nums) {
      colorFrequency[num]++;
    }
    int currentNum;
    if (colorFrequency[0] > 0) {
      currentNum = 0;
    }
    else if (colorFrequency[1] > 0) {
      currentNum = 1;
    }
    else if (colorFrequency[2] > 0){
      currentNum = 2;
    }
    else {
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (colorFrequency[currentNum] == 0) {
        currentNum++;
        if (colorFrequency[currentNum] == 0) {
          currentNum++;
        }
      }
      nums[i] = currentNum;
      colorFrequency[currentNum]--;

    }
  }
}

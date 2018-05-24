package main.com.leetcode.problems.problem0189;

class Solution {
  public int[] rotate(int[] arr, int k) {
    k %= arr.length;
    if (k == 0) {
      return arr;
    }
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);
    return arr;
  }

  private void reverse(int[] arr, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }
}

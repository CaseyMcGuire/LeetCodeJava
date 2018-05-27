package main.com.leetcode.problems.problem0344;

public class Solution {
  public String reverseString(String s) {
    char[] reversedString = new char[s.length()];
    char[] str = s.toCharArray();
    for (int i = 0, j = s.length() - 1; i < str.length; i++, j--) {
      reversedString[j] = str[i];
    }
    return new String(reversedString);
  }
}

package main.com.leetcode.problems.problem0014;

public class Solution {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    StringBuilder prefix = new StringBuilder();

    int index = 0;
    while (true) {
      Character curChar = null;
      for (String word : strs) {
        if (word.length() == index) {
          return prefix.toString();
        }
        if (curChar == null) {
          curChar = word.charAt(index);
        }
        else if (curChar != word.charAt(index)) {
          return prefix.toString();
        }
      }
      prefix.append(curChar);
      index++;
    }
  }
}

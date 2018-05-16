package main.com.leetcode.problems.problem0388;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  public int lengthLongestPath(String input) {
    Deque<Integer> previousDirectoryLengths = new ArrayDeque<>();
    int maxLengthSoFar = 0;
    StringBuilder curFile = new StringBuilder();
    boolean isFile = false;
    for (int i = 0; i < input.length();) {
      char curChar = input.charAt(i);
      boolean isEndOfFile = curChar == '\n';
      boolean isEndOfInput = i == input.length() - 1;
      if (isEndOfFile || isEndOfInput) {
        if (isEndOfInput) {
          curFile.append(curChar);
        }
        if (isFile) {
          int totalPathLength = getCurrentPathLength(previousDirectoryLengths, curFile);
          if (totalPathLength > maxLengthSoFar) {
            maxLengthSoFar = totalPathLength;
          }
        }
        else {
          previousDirectoryLengths.push(curFile.length());
        }

          int numNestedDirectoriesInNextFile = 0;
          for (int j = i + 1; j < input.length() && input.charAt(j) == '\t'; j++) {
            numNestedDirectoriesInNextFile++;
          }

          i = i + (numNestedDirectoriesInNextFile + 1);
          //adjust nested directories
          while (previousDirectoryLengths.size() > numNestedDirectoriesInNextFile) {
            previousDirectoryLengths.pop();
          }
          curFile = new StringBuilder();
          isFile = false;
      }
      else{
        if (curChar == '.') {
          isFile = true;
        }
        curFile.append(curChar);
        i++;
      }
    }

    return maxLengthSoFar;
  }

  private int getCurrentPathLength(Deque<Integer> directoryLengths, StringBuilder fileName) {
    int sum = 0;
    for (Integer directoryLength : directoryLengths) {
      //plus one for the trailing '\'
      sum += directoryLength + 1;
    }
    sum += fileName.length();
    return sum;
  }
}

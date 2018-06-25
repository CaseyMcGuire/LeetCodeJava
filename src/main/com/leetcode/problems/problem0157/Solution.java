package main.com.leetcode.problems.problem0157;

class Solution extends Reader4 {
  public int read(char[] buf, int n) {
    int totalNumCharRead = 0;
    char[] temp = new char[4];
    int currentIndex = 0;
    while (totalNumCharRead < n) {
      int numCharsRead = read4(temp);
      for (int i = 0; i < numCharsRead && totalNumCharRead < n; currentIndex++, i++) {
        buf[currentIndex] = temp[i];
        totalNumCharRead++;
      }
      if (numCharsRead < 4) {
        break;
      }
    }
    return totalNumCharRead;
  }
}

abstract class Reader4 {
  int read4(char[] buf) {
    return 0;
  }
}

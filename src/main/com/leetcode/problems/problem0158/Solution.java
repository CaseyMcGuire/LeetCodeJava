package main.com.leetcode.problems.problem0158;

import java.util.Deque;
import java.util.LinkedList;

class Solution extends Reader4 {
  private final Deque<Character> pendingCharacterQueue;
  public Solution() {
    pendingCharacterQueue = new LinkedList<>();
  }

  public int read(char[] buf, int n) {
    char[] temp = new char[4];
    while (pendingCharacterQueue.size() < n) {
      int numCharsRead = read4(temp);
      for (int i = 0; i < numCharsRead; i++) {
        pendingCharacterQueue.addLast(temp[i]);
      }
      if (numCharsRead < 4) {
        break;
      }
    }

    int totalCharsRead = 0;
    for (int i = 0; i < n && !pendingCharacterQueue.isEmpty(); i++) {
      totalCharsRead++;
      buf[i] = pendingCharacterQueue.removeFirst();
    }
    return totalCharsRead;
  }
}

class Reader4 {
  int read4(char[] buf) {
    return 0;
  }
}
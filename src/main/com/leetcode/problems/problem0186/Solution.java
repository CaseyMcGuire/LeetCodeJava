package main.com.leetcode.problems.problem0186;

public class Solution {
  public void reverseWords(char[] str) {
    if (str.length == 0) {
      return;
    }
    char[] temp = new char[str.length];
    Word currentWord = getNextWord(str, 0);
    int iter = currentWord.endIndex;
    for (int i = str.length - 1; i >= 0; i--) {
      char nextChar;
      if (iter >= currentWord.startIndex) {
        nextChar = str[iter];
        iter--;
      }
      else {
        nextChar = ' ';
        currentWord = getNextWord(str, currentWord.endIndex + 2);
        iter = currentWord.endIndex;
      }
      temp[i] = nextChar;
    }
    for (int i = 0; i < temp.length; i++) {
      str[i] = temp[i];
    }
  }

  private Word getNextWord(char[] str, int startIndex) {
    for (int i = startIndex; i < str.length; i++) {
      if (str[i] == ' ') {
        return new Word(startIndex, i - 1);
      }
    }
    return new Word(startIndex, str.length - 1);
  }

  private static class Word {
    int startIndex;
    int endIndex;
    Word(int startIndex, int endIndex) {
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }
  }

}

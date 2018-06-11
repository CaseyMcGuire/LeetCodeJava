package main.com.leetcode.problems.problem0374;

class Solution extends GuessGame {
  public int guessNumber(int n) {
    int high = n;
    int low = 1;
    while (low <= high) {
      int middle = low + ((high - low) / 2);
      int guess = guess(middle);
      if (guess == 0) {
        return middle;
      }
      else if (guess == 1) {
        low = middle + 1;
      }
      else {
        high = middle;
      }
    }
    return low;
  }
}

class GuessGame {
  int number = 1702766719;
    public int guess(int num) {
    if (num < number) {
      return -1;
    }
    else if (num > number) {
      return 1;
    }
    else {
      return 0;
    }
  }
}


package main.com.leetcode.problems.problem0331;

public class Solution {
  public boolean isValidSerialization(String preorder) {
    String[] tokens = preorder.split(",");
    IntReference index = new IntReference();
    boolean isValidSerialization = isValidSerialization(tokens, index);
    return isValidSerialization && index.num == tokens.length - 1;
  }

  private boolean isValidSerialization(String[] tokens, IntReference currentIndex) {
    if (currentIndex.num >= tokens.length) {
      return false;
    }
    if (tokens[currentIndex.num].equals("#")) {
      return true;
    }
    currentIndex.num++;
    boolean isLeftValid = isValidSerialization(tokens, currentIndex);
    if (!isLeftValid) {
      return false;
    }
    currentIndex.num++;
    return isValidSerialization(tokens, currentIndex);
  }

  private static class IntReference {
    int num;
    IntReference() {
      num = 0;
    }
  }
}
